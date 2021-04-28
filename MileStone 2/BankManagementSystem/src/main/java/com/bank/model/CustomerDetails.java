package com.bank.model;

import java.util.List;

public class CustomerDetails {

	private String username;
	private String name;
	private String password;
	private String address;
	private String state;
	private String country;
	private String email;
	private String pan;
	private String contactNo;
	private String dateOfBirth;
	private String accountType;
	private List<Loan> loan;

	public CustomerDetails() {
		super();
	}

	public CustomerDetails(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public CustomerDetails(String username, String name, String password, String address, String state, String country,
			String email, String pan, String contactNo, String dateOfBirth, String accountType,
			List<com.bank.model.Loan> loan) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
		this.address = address;
		this.state = state;
		this.country = country;
		this.email = email;
		this.pan = pan;
		this.contactNo = contactNo;
		this.dateOfBirth = dateOfBirth;
		this.accountType = accountType;
		this.loan = loan;
	}

	public List<Loan> getLoan() {
		return loan;
	}

	public void setLoan(List<Loan> loan) {
		this.loan = loan;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "CustomerDetails [username=" + username + ", name=" + name + ", password=" + password + ", address="
				+ address + ", state=" + state + ", country=" + country + ", email=" + email + ", pan=" + pan
				+ ", contactNo=" + contactNo + ", dateOfBirth=" + dateOfBirth + ", accountType=" + accountType
				+ ", loan=" + loan + "]";
	}


}
