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

import com.bh.model.Admin;
import com.bh.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/test098", method = RequestMethod.GET)
	public String testAdmin() {
		return "Admin Working";
	}

	/*@RequestMapping(value = "/allAdmin", method = RequestMethod.GET)
	public ResponseEntity<List<Admin>> allAdmin() {
		return new ResponseEntity<List<Admin>>(adminService.allAdmins(), HttpStatus.OK);
	}*/

	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	public ResponseEntity<String> addAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<String>(adminService.addAdmin(admin), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/verifyAdmin", method = RequestMethod.POST)
	public ResponseEntity<String> verifyAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<String>(adminService.verifyAdmin(admin), HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteAdmin/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAdmin(@PathVariable("id") int id) {
		return new ResponseEntity<String>(adminService.deleteAdmin(id), HttpStatus.OK);
	}
}
