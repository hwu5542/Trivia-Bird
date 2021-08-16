package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Profile;
import com.revature.repo.ProfileDAO;

@Service
public class ProfileService {

	private ProfileDAO profileDAO;

	public ProfileService() {
		super();
	}
	
	@Autowired
	public ProfileService(ProfileDAO profileDAO) {
		super();
		this.profileDAO = profileDAO;
	}
	
	public List<Profile> getProfiles() {
		return profileDAO.getAllProfile();
	}

	public Profile logIn(String username, String password) {
		return profileDAO.logIn(username, password);
	}
	
	public Boolean addProfile(Profile profile) {
		Profile profile2 = profileDAO.findByUsername(profile.getUsername());
		if(profile2 == null) {
			profileDAO.create(profile);
			System.out.println("Profile successfully added");
			return true;
		}

    System.out.println("Profile could not be added");
		return false;
	}
	
	public void updateScreenName(Profile profile) {
		profileDAO.update(profile);
	}
	
	public void updateProfileBio(Profile profile) {
		profileDAO.update(profile);
	}
}
