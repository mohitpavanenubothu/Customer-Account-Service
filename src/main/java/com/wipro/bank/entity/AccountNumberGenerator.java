package com.wipro.bank.entity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

@Component
public class AccountNumberGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor  session, Object object) throws HibernateException {

		String prefix = "ACC";
		Connection connection = session.connection();

		try {

			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("select count(accountId) as Id from Account");
			if (rs.next()) {
				int id = rs.getInt(1) + 101;
				String generatedId = prefix + id;
				System.out.println("Generated Id: " + generatedId);
				return generatedId;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

}
