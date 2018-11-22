package com.bh.dao;

import java.util.List;

import com.bh.model.Admin;

public interface AdminDao {
	
	public String verifyAdmin(Admin admin);
	public List<Admin> allAdmins();
	public String addAdmin(Admin admin);
	public String deleteAdmin(int id);
	
}
