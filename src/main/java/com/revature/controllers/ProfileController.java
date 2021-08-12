package com.revature.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Profile;
import com.revature.services.ProfileService;


//this is a sample rest controller
@RestController
@RequestMapping(value="profile")
@CrossOrigin(origins = "http://localhost:3000")
public class ProfileController {
	private ProfileService profileService;
	
	@GetMapping
	public List<Profile> getProfiles() {
		return profileService.getProfiles();
	}
}