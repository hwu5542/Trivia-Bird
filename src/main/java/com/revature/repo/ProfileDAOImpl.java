package com.revature.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Profile;

@Repository
@Transactional
public class ProfileDAOImpl implements ProfileDAO {
	private SessionFactory sessionFactory;
	
	@Autowired
	public ProfileDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Profile> getAllProfile() {
		Session session = sessionFactory.getCurrentSession();
		
		return session.createQuery("FROM profile").list();
	}
}
