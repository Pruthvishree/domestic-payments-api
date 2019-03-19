package com.cg.openbanking.payment.domesticPaymentAPI.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HystrixService {
	private final RestTemplate restTemplate;

	public HystrixService(RestTemplate rest) {
		this.restTemplate = rest;
	}

	@HystrixCommand(fallbackMethod = "reliable")
	public String readingList() {
		//URI uri = URI.create("https://domesticpayment.cfapps.io/user/message");
		return "reading list method called";
		//return this.restTemplate.getForObject(uri, String.class);
	}

	public String reliable() {
		//URI uri = URI.create("http://partydetailssoap.cfapps.io/ws/party.wsdl");
		return "server is down, so calling party details";
		//return this.restTemplate.getForObject(uri, String.class);
	}
}
