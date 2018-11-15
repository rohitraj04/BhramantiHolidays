package com.bh.dao;

import com.bh.model.UserCredential;

public interface LoginDao {
	public String verifyUser(UserCredential userCredential);
}
