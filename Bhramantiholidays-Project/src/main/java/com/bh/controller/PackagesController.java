package com.bh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bh.model.PackageDetails;
import com.bh.model.Packages;
import com.bh.service.PackagesService;

@RestController
public class PackagesController {
	
	@Autowired
	private PackagesService packagesService;
	
	@RequestMapping(value= "/testPackages", method= RequestMethod.GET)
	public String packagesTest(){
		return "Working";
	}
	@RequestMapping(value="/testDelete", method = RequestMethod.DELETE)
	public String testDelete(){
		return "Deleted";
	}
	@RequestMapping(value="/testUpdate", method = RequestMethod.PUT)
	public String testUpdate(){
		return "updated";
	}
	@RequestMapping(value= "/addPackage", method = RequestMethod.POST)
	public ResponseEntity<String> addPackage(@RequestBody PackageDetails packageDetails){
		return new ResponseEntity<String>(packagesService.addPackage(packageDetails), HttpStatus.CREATED);
	}
	@RequestMapping(value= "/showPackage/{packageId}", method = RequestMethod.GET)
	public ResponseEntity<List<Packages>> showPackage(@PathVariable("packageId") int packageId){
		return new ResponseEntity<List<Packages>>(packagesService.showPackage(packageId), HttpStatus.OK);
	}
	@RequestMapping(value= "/showPackage1/{packageId}", method = RequestMethod.GET)
	public ResponseEntity<Packages> showPackage1(@PathVariable("packageId") int packageId){
		return new ResponseEntity<Packages>(packagesService.showPackage1(packageId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/package/{packageId}", method = RequestMethod.DELETE)
	public String deletePackage(@PathVariable("packageId") int packageId){
		return packagesService.deletePackage(packageId);
	}
	
	
	
	

}
