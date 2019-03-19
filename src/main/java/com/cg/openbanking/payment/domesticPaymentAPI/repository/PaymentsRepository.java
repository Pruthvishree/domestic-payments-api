package com.cg.openbanking.payment.domesticPaymentAPI.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.openbanking.payment.domesticPaymentAPI.model.Payments;


@Repository
@Transactional
public class PaymentsRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	public Payments findPaymentId(String consentID) {
		return entityManager.find(Payments.class, consentID);
	}
}
