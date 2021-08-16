package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.Config.TestConfig;
import com.revature.models.Answer;
import com.revature.models.Profile;
import com.revature.repo.ProfileDAO;
import com.revature.repo.ProfileDAOImpl;

public class TestGameService {
	private static GameService gameService;
	private static ProfileService profileService;
	private static ProfileDAO profileDAO;
	private static TestConfig testConfig;
	
	@BeforeAll
	public static void setupGameService() {
		testConfig = new TestConfig();
		profileDAO = new ProfileDAOImpl(testConfig.getSessionFactory(), true);
			
		gameService = new GameService(profileDAO);		
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
		
		profileService.addProfile(newProfile_one);
				
		//String username, String difficulty, String correctAnswer, String answer
		Answer answer_one = new Answer("hong", "easy", "2007", "2007");
		gameService.updateProfile(answer_one);
		newProfile_one = profileDAO.findByUsername("hong");

		int newScore = 1000;
		
		assertEquals(newScore, newProfile_one.getScore());
		
		profileDAO.close();
	}
}
