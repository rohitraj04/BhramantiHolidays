package com.bh.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bh.dao.PackagesDao;
import com.bh.model.PackageDetails;
import com.bh.model.Packages;
import com.bh.service.PackagesService;

@Service
public class PackagesServiceImpl implements PackagesService{
	
	@Autowired
	private PackagesDao packageDao;

	@Override
	public List<Package> showAllPackage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Packages> showPackage(int packageId) {
		// TODO Auto-generated method stub
		return packageDao.showPackage(packageId);
	}

	@Override
	public String addPackage(PackageDetails packageDetails) {
		// TODO Auto-generated method stub
		return packageDao.addPackage(packageDetails);
	}

	@Override
	public String updatePackage(PackageDetails packageDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePackage(int packageId) {
		// TODO Auto-generated method stub
		return packageDao.deletePackage(packageId);
	}

	@Override
	public Packages showPackage1(int packageId) {
		// TODO Auto-generated method stub
		return packageDao.showPackage1(packageId);
	}

}
