package com.dta.services.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dta.services.dao.IPaymentDao;
import com.dta.services.model.Payment;
import com.dta.services.model.StatePayment;
import com.dta.services.model.User;

@Service("paymentService")
public class PaymentServiceImpl implements IPaymentService {
	@Autowired
	IPaymentDao paymentDao;
	
	@Transactional(rollbackFor=Exception.class)
	public void creditTransfert(User from, User to, int sum) {
		paymentDao.create(new Payment(from, to, sum, StatePayment.DONE));
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void creditRequest(User from, User to, int sum) {
		paymentDao.create(new Payment(from, to, sum, StatePayment.PENDING));
	}

}
