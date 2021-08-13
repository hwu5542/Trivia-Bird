package com.revature.repo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Profile;

@Repository
@Transactional
public class ProfileDAOImpl implements ProfileDAO {
	private SessionFactory sessionFactory;
	
	public ProfileDAOImpl() {
		super();
	}
	
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
	
//	@Override
//	public void insertProfile(Profile newProfile) {
//		Session session = sessionFactory.getCurrentSession();
//		
//		session.saveOrUpdate(newProfile);
//	}
	
	@Override
	public void create(Profile profile) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(profile);
	}

	@Override
	public Profile findByUsername(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Profile profile = session.get(Profile.class, username);
		return profile;
	}

	@Override
	public Profile logIn(String username, String password) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Profile.class);
		criteria.add(Restrictions.like(username, username));
		criteria.add(Restrictions.like(password, password));
		Profile profile = (Profile) criteria.uniqueResult();
		return profile;
	}
}
