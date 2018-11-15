package com.bh.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bh.model.SignupDetails;
import com.bh.model.UserDetails;
import com.bh.service.UserDetailsService;

@RestController
public class SignupController {
	
	@Autowired
	private UserDetailsService userDetailsService;
	@RequestMapping(value="/test123", method = RequestMethod.GET)
	public String test123(){
		return "working"; 
	}
	@RequestMapping(value="/addUser",method= RequestMethod.POST)
	public ResponseEntity<String> addUser(@RequestBody SignupDetails signupDetails){
		return new ResponseEntity<String>(userDetailsService.addUser(signupDetails), HttpStatus.CREATED);
	}
	@RequestMapping(value="/updateDetails",method= RequestMethod.POST)
	public ResponseEntity<UserDetails> updateUser(UserDetails userDetail){
		return new ResponseEntity<UserDetails>(userDetailsService.updateUser(userDetail), HttpStatus.CREATED);
	}
	@RequestMapping(value="/details/{email}", method = RequestMethod.GET)
	public ResponseEntity<List<UserDetails>> showUserDetails(@PathVariable("email") String email){
		return new ResponseEntity<List<UserDetails>>(userDetailsService.showUser(email), HttpStatus.OK);
	}

}
