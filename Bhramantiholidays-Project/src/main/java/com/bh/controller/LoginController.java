package com.bh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bh.model.UserCredential;
import com.bh.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/testLogin")
	public String test(){
		return "working";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ResponseEntity<String> verify(@RequestBody UserCredential userCredential){
		return new ResponseEntity<String>(loginService.verifyUser(userCredential), HttpStatus.OK);
		
	}

}
