package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Profile;
import com.revature.services.GameService;

@RestController
@RequestMapping(value="/game")
public class GameController {
	private GameService gService;
	
	@Autowired
	public GameController(GameService gameService) {
		super();
		this.gService = gameService;
	}
	
	@PostMapping
	public ResponseEntity<Profile> updateUser(Profile profile) {
		//gService.updateProfile
		
		return null;
	}
}
