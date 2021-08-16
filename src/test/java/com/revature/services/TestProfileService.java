package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.revature.Config.TestConfig;
import com.revature.models.Profile;
import com.revature.repo.ProfileDAO;
import com.revature.repo.ProfileDAOImpl;

public class TestProfileService {
	private static Profile newProfile_one = new Profile();
	private static Profile newProfile_two = new Profile();
	private static Profile newProfile_three = new Profile();
	private static Profile newProfile_four = new Profile();
	
	
	private static TestConfig testConfig;
	
	private ProfileService profileService;
	private ProfileDAO profileDAO;
	
	
	@BeforeAll
	public static void setupTestConfig() {
		testConfig = new TestConfig();
	}
	
	@BeforeEach
	public void setupProfileService() {
		profileDAO = new ProfileDAOImpl(testConfig.getSessionFactory(), true);
		profileService = new ProfileService(profileDAO);

		newProfile_one.setUsername("hong");
		newProfile_one.setPassword("hoho");
		newProfile_one.setAccuracy(9);
		newProfile_one.setBio("blar");
		newProfile_one.setEmail("hong@mail.com");
		newProfile_one.setNumber_of_questions(99);
		newProfile_one.setScore(999);
		newProfile_one.setScreenName("hwu");
		
		newProfile_four.setUsername("qwe");
		newProfile_four.setPassword("invalid");
		newProfile_four.setAccuracy(1);
		newProfile_four.setBio("blar");
		newProfile_four.setEmail("qwe@mail.com");
		newProfile_four.setNumber_of_questions(11);
		newProfile_four.setScore(111);
		newProfile_four.setScreenName("qwe");
		
		newProfile_two.setUsername("qwe");
		newProfile_two.setPassword("qwe");
		newProfile_two.setAccuracy(1);
		newProfile_two.setBio("blar");
		newProfile_two.setEmail("qwe@mail.com");
		newProfile_two.setNumber_of_questions(11);
		newProfile_two.setScore(111);
		newProfile_two.setScreenName("qwe");
		
		newProfile_three.setUsername("qwe");
		newProfile_three.setPassword("qwe");
		newProfile_three.setAccuracy(1);
		newProfile_three.setBio("blar");
		newProfile_three.setEmail("qwe@mail.com");
		newProfile_three.setNumber_of_questions(11);
		newProfile_three.setScore(111);
		newProfile_three.setScreenName("qwe");
	}

	@Test
	@DisplayName("Add a test profile")
	public void testAddProfilesOne() {
		assertTrue(profileService.addProfile(newProfile_one));
		profileDAO.close();
	}
	
	@Test
	@DisplayName("Add another test profile")
	public void testAddProfilesTwo() {
		assertTrue(profileService.addProfile(newProfile_two));
		profileDAO.close();
	}
	
	@Test
	@DisplayName("Add profiles same username")
	public void testAddProfilesThree() {
		profileService.addProfile(newProfile_two);
		assertFalse(profileService.addProfile(newProfile_four));
		profileDAO.close();
	}
	
	@Test
	@DisplayName("Get top ten player profiles")
	public void testGetProfiles() {
		profileService.addProfile(newProfile_one);
		profileService.addProfile(newProfile_two);
		assertNotNull(profileService.getProfiles());
		profileDAO.close();
	}
	
	@Test
	@DisplayName("test valid Login")
	public void testValidLogin() {
		profileService.addProfile(newProfile_two);
		assertTrue(profileService.logIn(newProfile_three));
		profileDAO.close();
	}
	
	@Test
	@DisplayName("test invalid Login")
	public void testInvalidLoginCaseOne() {
		assertFalse(profileService.logIn(newProfile_two));
		profileDAO.close();
	}
	
	@Test
	@DisplayName("test invalid Login password")
	public void testInvalidLoginCaseTwo() {
		profileService.addProfile(newProfile_two);
		assertFalse(profileService.logIn(newProfile_four));
		profileDAO.close();
	}
}
