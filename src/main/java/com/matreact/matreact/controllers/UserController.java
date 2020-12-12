package com.matreact.matreact.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matreact.matreact.model.MetaProps;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@PostMapping("/fetchmeta")
	public MetaProps fetchMeta() {
		MetaProps response =  new MetaProps();
		response.setTitle("Property Home");
		response.setDescription("This is a test site for testing angular universal app and meta tag visibility");
		response.setKeywords("Angular Universal,SEO,SSR");
		response.setUrl("");
		return response;
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
