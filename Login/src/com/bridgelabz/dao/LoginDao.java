package com.bridgelabz.dao;

import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.bridgelabz.model.AttributesFile;

/**
 * Purpose: To establish the connection with our database and 
 * 			looking in to it to validate the username and password
 * 			provided to it. It's only purpose is to validate therefore it has
 * 			only one method i.e validate(String username,String password)
 * @author Dipendra Rana
 * @since 6 Oct 2017
 *
 */
public class LoginDao {

	/**
	 * @param username 
	 * @param password its data type is String
	 * @return returns True if found else returns False
	 * @throws IOException 
	 */
	public static String validate(String emailId,String password) throws IOException {
		
		String userName=null;
		Configuration configuration=new Configuration().configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query<AttributesFile> query;
		try {
			query = session.createQuery("From "+AttributesFile.class.getName() +" where emailId =:Email_Id and password=:Password",AttributesFile.class);
			query.setParameter("Email_Id", emailId);
			query.setParameter("Password", password);
			AttributesFile attribute=(AttributesFile) query.uniqueResult();
			userName=attribute.getUserName();
			transaction.commit();
			session.close();
			sessionFactory.close();
			return userName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			session.close();
			sessionFactory.close();
			return userName;
		}
	}

}
