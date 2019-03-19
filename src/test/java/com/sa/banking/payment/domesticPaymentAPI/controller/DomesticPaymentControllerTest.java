package com.sa.banking.payment.domesticPaymentAPI.controller;

import java.io.File;
import java.io.FileReader;
import java.net.URISyntaxException;

import org.json.simple.parser.JSONParser;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cg.openbanking.payment.domesticPaymentAPI.request.PaymentRequest;
import com.cg.openbanking.payment.domesticPaymentAPI.request.PaymentResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DomesticPaymentControllerTest {
	private static final Logger logger = LoggerFactory.getLogger(DomesticPaymentControllerTest.class);

	public PaymentRequest readJSONFile(String filename) throws URISyntaxException {

		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();

		PaymentRequest paymentRequest = null;
		Object obj = null;

		File f = new File("src/test/java/resources/" + filename + ".json");

		try (FileReader reader = new FileReader(f)) {
			obj = jsonParser.parse(reader);

			ObjectMapper mapper = new ObjectMapper();

			paymentRequest = mapper.readValue(obj.toString(), PaymentRequest.class);

			logger.info("pruthvi test: " + paymentRequest);

		} catch (Exception e) {

		}
		return paymentRequest;

	}

	@Test
	public void testInternationalPaymentProcessing() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://domesticpayment.cfapps.io/user/domestic-payments";
		//final String baseUrl = "http://localhost:8080/user/domestic-payments";

		java.net.URI uri = new java.net.URI(baseUrl);

		PaymentRequest paymentRequest = readJSONFile("request");

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic dXNlcjpwYXNzd29yZA==");
		headers.add("Content-Type", "application/json");
		logger.info("paymentData : " + paymentRequest);

		HttpEntity<PaymentRequest> entity = new HttpEntity<PaymentRequest>(paymentRequest, headers);

		ResponseEntity<PaymentResponse> resp = restTemplate.postForEntity(uri, entity, PaymentResponse.class);

		logger.info("Response2 : " + resp.getBody().getDomesticPaymentId());
		logger.info("Response3 : " + "");

		/// Verify request succeed //
		org.junit.Assert.assertEquals(201, resp.getStatusCodeValue());

	}

	
	@Test(expected = HttpClientErrorException.BadRequest.class)
	public void testBadRequestOnInternationalPaymentProcessing() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://domesticpayment.cfapps.io/user/domestic-payments";
	//	final String baseUrl = "http://localhost:8080/user/domestic-payments";
		java.net.URI uri = new java.net.URI(baseUrl);

		PaymentRequest paymentRequest = readJSONFile("request400");

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic dXNlcjpwYXNzd29yZA==");
		headers.add("Content-Type", "application/json");
		logger.info("paymentRequest : " + paymentRequest);

		HttpEntity<PaymentRequest> entity = new HttpEntity<PaymentRequest>(paymentRequest, headers);

		ResponseEntity<PaymentResponse> resp = restTemplate.postForEntity(uri, entity, PaymentResponse.class);

		logger.info("Response2 : " + resp.getBody());
		logger.info("Response3 : " + "");

		/// Verify request succeed //
		// org.junit.Assert.assertEquals(400, resp.getStatusCodeValue());

	}

	@Test(expected = HttpClientErrorException.MethodNotAllowed.class)
	public void testMethodNotAllowedProcessing() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://domesticpayment.cfapps.io/user/domestic-payments";
		//final String baseUrl = "http://localhost:8080/user/domestic-payments";
		
		PaymentRequest paymentrequest = readJSONFile("request415");

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic dXNlcjpwYXNzd29yZA==");
		headers.add("Content-Type", "application/json");
		logger.info("paymentrequest : " + paymentrequest);

		HttpEntity<PaymentRequest> entity = new HttpEntity<PaymentRequest>(paymentrequest, headers);

		ResponseEntity<PaymentResponse> resp = restTemplate.exchange(baseUrl, HttpMethod.GET, entity,
				PaymentResponse.class);

		
		logger.info("Response3 : " + "");

		/// Verify request succeed //
		 org.junit.Assert.assertEquals(405, resp.getStatusCode());

	}
	
	@Test(expected = HttpClientErrorException.Unauthorized.class)
	public void testUnAuthorisedProcessing() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://domesticpayment.cfapps.io/user/domestic-payments";
	//	final String baseUrl = "http://localhost:8080/user/domestic-payments";
	//	java.net.URI uri = new java.net.URI(baseUrl);

		PaymentRequest paymentrequest = readJSONFile("request415");

		HttpHeaders headers = new HttpHeaders();
	//	headers.add("Authorization", "Basic dXNlcjpwYXNzd29yZA==");
		headers.add("Content-Type", "application/json");
//		logger.info("paymentrequest : " + paymentrequest);

		HttpEntity<PaymentRequest> entity = new HttpEntity<PaymentRequest>(paymentrequest, headers);
		//logger.info("befre calling response");
		ResponseEntity<PaymentResponse> resp = restTemplate.exchange(baseUrl, HttpMethod.GET, entity,PaymentResponse.class);

		// logger.info("Response2 : " + resp.getBody());
		logger.info("Response3 : " + "");

		/// Verify request succeed //
		 org.junit.Assert.assertEquals(401, resp.getStatusCode());

	}

}
