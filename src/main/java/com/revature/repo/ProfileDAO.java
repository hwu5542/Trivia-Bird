package com.revature.repo;

import java.util.List;

import com.revature.models.Profile;

public interface ProfileDAO {
	public List<Profile> getAllProfile();
	public void createProfile(Profile profile);
	public Profile findByUsername(String username);
}
