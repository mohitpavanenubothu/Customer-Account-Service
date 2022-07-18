//package com.wipro.bank.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.wipro.bank.entity.Account;
//import com.wipro.bank.entity.Customer;
//import com.wipro.bank.service.ICustomerAccountService;
//
//@RestController
//@RequestMapping("/customer")
//public class CustomerController {
//
//	@Autowired
//	private ICustomerAccountService service;
//
//	@PostMapping("/register")
//	public ResponseEntity<String> enrollCustomer(@RequestBody Customer customer, Account account) {
//		try {
//			String result = service.registerCustomerAccount(customer, account);
//			return new ResponseEntity<String>(result, HttpStatus.CREATED);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<String>("Problem in customer enrollment", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//	@PutMapping("/modify")
//	public ResponseEntity<String> modifyTourist(@RequestBody Customer customer) {
//		try {
//			String result = service.updateCustomer(customer);
//			return new ResponseEntity<String>(result, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<String>("Problem in customer enrollment", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//
//}
