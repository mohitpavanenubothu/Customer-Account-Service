package com.wipro.bank.service;

import java.util.List;

import com.wipro.bank.entity.Account;
import com.wipro.bank.entity.AccountOpeningDetails;
import com.wipro.bank.entity.Customer;

public interface ICustomerAccountService {

	public String addAccount(AccountOpeningDetails accountOpeningDetails);

	public List<Account> getAllAccounts();

	public List<Customer> getAllCustomers();

	public Account getBalanceOf(Long accountNumber);

	public String transferFund(Long from, Long to, double amount);
	
	public Account findAccDetailsByAccNo(Long accountNumber);
//
//	public String registerCustomer(Customer customer);
//
//	public String registerCustomerAccount(Customer customer, Account account);
//
//	public String updateCustomer(Customer customer) throws CustomerAccountNotFoundException;

}
