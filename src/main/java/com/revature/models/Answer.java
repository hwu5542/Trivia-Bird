package com.revature.models;

import org.springframework.beans.factory.annotation.Autowired;

public class Answer {
	private String username;
	private String difficulty;
	private String correctAnswer;
	private String answer;
	
	@Autowired
	public Answer(String username, String difficulty, String correctAnswer, String answer) {
		super();
		this.username = username;
		this.difficulty = difficulty;
		this.correctAnswer = correctAnswer;
		this.answer = answer;
	}

	public Answer() {}
	
	public String 	getDifficulty() 	{ return difficulty;	}
	public String 	getCorrectAnswer()	{ return correctAnswer;	}
	public String 	getAnswer() 		{ return answer;		}
	public String	getUsername()		{ return username;		}

	public void	setDifficulty(String difficulty)		{ this.difficulty = difficulty;			}
	public void	setCorrectAnswer(String correctAnswer)	{ this.correctAnswer = correctAnswer;	}
	public void	setAnswer(String answer) 				{ this.answer = answer;					}
	public void	setUsername(String id)					{ this.username = id;					}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((correctAnswer == null) ? 0 : correctAnswer.hashCode());
		result = prime * result + ((difficulty == null) ? 0 : difficulty.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (correctAnswer == null) {
			if (other.correctAnswer != null)
				return false;
		} else if (!correctAnswer.equals(other.correctAnswer))
			return false;
		if (difficulty == null) {
			if (other.difficulty != null)
				return false;
		} else if (!difficulty.equals(other.difficulty))
			return false;
		if (username != other.username)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Answer [username=" + username + ", difficulty=" + difficulty + ", correctAnswer=" + correctAnswer + ", answer="
				+ answer + "]";
	}
	
	
}
