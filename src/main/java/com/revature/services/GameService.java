package com.revature.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Answer;
import com.revature.models.Profile;
import com.revature.repo.ProfileDAO;

@Service
public class GameService {
	private Logger log;
	private ProfileDAO profileDAO;
	
	@Autowired
	public GameService(ProfileDAO dao) {
		super();
		this.profileDAO = dao;
		log = LoggerFactory.getLogger(GameService.class);
	}
	
	public void updateProfile(Answer answer) {
		Profile profile = profileDAO.findByUsername(answer.getId());
		
		int numberOfAttemptedQuestions = profile.getNumber_of_questions() + 1;
		int numberOfCorrectAnswers = profile.getScore();
		
		if(answer.getAnswer().equals(answer.getCorrectAnswer())) {
			numberOfCorrectAnswers++;
		}
		
		profile.setNumber_of_questions(numberOfAttemptedQuestions);
		profile.setScore(numberOfCorrectAnswers);
		
		profile.setAccuracy(numberOfCorrectAnswers/numberOfAttemptedQuestions);
		
		log.info("Updating profile: " + profile.toString());
		profileDAO.update(profile);
	}
}
