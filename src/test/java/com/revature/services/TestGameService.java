package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.Config.TestConfig;
import com.revature.models.Profile;
import com.revature.repo.ProfileDAO;

public class TestGameService {
	private static ProfileService profileService;
	private static ProfileDAO profileDAO;
	private static TestConfig testConfig;
	
	@BeforeAll
	public static void setupGameService() {
//these two you will need to keep
//		testConfig = new TestConfig();
//		profileDAO = new ProfileDAOImpl(testConfig.getSessionFactory(), true);
			
//this one is sample for you to make your own
//		profileService = new ProfileService(profileDAO);		
	}
	
//  Sample test, delete as you make your own
//	@Test
//	public void testAddProfilesOne() {
//
//		Profile newProfile_one = new Profile();
//		newProfile_one.setUsername("hong");
//		newProfile_one.setPassword("hoho");
//		newProfile_one.setAccuracy(9);
//		newProfile_one.setBio("blar");
//		newProfile_one.setEmail("hong@mail.com");
//		newProfile_one.setNumber_of_questions(99);
//		newProfile_one.setScore(999);
//		newProfile_one.setScreenName("hwu");
//		
//		
//		assertTrue(profileService.addProfile(newProfile_one));
//	}
}
