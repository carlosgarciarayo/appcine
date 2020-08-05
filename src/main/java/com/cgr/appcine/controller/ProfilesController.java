package com.cgr.appcine.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cgr.appcine.model.Profiles;
import com.cgr.appcine.service.ProfilesService;

@Controller
@RequestMapping(path = "/admin")
public class ProfilesController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	
	
	@Autowired
	ProfilesService profilesService;
	
	
	@GetMapping(path = "/perfiles")
	public String findAll(Model model) {
		
		List<Profiles> profileList = profilesService.findAll();
		
		model.addAttribute("perfiles", profileList);
		
		 return "admin/tablesPerfiles";
		
	}
	
	
	

}
