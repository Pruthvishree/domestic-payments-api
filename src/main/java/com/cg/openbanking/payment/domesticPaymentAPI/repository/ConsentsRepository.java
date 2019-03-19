package com.cg.openbanking.payment.domesticPaymentAPI.repository;







import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.openbanking.payment.domesticPaymentAPI.model.Consents;
import com.cg.openbanking.payment.domesticPaymentAPI.model.Payments;



@Repository
@Transactional
public class ConsentsRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	public Consents find(String consentID) {
		return entityManager.find(Consents.class, consentID);
	}
	
	
	public void savePayment(Payments payment) {
		entityManager.merge(payment);
	}


	@Modifying
	//@Query("update consents set status = ?1, status_update_date = ?2  where consent_id = ?3")
	@Query("UPDATE Consents c SET c.status=:status1,c.status_update_date=:status_update_date1 WHERE c.consent_id=:consentId")
	public int updateConsentStatus(@Param(value = "status1") String status1,@Param (value = "status_update_date1") Date status_update_date1,  @Param(value = "consentId") String consentId) {
		return 0;
		
	}
	
	
	/*
	 * public static final String GET_ACCT_ID =
	 * "select * from account a where AccountId = ?"; public Account
	 * findAcctId(String acctId) { Account account= (Account)
	 * entityManager.createNativeQuery(GET_ACCT_ID); return account; }
	 */
}
