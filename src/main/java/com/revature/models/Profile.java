package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profile {
	@Id
	private String username;
	private String Password;
	private String ScreenName;
	private String Email;
	private String Bio;
	private int accuracy;
	private int number_of_questions;
	private int score;
	
	public Profile(String username, String password, String screenName, String email, String bio, int accuracy,
			int number_of_questions, int score) {
		super();
		this.username = username;
		Password = password;
		ScreenName = screenName;
		Email = email;
		Bio = bio;
		this.accuracy = accuracy;
		this.number_of_questions = number_of_questions;
		this.score = score;
	}

	public Profile() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getScreenName() {
		return ScreenName;
	}

	public void setScreenName(String screenName) {
		ScreenName = screenName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getBio() {
		return Bio;
	}

	public void setBio(String bio) {
		Bio = bio;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getNumber_of_questions() {
		return number_of_questions;
	}

	public void setNumber_of_questions(int number_of_questions) {
		this.number_of_questions = number_of_questions;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}	
	
	
}
