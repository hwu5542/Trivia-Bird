package com.revature.repo;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Profile> criteriaQuery = criteriaBuilder.createQuery(Profile.class);
		Root<Profile> root = criteriaQuery.from(Profile.class);
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("score")));
		return session.createQuery(criteriaQuery).getResultList();
	}
	
	
	@Override
	public void createProfile(Profile profile) {
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
}
