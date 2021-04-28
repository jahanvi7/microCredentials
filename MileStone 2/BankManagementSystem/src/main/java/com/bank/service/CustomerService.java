package com.bank.service;

import com.bank.model.CustomerDetails;
import com.bank.model.Loan;

public interface CustomerService {

	CustomerDetails login(String id, String password);

	boolean newRegisteration(CustomerDetails customerDetails);

	void applyLoan(Loan loan,CustomerDetails customerDetails);

	void updateDetails(CustomerDetails customerDetails,CustomerDetails cust);
}
