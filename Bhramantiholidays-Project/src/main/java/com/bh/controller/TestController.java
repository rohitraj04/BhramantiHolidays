package com.bh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/test/")
public class TestController {
	
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public String getTest(){
		return "Get Working";
	}

}
