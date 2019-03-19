package com.cg.openbanking.payment.domesticPaymentAPI.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.cg.openbanking.payment.domesticPaymentAPI.controller.SOAPConnector;

@Configuration
public class Config {
	@Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
       
        marshaller.setContextPath("com.cg.openbanking.payment.domesticPaymentAPI.xml");
        return marshaller;
    }
 
    @Bean
    public SOAPConnector soapConnector(Jaxb2Marshaller marshaller) {
        SOAPConnector client = new SOAPConnector();
        client.setDefaultUri("http://partydetailssoap.cfapps.io/ws/party");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}