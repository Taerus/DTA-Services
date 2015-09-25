package com.dta.services.service;

import com.dta.services.model.User;

public interface IPaymentService {
	public void creditTransfert(User from, User to, int sum);
	public void creditRequest(User from, User to, int sum);
}
