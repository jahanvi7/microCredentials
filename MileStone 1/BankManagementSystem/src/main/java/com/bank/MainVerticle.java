package com.bank;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bank.model.CustomerDetails;
import com.bank.model.Loan;
import com.bank.service.CustomerService;
import com.bank.service.CustomerServiceImpl;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.Session;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.SessionHandler;
import io.vertx.ext.web.sstore.LocalSessionStore;
import io.vertx.ext.web.sstore.SessionStore;

public class MainVerticle extends AbstractVerticle {

	private static final Logger LOGGER = Logger.getLogger("BankLog");

	public static void main(String[] args) {

		System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT.%1$tL - %4$s - %5$s%n");
		System.setProperty("java.util.logging.ConsoleHandler.formatter", "java.util.logging.SimpleFormatter");
		FileHandler hd;
		try {
			hd = new FileHandler("bank.log");

			LOGGER.addHandler(hd);
			hd.setFormatter(new ConsoleHandler().getFormatter());
		} catch (Exception e) {
		}

		Vertx vertx = Vertx.vertx();
		HttpServer server = vertx.createHttpServer();
		Router router = Router.router(vertx);
		SessionStore sessionStore = LocalSessionStore.create(vertx);

		SessionHandler sessionHandler = SessionHandler.create(sessionStore);
		CustomerService customerService = new CustomerServiceImpl();

		router.route().handler(sessionHandler);

		router.get("/login").handler(BodyHandler.create()).handler(routingContext -> {
			LOGGER.info("START : User Login");
			Session session = routingContext.session();
			HttpServerResponse httpServerResponse = routingContext.response();
			httpServerResponse.setChunked(true);
			if (session.isEmpty()) {
				JsonObject obj = routingContext.getBodyAsJson();
				String id = obj.getString("username");
				String password = obj.getString("password");
				CustomerDetails customer = customerService.login(id, password);
				if (customer == null) {
					httpServerResponse.end("Invalid Credentials");
					LOGGER.log(Level.SEVERE, "Invalid Credentials");
				} else {
					session.put("user", customer);
					httpServerResponse.end("Login Successful");
					LOGGER.info("Login Successful");
				}
			} else {
				httpServerResponse.end("A User Already Logged In");
				LOGGER.warning("A User Already Logged In");
			}
			LOGGER.info("END : User Login");
		});

		router.route("/logout").handler(routingContext -> {
			LOGGER.info("START : Logout");
			Session session = routingContext.session();
			HttpServerResponse httpServerResponse = routingContext.response();
			httpServerResponse.setChunked(true);
			if (session.isEmpty()) {
				httpServerResponse.end("No User Logged in");
				LOGGER.log(Level.SEVERE, "No User Logged in");
			} else {
				session.destroy();
				httpServerResponse.end("Logout Successful");
				LOGGER.info("Logout Successful");
			}
			LOGGER.info("END : Logout");
		});

		router.post("/register").handler(BodyHandler.create()).handler(routingContext -> {
			LOGGER.info("START : User Registration");
			Session session = routingContext.session();
			HttpServerResponse httpServerResponse = routingContext.response();
			httpServerResponse.setChunked(true);
			if (session.isEmpty()) {
				String obj = routingContext.getBodyAsString();
				CustomerDetails customer = Json.decodeValue(obj, CustomerDetails.class);
				boolean result = customerService.newRegisteration(customer);
				if (result) {
					httpServerResponse.end("User Added");
					LOGGER.info("User Added Successfully");
				} else {
					httpServerResponse.end("Username already exists");
					LOGGER.log(Level.SEVERE, "Username already exists");
				}
			} else {
				httpServerResponse.end("Cannot Register a user while logged in");
				LOGGER.warning("Cannot Register a user while logged in");
			}
			LOGGER.info("END : User Registration");
		});

		router.post("/applyLoan").handler(BodyHandler.create()).handler(routingContext -> {
			LOGGER.info("START : Apply for Loan");
			Session session = routingContext.session();
			HttpServerResponse httpServerResponse = routingContext.response();
			httpServerResponse.setChunked(true);
			if (session.isEmpty()) {
				httpServerResponse.end("Login to Apply for Loan");
				LOGGER.log(Level.SEVERE, "Login to Apply for Loan");
			} else {
				JsonObject obj = routingContext.getBodyAsJson();
				CustomerDetails cust = session.get("user");
				Loan loan = Json.decodeValue(obj.toString(), Loan.class);
				loan.setCustomerDetails(cust);
				customerService.applyLoan(loan);
				httpServerResponse.end("Applied for Loan");
				LOGGER.info("Applied for Loan Successfully");
			}
			LOGGER.info("END : Apply for Loan");
		});

		router.put("/update").handler(BodyHandler.create()).handler(routingContext -> {
			LOGGER.info("START : Update User Details");
			Session session = routingContext.session();
			HttpServerResponse httpServerResponse = routingContext.response();
			httpServerResponse.setChunked(true);
			if (session.isEmpty()) {
				httpServerResponse.end("Login to Update the Details");
				LOGGER.log(Level.SEVERE, "Login to Update User Details");
			} else {
				String obj = routingContext.getBodyAsString();
				CustomerDetails customer = Json.decodeValue(obj, CustomerDetails.class);
				customerService.updateDetails(customer);
				httpServerResponse.end("Details Updated Successfully");
				LOGGER.info("User Details Updates Successfully");
			}
			LOGGER.info("END : Update User Details");
		});

		server.requestHandler(router).listen(8080);
	}
}
