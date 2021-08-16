package com.revature.repo;

import java.util.List;

import com.revature.models.Profile;

public interface ProfileDAO {
	public List<Profile> getAllProfile();
//	public void insertProfile(Profile newProfile);
	public void create(Profile profile);
	public Profile findByUsername(String username);
	public Profile logIn(String username, String password);
	public void update(Profile profile);
}
