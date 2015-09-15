package com.dta.services.dao;

import java.util.List;

import com.dta.services.model.Payment;

public interface IPaymentDao {
	void create(Payment payment);
	Payment getById(int id);
	List<Payment> list();
	void update(Payment payment);
	void delete(int id);
}
