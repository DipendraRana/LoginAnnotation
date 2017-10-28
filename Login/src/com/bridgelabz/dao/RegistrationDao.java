package com.bridgelabz.dao;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.bridgelabz.model.AttributesFile;

public class RegistrationDao {
	
	public static void register(String userName, String emailId, String password, long mobileNumber) throws PersistenceException {
		Configuration configuration=new Configuration().configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		AttributesFile attributes=new AttributesFile();
		attributes.setUserName(userName);
		attributes.setEmailId(emailId);
		attributes.setPassword(password);
		attributes.setMobileNumber(mobileNumber);
		
		session.save(attributes);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
