package com.revature.Config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.revature.models.Profile;

public class TestConfig {
	
	
	private static SessionFactory sessionFactory;
	private static Session session;
	
	public TestConfig() {
		super();
		// setup the session factory
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Profile.class);
		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:h2:./mem");
		configuration.setProperty("hibernate.hbm2ddl.auto", "create");

		sessionFactory = configuration.buildSessionFactory();
    }

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
