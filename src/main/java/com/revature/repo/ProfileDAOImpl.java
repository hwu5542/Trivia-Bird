package com.revature.repo;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
	private boolean testConstructor;
	
	public ProfileDAOImpl() {
		super();
	}
	
	@Autowired
	public ProfileDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
		this.testConstructor = false;
	}
	

	public ProfileDAOImpl(SessionFactory sessionFactory, boolean testConstructor) {
		super();
		this.sessionFactory = sessionFactory;
		this.testConstructor = true;
	}
	
	@Override
	public List<Profile> getAllProfile() {
		Session session;

		if (this.testConstructor) session = sessionFactory.openSession();
		else session = sessionFactory.getCurrentSession();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Profile> criteriaQuery = criteriaBuilder.createQuery(Profile.class);
		Root<Profile> root = criteriaQuery.from(Profile.class);
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("score")));

		if (this.testConstructor) {
			List<Profile> temp = session.createQuery(criteriaQuery).getResultList();
			session.close();
			return temp;
		}
		return session.createQuery(criteriaQuery).getResultList();
	}
	
	
	@Override
	public void createProfile(Profile profile) {
		Session session;
		if (this.testConstructor) session = sessionFactory.openSession();
		else session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(profile);
		if (this.testConstructor) session.close();
	}
	
	@Override
	public void update(Profile profile) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(profile);
	}

	@Override
	public Profile findByUsername(String username) {
		Session session;
		if (this.testConstructor) session = sessionFactory.openSession();
		else session = sessionFactory.getCurrentSession();
		Profile profile = session.get(Profile.class, username);
		if (this.testConstructor) session.close();
		return profile;
	}
}
