package com.wipro.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.bank.entity.Account;

@Repository
public interface IAccountRepo extends JpaRepository<Account, Long> {
	
//	Optional<Account> findByAccountNumber(long accountNumber);

}
