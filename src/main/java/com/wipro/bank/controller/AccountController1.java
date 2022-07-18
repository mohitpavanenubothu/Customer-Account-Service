package com.wipro.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.bank.entity.Account;
import com.wipro.bank.entity.AccountOpeningDetails;
import com.wipro.bank.entity.Customer;
import com.wipro.bank.entity.TransferFund2;
import com.wipro.bank.service.ICustomerAccountService;

/**
 * 
 */

@RestController
@RequestMapping(path = "/account")
public class AccountController1 {

	@Autowired
	private ICustomerAccountService service;

	@PostMapping(path = "/addAccountDetails", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createAccount(@RequestBody AccountOpeningDetails accountOpeningDetails) throws Exception {
		String msg = "";
		String accountNumber = service.addAccount(accountOpeningDetails);
		if (accountNumber != null) {
			msg = "Customer Account is Created Successfully :AccountNumber is : " + accountNumber;
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} else {
			msg = "Customer Account Creation is Failed ..!!";
			return new ResponseEntity<String>(msg, HttpStatus.EXPECTATION_FAILED);
		}

	}

	@GetMapping(path = "/loadAllAccounts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllAccounts() {
		List<Account> list = service.getAllAccounts();

		if (list != null) {

			return new ResponseEntity<List<Account>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("NO DATA FOUND", HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(path = "/loadAllCustomers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllCustomers() {
		List<Customer> list = service.getAllCustomers();
		if (list != null) {
			return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("NO DATA FOUND", HttpStatus.NO_CONTENT);
		}
	}

	@PutMapping(path = "/api/transfer-fund", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> transferFund(@RequestBody TransferFund2 transferFund)
			throws Exception {

		Account fromAccount = service.getBalanceOf(transferFund.getFromAccountNumber());
		Account toAccount = service.getBalanceOf(transferFund.getToAccountNumber());

		if (fromAccount != null) {
			
			if(transferFund.getTransferAmmount() > 0 ) {
				
				if (fromAccount.getBalanceAmount() < transferFund.getTransferAmmount()) {
					return new ResponseEntity<String>("INSUFFICIENT FUNDS", HttpStatus.NOT_ACCEPTABLE);
				} else {
					String transferFunds = service.transferFund(fromAccount.getAccountId(), toAccount.getAccountId(),
							transferFund.getTransferAmmount());
	
					return new ResponseEntity<String>(transferFunds, HttpStatus.OK);
				}
			}else {
				throw new Exception("Amount Test ");
			}
		} else {
			return new ResponseEntity<String>("ID MISMATCH", HttpStatus.NOT_ACCEPTABLE);

		}
	}

	@GetMapping(path = "/checkAccountBalance/{accountNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getBalanceOfAccount(@PathVariable("accountNumber") Long accountNumber) {
		Account acc = service.getBalanceOf(accountNumber);
		if (acc != null) {
			return new ResponseEntity<String>(acc.getBalanceAmount().toString(), HttpStatus.OK);
		} else {
			return null;

		}

	}
	
	@GetMapping(path = "/getAccount/{accountNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAccDetailsByAccNo(@PathVariable("accountNumber") Long accountNumber) {
		
		Account acc = service.findAccDetailsByAccNo(accountNumber);
		
		if (acc != null) {
			return new ResponseEntity<Account>(acc, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Deatils not Found with given account number", HttpStatus.EXPECTATION_FAILED);
		}
	}

}
