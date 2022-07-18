//package com.wipro.bank.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.wipro.bank.Exception.CustomerAccountNotFoundException;
//import com.wipro.bank.entity.Account;
//import com.wipro.bank.entity.Customer;
//import com.wipro.bank.entity.TransferFund;
//import com.wipro.bank.service.ICustomerAccountService;
//import com.wipro.bank.util.ResponseMessage;
//
//@RestController
//@RequestMapping("/accountDetails")
//public class AccountController {
//
//	@Autowired
//	private ICustomerAccountService service;
//
//	@PostMapping("/register")
//	public ResponseEntity<ResponseMessage> createAccount(@RequestBody Account account) throws Exception {
//		String msg = "";
//		service.addAccount(account);
//		msg = "Customer Account Details are Created Successfully..";
//		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(msg, 200));
//	}
//
//	@GetMapping("/findAllAccounts")
//	public ResponseEntity<?> displayAllAccounts() {
//		try {
//			List<Account> list = service.getAllAccounts();
//			return new ResponseEntity<List<Account>>(list, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<String>("Problem in fetching Accounts", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//
//	@GetMapping("/findAllCustomes")
//	public ResponseEntity<?> displayAllCustomers() {
//		try {
//			List<Customer> list1 = service.getAllCustomers();
//			return new ResponseEntity<List<Customer>>(list1, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<String>("Problem in fetching Customers", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//
//	@GetMapping("/find/{accountNumber}")
//	public ResponseEntity<?> displayBalanceByAccNo(@PathVariable("accountNumber") Long accountNumber) {
//		try {
//			Account acc = service.getBalanceOf(accountNumber);
//			
//			return new ResponseEntity<Account>(acc, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<String>("This AccountNumber not available in DB",
//					HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//
//	@PutMapping(path = "/api/transfer-fund", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Account> transferFund(@RequestBody TransferFund transferFund)
//			throws CustomerAccountNotFoundException {
//		
//		Account account = service.getBalanceOf(transferFund.getFrom());
//		
//		if (account.getBalanceAmount() < transferFund.getFund()) {
//			System.out.println("Low Account Balance");
//			Account transferFunds = null;
//			return new ResponseEntity<Account>(transferFunds, HttpStatus.NOT_ACCEPTABLE);
//		} else {
//			Account transferFunds = service.transferFund(transferFund.getFrom(), transferFund.getTo(),
//					transferFund.getFund());
//
//			return new ResponseEntity<Account>(transferFunds, HttpStatus.OK);
//		}
//
//	}
//
//}
