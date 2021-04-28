package com.bank.model;

import org.jnosql.artemis.Entity;

@Entity
public class Loan {

	private CustomerDetails customerDetails;
	private String loanType;
	private double loanAmount;
	private String date;
	private float rateOfInterest;
	private int durationOfLoan;

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public int getDurationOfLoan() {
		return durationOfLoan;
	}

	public void setDurationOfLoan(int durationOfLoan) {
		this.durationOfLoan = durationOfLoan;
	}

	public Loan() {
		super();
	}

	public Loan(CustomerDetails customerDetails, String loanType, double loanAmount, String date, float rateOfInterest,
			int durationOfLoan) {
		super();
		this.customerDetails = customerDetails;
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.date = date;
		this.rateOfInterest = rateOfInterest;
		this.durationOfLoan = durationOfLoan;
	}

	@Override
	public String toString() {
		return "Loan [customerDetails=" + customerDetails + ", loanType=" + loanType + ", loanAmount=" + loanAmount
				+ ", date=" + date + ", rateOfInterest=" + rateOfInterest + ", durationOfLoan=" + durationOfLoan + "]";
	}

}
