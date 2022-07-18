package com.wipro.bank.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.bank.entity.Account;
import com.wipro.bank.entity.AccountOpeningDetails;
import com.wipro.bank.entity.Customer;
import com.wipro.bank.repo.IAccountRepo;
import com.wipro.bank.repo.ICustomerRepo;

@Service
public class ICustomerAccountServiceImpl implements ICustomerAccountService {

	@Autowired
	private IAccountRepo accoutRepo;

	@Autowired
	private ICustomerRepo customerRepo;

//	@Override
//	public String addAccount(Account acc) {
//		long accountNumber = Math.abs(generateRandom(12));
//		acc.setAccountNumber(accountNumber);
//		accoutRepo.save(acc);
//		Customer customer = new Customer();
//		long accNumber = acc.getAccountNumber();
//		customer.setAccountNumber(accNumber);
//		String accType = acc.getAccountType();
//		customer.setAccountType(accType);
//		String name = acc.getName();
//		customer.setName(name);
//		customerRepo.save(customer);
//		return "Customer Account is Created Successfully::";
//	}
//
//	public long generateRandom(int length) {
//		Random random = new Random();
//		char[] digits = new char[length];
//		digits[0] = (char) (random.nextInt(9) + '1');
//		for (int i = 1; i < length; i++) {
//			digits[i] = (char) (random.nextInt(10) + '0');
//		}
//		return Long.parseLong(new String(digits));
//	}
//
//	@Override
//	public List<Account> getAllAccounts() {
//		List<Account> list = accoutRepo.findAll();
//		// list.sort((t1, t2) -> t1.getUserId().compareTo(t2.getUserId()));
//		return list;
//	}
//
//	@Override
//	public List<Customer> getAllCustomers() {
//		List<Customer> resultList = customerRepo.findAll();
//		if (resultList.size() > 0) {
//			return resultList;
//		} else {
//			return new ArrayList<Customer>();
//		}
//	}
//
//	@Override
//	public Account getBalanceOf(long accountNumber) throws CustomerAccountNotFoundException {
//		Optional<Account> account = accoutRepo.findByAccountNumber(accountNumber);
//		if (account.isPresent()) {
//			return account.get();
//		} else {
//			throw new CustomerAccountNotFoundException(
//					"No Customer record exist for given Account Number :" + accountNumber);
//		}
//	}
//
//	@Override
//	public Account transferFund(long from, long to, double amount) {
//		Optional<Account> payer = accoutRepo.findById((int) from);
//		Optional<Account> beneficiary = accoutRepo.findById((int) to);
//		Account reduceFund = payer.get();
//		Account raiseFund = beneficiary.get();
//		reduceFund.setBalanceAmount(reduceFund.getBalanceAmount() - amount);
//		raiseFund.setBalanceAmount(raiseFund.getBalanceAmount() + amount);
//		accoutRepo.save(reduceFund);
//		return accoutRepo.save(raiseFund);
//	}
//
//	// Customer Details
//
//	@Override
//	public String registerCustomer(Customer customer) {
//		long accountNumber = Math.abs(generateRandom(12));
//		customer.setAccountNumber(accountNumber);
//		int idVal = customerRepo.save(customer).getUserId();
//		return "Customer is registered having the id value::" + idVal;
//	}
//
//	@Override
//	public String registerCustomerAccount(Customer customer, Account account) {
//		long accountNumber = Math.abs(generateRandom(12));
//		customer.setAccountNumber(accountNumber);
//		account.setAccountNumber(accountNumber);
//		int idVal = customerRepo.save(customer).getUserId();
//		String name = customer.getName();
//		account.setName(name);
//		String accountType = customer.getAccountType();
//		account.setAccountType(accountType);
//		account.setBalanceAmount(100000);
//		accoutRepo.save(account);
//		return "Customer is registered having the id value::" + idVal;
//	}
//
//	@Override
//	public String updateCustomer(Customer customer) throws CustomerAccountNotFoundException {
//		Optional<Customer> result = customerRepo.findByaccountNumber(customer.getAccountNumber());
//		if (result.isPresent()) {
//			Customer bean = result.get();
//			bean.setName(customer.getName());
//			bean.setAadharNo(customer.getAadharNo());
//			bean.setAccountType(customer.getAccountType());
//			customerRepo.save(bean);
//			return "Updated Successfully";
//		} else {
//			return "Account Number not found";
//		}
//	}

	/********************************************************************/

	@Override
	public String addAccount(AccountOpeningDetails accountOpeningDetails) {

		Account account = new Account();
		Customer customer = new Customer();

		customer.setAadharNo(accountOpeningDetails.getAadharNo());
		customer.setAccountHolderName(accountOpeningDetails.getAccountHolderName());
		customer.setAddress(accountOpeningDetails.getAddress());
		//customer.setAccount(Arrays.asList(account));
		Customer savedCustomer = customerRepo.save(customer);

		account.setAccountType(accountOpeningDetails.getAccountType());
		account.setBalanceAmount(accountOpeningDetails.getBalanceAmount());
		account.setCustomer(savedCustomer);
		account.setAccountNumber(accountOpeningDetails.getAccountNumber());
		Account savedAccount = accoutRepo.save(account);

		if (savedAccount != null) {
			return savedAccount.getAccountNumber();
		} else {
			return null;
		}

	}

	@Override
	public Account getBalanceOf(Long accountNumber) {

		Account account = new Account();
		account.setAccountNumber(String.valueOf(accountNumber));
		Optional<Account> accounts = accoutRepo.findOne(Example.of(account));
		if (accounts.isPresent()) {
			return accounts.get();
		} else {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = false)
	public List<Account> getAllAccounts() {
		List<Account> list = accoutRepo.findAll();
		return list;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> resultList = customerRepo.findAll(Sort.by("customerId"));
		return resultList;
	}

	@Override
	public String transferFund(Long from, Long to, double amount) {
		Optional<Account> payer = accoutRepo.findById(from);
		Optional<Account> beneficiary = accoutRepo.findById(to);

		if (!payer.isEmpty() && !beneficiary.isEmpty()) {

			Account payerAccountData = payer.get();
			if(payerAccountData.getBalanceAmount() >= amount) {
				
				Account beneficiaryAccountData = beneficiary.get();
	
				payerAccountData.setBalanceAmount(payerAccountData.getBalanceAmount() - amount);
				beneficiaryAccountData.setBalanceAmount(beneficiaryAccountData.getBalanceAmount() + amount);
				accoutRepo.save(payerAccountData);
				accoutRepo.save(beneficiaryAccountData);
				return "SUCCESS";
			}else {
				return "INSUFFICIENT FUNDS";
			}
		} else {
			return "ID MISMATCH";
		}
	}

	@Override
	public Account findAccDetailsByAccNo(Long accountNumber) {
		Account account = new Account();
		account.setAccountNumber(String.valueOf(accountNumber));
		Optional<Account> accounts = accoutRepo.findOne(Example.of(account));
		if (accounts.isPresent()) {
			return accounts.get();
		} else {
			return null;
		}
	}

}
