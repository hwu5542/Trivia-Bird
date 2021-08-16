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
	private Session session;
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
		this.session = this.sessionFactory.openSession();
	}
	
	@Override
	public List<Profile> getAllProfile() {
		if (!this.testConstructor) this.session = sessionFactory.getCurrentSession();

		CriteriaBuilder criteriaBuilder = this.session.getCriteriaBuilder();
		CriteriaQuery<Profile> criteriaQuery = criteriaBuilder.createQuery(Profile.class);
		Root<Profile> root = criteriaQuery.from(Profile.class);
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("score")));

		return this.session.createQuery(criteriaQuery).getResultList();
	}
	
	@Override
	public void createProfile(Profile profile) {
		if (!this.testConstructor) this.session = sessionFactory.getCurrentSession();
		this.session.saveOrUpdate(profile);
	}
	
	@Override
	public void update(Profile profile) {
		if (!this.testConstructor) this.session = sessionFactory.getCurrentSession();
		this.session.merge(profile);
	}

	@Override
	public Profile findByUsername(String username) {
		if (!this.testConstructor) this.session = sessionFactory.getCurrentSession();
		Profile profile = this.session.get(Profile.class, username);
		return profile;
	}
	
	@Override
	public void close() {
		this.session.close();
	}

}
