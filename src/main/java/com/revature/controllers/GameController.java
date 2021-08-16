package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Answer;
import com.revature.models.Profile;
import com.revature.services.GameService;

@RestController
@RequestMapping(value="/game")
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {
	private GameService gameService;
	
	@Autowired
	public GameController(GameService gameService) {
		super();
		this.gameService = gameService;
	}
	
	@PostMapping
	public ResponseEntity<Profile> updateUser(@RequestBody Answer answer) {
		//debug
		System.out.println("Gamecontroller post triggered");
		System.out.println(answer);
		
		Answer nullAnswer = new Answer();
		
		if(answer.getUsername() == nullAnswer.getUsername()) {
			System.out.println("this answer has no user id");
		}else {
			gameService.updateProfile(answer);
		}
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}

//ResponseEntity<Profile>.status(HttpStatus.OK).build()
