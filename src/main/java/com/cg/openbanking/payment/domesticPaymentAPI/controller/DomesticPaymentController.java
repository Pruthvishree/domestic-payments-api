package com.cg.openbanking.payment.domesticPaymentAPI.controller;

import java.util.Date;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.openbanking.payment.domesticPaymentAPI.Exception.BadRequestException;
import com.cg.openbanking.payment.domesticPaymentAPI.Exception.ConsentNotFoundException;
import com.cg.openbanking.payment.domesticPaymentAPI.Exception.DependencyFailedException;
import com.cg.openbanking.payment.domesticPaymentAPI.model.Account;
import com.cg.openbanking.payment.domesticPaymentAPI.model.Consents;
import com.cg.openbanking.payment.domesticPaymentAPI.model.Payments;
import com.cg.openbanking.payment.domesticPaymentAPI.repository.AccountRepository;
import com.cg.openbanking.payment.domesticPaymentAPI.repository.ConsentsRepository;
import com.cg.openbanking.payment.domesticPaymentAPI.request.CreditorAccount;
import com.cg.openbanking.payment.domesticPaymentAPI.request.Data;
import com.cg.openbanking.payment.domesticPaymentAPI.request.DebtorAccount;
import com.cg.openbanking.payment.domesticPaymentAPI.request.Initiation;
import com.cg.openbanking.payment.domesticPaymentAPI.request.InstructedAmount;
import com.cg.openbanking.payment.domesticPaymentAPI.request.PaymentRequest;
import com.cg.openbanking.payment.domesticPaymentAPI.request.PaymentResponse;
import com.cg.openbanking.payment.domesticPaymentAPI.request.RemittanceInformation;
import com.cg.openbanking.payment.domesticPaymentAPI.service.HystrixService;
import com.cg.openbanking.payment.domesticPaymentAPI.xml.GetPartyRequest;
import com.cg.openbanking.payment.domesticPaymentAPI.xml.GetPartyResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/user")

public class DomesticPaymentController extends ExceptionHandlerController {

	private static final Logger logger = LoggerFactory.getLogger(DomesticPaymentController.class);

	@Autowired
	private ConsentsRepository consentservice;

	@Autowired
	private AccountRepository accountService;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	HystrixService service;
	
	@Autowired
	SOAPConnector soapConnector;
	
	@Value("${message}")
	private String message;

	@GetMapping("/message")
	public String getMessage() {
		logger.info("message from git hub::"+ message);
		return message;
	}

	@Bean
	public RestTemplate rest(RestTemplateBuilder builder) {
		return builder.build();
	}

	

	//@HystrixCommand(fallbackMethod = "reliable")
	@RequestMapping("/user/test/{accountId}")
	public String getPartyDetails(@PathVariable("accountId") String accountId) {
		String json = "";
		GetPartyRequest request = new GetPartyRequest();
		//request.setAccountid("1112019");
		GetPartyResponse response = (GetPartyResponse) soapConnector
				.callWebService("http://partydetailssoap.cfapps.io/ws/party", request);
		System.out.println("Got Response As below ========= : ");
		System.out.println("Name : " + response.getPartyinfo().getName());
		System.out.println("Standard : " + response.getPartyinfo().getPartyType());
		System.out.println("Address : " + response.getPartyinfo().getAddressinfo());
		ObjectMapper mapper = new ObjectMapper();
		try {
			json = mapper.writeValueAsString(response);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		} 
		return json;
	}
	
	public String reliable(@PathVariable("accountId") String accountId) {
		//URI uri = URI.create("http://partydetailssoap.cfapps.io/ws/party.wsdl");
		return "fallback method called";
		//return this.restTemplate.getForObject(uri, String.class);
	}
	
	
	@GetMapping("/to-read")
	@HystrixCommand(fallbackMethod = "reliable")
	public String toRead() {
		return service.readingList();
	}
	
	public String reliable() {
		//URI uri = URI.create("http://partydetailssoap.cfapps.io/ws/party.wsdl");
		return "server is down, so calling party details";
		//return this.restTemplate.getForObject(uri, String.class);
	}
	
	@ResponseBody
	@PostMapping(value = "/domestic-payments", consumes = "application/json")
	
	public ResponseEntity<Object> payments(@Valid @RequestBody PaymentRequest paymentRequest) {

		PaymentResponse paymentResponse = new PaymentResponse();
		logger.info("myBean details:: " + paymentRequest);
		logger.info("consent id::" + paymentRequest.getData().getConsentId());

		if (paymentRequest.getData().getConsentId() != null) {
			Consents consent = consentservice.find(paymentRequest.getData().getConsentId());
			logger.info("consent details" + consent);
			if (consent != null) {
				if (consent.getStatus().equalsIgnoreCase("authorized")) {
					if (paymentValidation(paymentRequest, consent)) {
						logger.info("payment validation result" + paymentValidation(paymentRequest, consent));
						Payments payment = new Payments();
						payment.setConsent_id(paymentRequest.getData().getConsentId());
						payment.setPaymentId(UUID.randomUUID().toString());
						payment.setStatus("1");
						payment.setCreationDate(new Date());
						payment.setStatusUpdationDate(new Date());
						consentservice.savePayment(payment);
						consent.setStatus("consumed");
						consentservice.updateConsentStatus(consent.getStatus(), new Date(), consent.getConsentId());

						logger.info("paymentid:" + payment.getPaymentId());
						paymentResponse = generateResponse(paymentRequest, payment.getPaymentId());

						return new ResponseEntity<Object>(paymentResponse, HttpStatus.CREATED);
					} else {
						throw new BadRequestException();
					}
				} else {
					throw new DependencyFailedException();

				}
			} else if (consent == null) {
				throw new ConsentNotFoundException();
			}
		}

		return new ResponseEntity<Object>(paymentResponse, HttpStatus.OK);
	}

	public boolean paymentValidation(PaymentRequest paymentRequest, Consents consent) {
		System.out.println("creditor ID" + consent.getCreditor_id());
		System.out.println("debitor ID" + consent.getDebtor_id());

		// List<Account> accountList = accountService.findDetails();

		Account creditorAccount = accountService.find(consent.getCreditor_id());
		logger.info("creditor account:" + creditorAccount);

		Account debtorAccount = accountService.find(consent.getDebtor_id());
		logger.info("debtorAccount details:" + debtorAccount);
		// logger.info("debitor namee:" +account1);

		logger.info("debtor identifica:" + paymentRequest.getData().getInitiation().getInstructionIdentification()
				.equalsIgnoreCase(consent.getInstruction_identification()));
		logger.info("debtor name:" + paymentRequest.getData().getInitiation().getEndToEndIdentification()
				.equalsIgnoreCase(consent.getEnd_to_end_identification()));
		logger.info("debtor sche name:" + paymentRequest.getData().getInitiation().getInstructedAmount().getAmount()
				.equalsIgnoreCase(consent.getPayment_amount()));

		logger.info("4" + paymentRequest.getData().getInitiation().getInstructedAmount().getCurrency()
				.equalsIgnoreCase(consent.getPayment_currency()));
		logger.info("5" + paymentRequest.getData().getInitiation().getCreditorAccount().getIdentification()
				.equalsIgnoreCase(creditorAccount.getIdentification()));
		logger.info("6" + paymentRequest.getData().getInitiation().getCreditorAccount().getSchemeName()
				.equalsIgnoreCase(creditorAccount.getSchemeName()));
		logger.info("7" + paymentRequest.getData().getInitiation().getCreditorAccount().getName()
				.equalsIgnoreCase(creditorAccount.getName()));
		logger.info("8" + paymentRequest.getData().getInitiation().getDebtorAccount().getIdentification()
				.equalsIgnoreCase(debtorAccount.getIdentification()));
		logger.info("9" + paymentRequest.getData().getInitiation().getDebtorAccount().getSchemeName()
				.equalsIgnoreCase(debtorAccount.getSchemeName()));
		logger.info("10" + paymentRequest.getData().getInitiation().getDebtorAccount().getName()
				.equalsIgnoreCase(debtorAccount.getName()));

		if (paymentRequest.getData().getInitiation().getInstructionIdentification()
				.equalsIgnoreCase(consent.getInstruction_identification())
				&& paymentRequest.getData().getInitiation().getEndToEndIdentification()
						.equalsIgnoreCase(consent.getEnd_to_end_identification())
				&& paymentRequest.getData().getInitiation().getInstructedAmount().getAmount()
						.equalsIgnoreCase(consent.getPayment_amount())
				&& paymentRequest.getData().getInitiation().getInstructedAmount().getCurrency()
						.equalsIgnoreCase(consent.getPayment_currency())
				&& paymentRequest.getData().getInitiation().getCreditorAccount().getIdentification()
						.equalsIgnoreCase(creditorAccount.getIdentification())
				&& paymentRequest.getData().getInitiation().getCreditorAccount().getSchemeName()
						.equalsIgnoreCase(creditorAccount.getSchemeName())
				&& paymentRequest.getData().getInitiation().getCreditorAccount().getName()
						.equalsIgnoreCase(creditorAccount.getName())
				&& paymentRequest.getData().getInitiation().getDebtorAccount().getIdentification()
						.equalsIgnoreCase(debtorAccount.getIdentification())
				&& paymentRequest.getData().getInitiation().getDebtorAccount().getSchemeName()
						.equalsIgnoreCase(debtorAccount.getSchemeName())
				&& paymentRequest.getData().getInitiation().getDebtorAccount().getName()
						.equalsIgnoreCase(debtorAccount.getName())) {
			return true;
		}
		return false;

	}

	public PaymentResponse generateResponse(PaymentRequest paymentRequest, String paymentId) {
		Consents consent = consentservice.find(paymentRequest.getData().getConsentId());
		logger.info("consent id after success:" + consent.getConsentId());
		PaymentResponse response = new PaymentResponse();
		
		
		
		Data data = new Data();
			data.setConsentId(consent.getConsentId());
		
			response.setDomesticPaymentId(paymentId);
			response.setStatus("AcceptedSettlementInProcess");
			response.setCreationDateTime(consent.getCreationDate());
			response.setStatusUpdateDateTime(consent.getStatusUpdationDate());
		Initiation initiation = new Initiation();
		initiation.setEndToEndIdentification(consent.getEnd_to_end_identification());
		initiation.setInstructionIdentification(consent.getInstruction_identification());

		InstructedAmount instructedAmount = new InstructedAmount();
		instructedAmount.setAmount(consent.getPayment_amount());
		instructedAmount.setCurrency(consent.getPayment_currency());
		initiation.setInstructedAmount(instructedAmount);

		Account account = accountService.find(consent.getCreditor_id());
		CreditorAccount creditorAccount = new CreditorAccount();
		creditorAccount.setSchemeName(account.getSchemeName());
		creditorAccount.setIdentification(account.getIdentification());
		creditorAccount.setName(account.getName());
		initiation.setCreditorAccount(creditorAccount);

		Account account1 = accountService.find(consent.getDebtor_id());
		DebtorAccount debtorAccount = new DebtorAccount();
		debtorAccount.setSchemeName(account1.getSchemeName());
		debtorAccount.setIdentification(account1.getIdentification());
		debtorAccount.setName(account1.getName());
		initiation.setDebtorAccount(debtorAccount);

		RemittanceInformation remittanceInformation = new RemittanceInformation();
		remittanceInformation.setReference(consent.getRemittence_reference());
		remittanceInformation.setUnstructured(consent.getRemittence_unstructured());
		initiation.setRemittanceInformation(remittanceInformation);
		data.setInitiation(initiation);
		response.setData(data);
		return response;
	}
}
