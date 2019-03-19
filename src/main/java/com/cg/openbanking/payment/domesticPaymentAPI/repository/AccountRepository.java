package com.cg.openbanking.payment.domesticPaymentAPI.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.openbanking.payment.domesticPaymentAPI.model.Account;


@Repository
@Transactional
public class AccountRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Account find(String identification) {
		return entityManager.find(Account.class, identification);
	}

	public List<Account> findDetails() {
		@SuppressWarnings("unchecked")
		List<String> accountList = (List<String>) entityManager.createQuery("SELECT a FROM Account a").getResultList();
		System.out.println("accountList data: " + accountList);
		return new ArrayList<Account>();
	}

}
