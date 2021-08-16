package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.Config.TestConfig;
import com.revature.models.Profile;
import com.revature.repo.ProfileDAO;
import com.revature.repo.ProfileDAOImpl;

public class TestProfileService {
	private static ProfileService profileService;
	private static ProfileDAO profileDAO;
	private static TestConfig testConfig;
	
	@BeforeAll
	public static void addProfiles() {
		testConfig = new TestConfig();
		profileDAO = new ProfileDAOImpl(testConfig.getSessionFactory(), true);
		profileService = new ProfileService(profileDAO);		
	}

	@Test
	public void testAddProfilesOne() {

		Profile newProfile_one = new Profile();
		newProfile_one.setUsername("hong");
		newProfile_one.setPassword("hoho");
		newProfile_one.setAccuracy(9);
		newProfile_one.setBio("blar");
		newProfile_one.setEmail("hong@mail.com");
		newProfile_one.setNumber_of_questions(99);
		newProfile_one.setScore(999);
		newProfile_one.setScreenName("hwu");
		
		
		assertTrue(profileService.addProfile(newProfile_one));
	}
	
	@Test
	public void testAddProfilesTwo() {
		Profile newProfile_two = new Profile();
		newProfile_two.setUsername("qwe");
		newProfile_two.setPassword("qwe");
		newProfile_two.setAccuracy(1);
		newProfile_two.setBio("blar");
		newProfile_two.setEmail("qwe@mail.com");
		newProfile_two.setNumber_of_questions(11);
		newProfile_two.setScore(111);
		newProfile_two.setScreenName("qwe");

		assertTrue(profileService.addProfile(newProfile_two));
	}
}
