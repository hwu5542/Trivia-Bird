package com.revature.Config;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.Profile;
import com.revature.repo.ProfileDAO;
import com.revature.repo.ProfileDAOImpl;
import com.revature.services.ProfileService;

public class TestConfig {
	
	private static SessionFactory sf;
	private static ProfileDAO profileDAO;
	private static ProfileService profileService;
	
	public ProfileService getProfileService() { 

		profileService = new ProfileService(getProfileDAO());
		return profileService;
	}
	
	public ProfileDAO getProfileDAO() {
		profileDAO = new ProfileDAOImpl(getSessionFactory());
		return profileDAO;
	}
	
	public SessionFactory getSessionFactory() {
	    sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session s = sf.getCurrentSession();
	    List<Profile> profileList = s.createQuery("FROM profile").list();
	    System.out.println("Im about to print!!!");
	    for (Profile i:profileList)
	    	System.out.println(i.getScreenName());
	    return sf;
	}
}
