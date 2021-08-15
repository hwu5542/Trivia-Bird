package com.revature.services;

import java.util.ArrayList;
import java.util.Collections;
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
		List<Profile> topTenProfile = new ArrayList<Profile>();
		
		List<Profile> allProfile = profileDAO.getAllProfile();
		
		int count = 0;
		for (int index = allProfile.size()-1; index >= 0; index--) {
			if (count ++ < 10) {
				topTenProfile.add(allProfile.get(index));
			} else break;
		}		
		return topTenProfile;
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
}
