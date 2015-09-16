package com.dta.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.dta.services.model.Payment;

@Repository("paymentDao")
public class PaymentDaoImpl implements IPaymentDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void create(Payment payment) {
		// TODO Auto-generated method stub
		em.persist(payment);
	}

	@Override
	public Payment getById(int id) {
		// TODO Auto-generated method stub
		return em.find(Payment.class, id);
	}

	@Override
	public List<Payment> list() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("SELECT p FROM Payment");
		return req.getResultList();
	}

	@Override
	public void update(Payment payment) {
		// TODO Auto-generated method stub
		em.merge(payment);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Payment payment = em.find(Payment.class, id);
		em.remove(payment);
	}

}
