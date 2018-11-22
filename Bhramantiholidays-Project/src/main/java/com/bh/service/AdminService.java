package com.bh.service;

import java.util.List;

import com.bh.model.Admin;

public interface AdminService {
	
	public String verifyAdmin(Admin admin);
	public List<Admin> allAdmins();
	public String addAdmin(Admin admin);
	public String deleteAdmin(int id);

}
