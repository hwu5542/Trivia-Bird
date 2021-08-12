package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.models.Profile;
import com.revature.repo.ProfileDAO;

@Service
public class ProfileService {

	private ProfileDAO profileDAO;
	
	public List<Profile> getProfiles() {
		return profileDAO.getAllProfile();
	}
}
