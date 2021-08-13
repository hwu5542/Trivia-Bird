package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Profile")
public class Profile {
	@Id
	@Column(name="Username")
	private String username;
	@Column(name="Password")
	private String password;
	@Column(name="ScreenName")
	private String screenName;
	@Column(name="Email")
	private String email;
	@Column(name="Bio")
	private String bio;
	@Column(name="Accuracy")
	private int accuracy;
	@Column(name="Questions")
	private int number_of_questions;
	@Column(name="Score")
	private int score;
	
	public Profile() {
		super();
	}

	public Profile(String username, String password, String screenName, String email, String bio, int accuracy,
			int number_of_questions, int score) {
		super();
		this.username = username;
		this.password = password;
		this.screenName = screenName;
		this.email = email;
		this.bio = bio;
		this.accuracy = accuracy;
		this.number_of_questions = number_of_questions;
		this.score = score;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
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
