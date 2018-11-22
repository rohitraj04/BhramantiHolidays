package com.bh.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bh.dao.AdminDao;
import com.bh.model.Admin;
import com.bh.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Override
	public String verifyAdmin(Admin admin) {
		return adminDao.verifyAdmin(admin);
	}

	@Override
	public List<Admin> allAdmins() {
		return adminDao.allAdmins();
	}

	@Override
	public String addAdmin(Admin admin) {
		return adminDao.addAdmin(admin);
	}

	@Override
	public String deleteAdmin(int id) {
		return adminDao.deleteAdmin(id);
	}

}
