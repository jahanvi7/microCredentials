package com.bank.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.bank.model.CustomerDetails;
import com.bank.model.Loan;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class CustomerServiceImpl implements CustomerService {

	FirebaseOptions options;
	FirebaseApp app;
	Firestore fireStore;

	@SuppressWarnings("deprecation")
	public CustomerServiceImpl() {

		GoogleCredentials credentials;
		try {
			String str = "{\r\n"
					+ "  \"type\": \"service_account\",\r\n"
					+ "  \"project_id\": \"testij89\",\r\n"
					+ "  \"private_key_id\": \"e69e25e6b689cf20834da09c5f6b6c4e291cafd5\",\r\n"
					+ "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCE0FoxHH2AGgk4\\nzYy8OUtslTIfjcXoHdsQpjyPoy08EkuyttkUJBsu8y30rc6cDF+t+zBAZ/G/OnsS\\n66a790yNpOHIfxB8b6BappJCwqmFuLAzybdngVLOOShfxNYkwyT4CAp/rUjUdCFw\\nOUU3v8Q+JucxsngzU2ufCYSiSGL6H5V4ToPOqrIhvwwCwCs0ro/mACAhlI1AJ5/o\\nmuFUDu3D1HIYJrVOlfDJWjmGdxjpr3XlxsnLPSzKbXyZ/FjFCTO4ewUZpjSJiBp6\\n9Mtz5ClAVWJJyLyApjaggopGUMfO9Z2gPuHtF8hJPPVrSZNp7+pj8P6p/bEyv+mw\\nlHcvCm2TAgMBAAECggEABfZ4u3sPo2BdM6CpheB9+LpbYrvxu7HDc7mS6dFQpuwc\\nsUGw+KIvr5REEZfQDoTRCDWefUsYDmwoubkSEPRRtTZG2202Ue/iX3ovrNxNJ29w\\nRxLyWgJIs8YwgC7ifQoJ2dzlORrlidb2PVyaNUjgcviPfqqy532s95nsy4BmeTDr\\nQoZgKgXtE7I8pbkmZ1HId++DBSH/iMypVTD9gq+oLo4sdo7zLf7zEofZHzcQ50d+\\nbTndxEXsotV30L+zjmlBSDhJH83V/YhsTYMXufs4GEj6FScD8pSe7fHKOdJHJoOj\\nhVAFdPJhLMlLD6dnfJuvvfhbAwhGbBFHB3gW1M+wGQKBgQC6O7G5zmK9JMPV0dtm\\nEPUnCSmFDehDZas7PQ4RN8HgfeltNazZRI6Umb2PtMW0ANyRq3diZ438Ew2IviJ5\\n+SvSVBF1UEYwfxwpo+ZaPiJjBTthWU+q7cl5qfhgKrcfMgrY35lPvAKu2ZqLnFRY\\nSvtEgm1Zt9FCumfx6sBPQnsKdwKBgQC2kZc/bJhtuiIweyf8ShPbJ5tjQAPuqPZr\\n/czndMzf9CF0PxJ9jjy/KCLqHGKznqGdI7Ey8Rh5pe+DfIjmPXPl6zFiTcW25Hrr\\nidGiKKcdbL8jPMS52Vhx6jWUfd93/qwBXuvOBoWWVTsfKX2Oh4WC2PM+y+UiXkSd\\ne5o98fegxQKBgQCyrV9BI/C8BDAYT7YuYQq0nyfEzqkPMNZuiY+bmWFcH7H748mo\\n0wvxKuginpAoucLlyBtMwIoLVcRgc/vkBtqye5Iceh49nVbJ5MS3xHF9i6GDLwsu\\nteHd5uO0cIctWPfrR+xyAbKZS5HpbN3HsHkPLAv6TlBpsyrTgiVsZh5i1QKBgH4E\\nrubbmbeb1H+scuRFacFLbImspUo2nKncLXTSfZxUkkcARk4eQTYdiUQZxdOAOsQR\\n3/1ux9soO9SBwKlUX8yjdJoLXt8ohORSZD5PW1MHPkQfbRdvvAodhVBzNi5IvwfP\\nMmsqu0kSmdWfuQgJ6ZFxGS4OZaI8eZZOvB/oBmqVAoGAP8m5n7ptPjyFAlRmk4Sy\\n1bOKa2AVFCPVyAXxFIHxMwW3YSgKh6Xp0mWW865r4W1YBGaotH6Qau4GFc+5JIYJ\\nWtqQsw39JDAvTMD7kO2b//Y2e5JWPplNNrB6BPpyM3pREdR2WVSpLdG1Ydi0lkx7\\n7rTU9Yqj+u9OdCoHuUr9l8Y=\\n-----END PRIVATE KEY-----\\n\",\r\n"
					+ "  \"client_email\": \"firebase-adminsdk-o6juy@testij89.iam.gserviceaccount.com\",\r\n"
					+ "  \"client_id\": \"113741060083246138376\",\r\n"
					+ "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\r\n"
					+ "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\r\n"
					+ "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\r\n"
					+ "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-o6juy%40testij89.iam.gserviceaccount.com\"\r\n"
					+ "}\r\n"
					+ "";
			InputStream is = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
			credentials = GoogleCredentials.fromStream(is);
			options = new FirebaseOptions.Builder().setCredentials(credentials)
					.setDatabaseUrl("https://testij89.firebaseio.com").setProjectId("testij89").build();
			app =FirebaseApp.initializeApp(options);
			fireStore = FirestoreClient.getFirestore(app);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public CustomerDetails login(String id, String password) {
		// TODO Auto-generated method stub
		DocumentReference documentReference = fireStore.collection("bank").document(id);
		ApiFuture<DocumentSnapshot> collectionApi = documentReference.get();
		DocumentSnapshot document;
		CustomerDetails customer = null;
		try {
			document = collectionApi.get();
			if (document.exists()) {
				customer = document.toObject(CustomerDetails.class);
				if (!password.equals(customer.getPassword())) {
					customer = null;
				}
			}
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public boolean newRegisteration(CustomerDetails customerDetails) {
		// TODO Auto-generated method stub
		try {
			DocumentReference documentReference = fireStore.collection("bank").document(customerDetails.getUsername());
			ApiFuture<DocumentSnapshot> collectionApi = documentReference.get();
			if (collectionApi.get().exists()) {
				return false;
			}
			fireStore.collection("bank").document(customerDetails.getUsername()).set(customerDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void applyLoan(Loan loan, CustomerDetails customerDetails) {
		// TODO Auto-generated method stub
		List<Loan> existingLoans = new ArrayList<>();
		if (customerDetails.getLoan() != null) {
			existingLoans = customerDetails.getLoan();
		}
		existingLoans.add(loan);
		customerDetails.setLoan(existingLoans);
		this.updateDetails(customerDetails, customerDetails);
	}

	@Override
	public void updateDetails(CustomerDetails customerDetails, CustomerDetails cust) {
		// TODO Auto-generated method stub
		customerDetails.setLoan(cust.getLoan());
		fireStore.collection("bank").document(customerDetails.getUsername()).set(customerDetails);
	}

}
