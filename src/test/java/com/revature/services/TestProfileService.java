package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.models.Profile;

public class TestProfileService {
	
	private static ProfileService profileService;
	
	private static Profile newProfile;
	
	@BeforeAll
	public static void addProfiles() {
		//test profile 1
		
		newProfile = new Profile();
		newProfile.setUsername("hong");
		newProfile.setPassword("hoho");
		newProfile.setAccuracy(9);
		newProfile.setBio("blar");
		newProfile.setEmail("hong@mail.com");
		newProfile.setNumber_of_questions(99);
		newProfile.setScore(999);
		newProfile.setScreenName("hwu");
		profileService.insertProfile(newProfile);
		
		//test profile 2
		newProfile.setUsername("qwe");
		newProfile.setPassword("qwe");
		newProfile.setAccuracy(1);
		newProfile.setBio("blar");
		newProfile.setEmail("qwe@mail.com");
		newProfile.setNumber_of_questions(11);
		newProfile.setScore(111);
		newProfile.setScreenName("qwe");
		profileService.insertProfile(newProfile);
	}

	@Test
	public void testGetProfiles() {
		assertNotNull(profileService.getProfiles());
	}
}
