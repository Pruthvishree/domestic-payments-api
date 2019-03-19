package com.cg.openbanking.payment.domesticPaymentAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.openbanking.payment.domesticPaymentAPI.xml.GetPartyRequest;
import com.cg.openbanking.payment.domesticPaymentAPI.xml.GetPartyResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class PartyDetailsController {

	@Autowired
	SOAPConnector soapConnector;

	@HystrixCommand(fallbackMethod = "reliable")
	@RequestMapping("/user/test/{accountId}")
	public String getPartyDetails(@PathVariable("accountId") String accountId) {
		String json = "";
		GetPartyRequest request = new GetPartyRequest();
		request.setAccountid(accountId);
		GetPartyResponse response = (GetPartyResponse) soapConnector.callWebService("http://partydetailssoap.cfapps.io/ws/party", request);
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
		//return response;
	}
	
	public String reliable(@PathVariable("accountId") String accountId) {
		//URI uri = URI.create("http://partydetailssoap.cfapps.io/ws/party.wsdl");
		return "fallback method called";
		//return this.restTemplate.getForObject(uri, String.class);
	}

}
