package com.wipro.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.bank.entity.Customer;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer, Long> {
//	Optional<Customer> findByaccountNumber(String accountNumber);
}
