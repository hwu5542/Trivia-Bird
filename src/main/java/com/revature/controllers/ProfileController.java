package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@Autowired
	public ProfileController(ProfileService profileService) {
		super();
		this.profileService = profileService;
	}
	
	@GetMapping
	public List<Profile> getProfiles() {
		return profileService.getProfiles();
	}
	
	@PostMapping
	public ResponseEntity<Profile> logIn(@RequestBody Profile checkProfile) {
		if(profileService.logIn(checkProfile)) {
			return ResponseEntity.status(HttpStatus.OK).body(checkProfile);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();		
	}
	
	@PutMapping
	public ResponseEntity<Profile> addProfile(@RequestBody Profile newProfile){
		if (profileService.addProfile(newProfile))
			return ResponseEntity.status(HttpStatus.OK).body(newProfile);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PutMapping
	public ResponseEntity<Profile> updateScreenName(@RequestBody Profile profile){
		
		if(profile.getScreenName().length()<1) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}else {
			profileService.updateScreenName(profile);
			return ResponseEntity.status(HttpStatus.OK).body(profile);
		}
	}
	
	@PutMapping
	public ResponseEntity<Profile> updateProfileBio(@RequestBody Profile profile){
		
		profileService.updateProfileBio(profile);
		return ResponseEntity.status(HttpStatus.OK).body(profile);
	}
}