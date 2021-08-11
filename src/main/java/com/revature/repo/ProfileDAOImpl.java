package com.revature.repo;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProfileDAOImpl implements ProfileDAO {
	@Autowired
	private SessionFactory sf;
}
