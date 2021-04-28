package com.bank.service;

import com.bank.model.CustomerDetails;
import com.bank.model.Loan;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.error.DocumentAlreadyExistsException;

import io.vertx.core.json.Json;

public class CustomerServiceImpl implements CustomerService {

	private Cluster cluster;
	private Bucket bucket;

	public CustomerServiceImpl() {
		cluster = CouchbaseCluster.create("172.18.0.2"); //used when we are creating docker image
//		cluster = CouchbaseCluster.create("localhost"); //used in local system
		cluster.authenticate("Administrator", "couchbase");
		bucket = cluster.openBucket("bank");
	}

	@Override
	public CustomerDetails login(String id, String password) {
		// TODO Auto-generated method stub
		JsonDocument user = bucket.get(id);
		if (user != null) {
			String userString = user.content().toString();
			boolean c = user.content().containsValue(password);
			if (c == true) {
				CustomerDetails customer = Json.decodeValue(userString, CustomerDetails.class);
				return customer;
			}
		}
		return null;
	}

	@Override
	public boolean newRegisteration(CustomerDetails customerDetails) {
		// TODO Auto-generated method stub
		try {
			JsonObject user = JsonObject.empty().put("username", customerDetails.getUsername())
					.put("password", customerDetails.getPassword()).put("name", customerDetails.getName())
					.put("address", customerDetails.getAddress()).put("state", customerDetails.getState())
					.put("country", customerDetails.getCountry()).put("contactNo", customerDetails.getContactNo())
					.put("pan", customerDetails.getPan()).put("dateOfBirth", customerDetails.getDateOfBirth())
					.put("accountType", customerDetails.getAccountType()).put("email", customerDetails.getEmail());
			JsonDocument userInsert = JsonDocument.create(customerDetails.getUsername(), user);
			bucket.insert(userInsert);
			return true;
		} catch (DocumentAlreadyExistsException e) {
			return false;
		}
	}

	@Override
	public void applyLoan(Loan loan) {
		// TODO Auto-generated method stub
		try {
			JsonObject user = JsonObject.empty().put("customerDetails", loan.getCustomerDetails().toString())
					.put("loanType", loan.getLoanAmount()).put("loanAmount", loan.getLoanAmount())
					.put("date", loan.getDate()).put("durationOfLoan", loan.getDurationOfLoan())
					.put("rateOfInterest", loan.getRateOfInterest());
			JsonDocument userInsert = JsonDocument.create(loan.getCustomerDetails().getUsername() + loan.getLoanType(),
					user);
			bucket.insert(userInsert);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	@Override
	public void updateDetails(CustomerDetails customerDetails) {
		// TODO Auto-generated method stub
		try {
			JsonObject user = JsonObject.empty().put("username", customerDetails.getUsername())
					.put("password", customerDetails.getPassword()).put("name", customerDetails.getName())
					.put("address", customerDetails.getAddress()).put("state", customerDetails.getState())
					.put("country", customerDetails.getCountry()).put("contactNo", customerDetails.getContactNo())
					.put("pan", customerDetails.getPan()).put("dateOfBirth", customerDetails.getDateOfBirth())
					.put("accountType", customerDetails.getAccountType()).put("email", customerDetails.getEmail());
			JsonDocument userInsert = JsonDocument.create(customerDetails.getUsername(), user);
			bucket.upsert(userInsert);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
