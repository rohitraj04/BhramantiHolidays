package com.bh.service;

import java.util.List;

import com.bh.model.PackageDetails;
import com.bh.model.Packages;

public interface PackagesService {
	
	public List<Packages> showAllPackage();
	public Packages showPackage(int packageId);
	public String addPackage(PackageDetails packageDetails);
	public String updatePackage(PackageDetails packageDetails);
	public String deletePackage(int packageId);
	public Packages showPackage1(int packageId);

}
