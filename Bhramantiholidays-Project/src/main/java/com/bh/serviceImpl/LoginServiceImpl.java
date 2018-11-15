package com.bh.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bh.dao.LoginDao;
import com.bh.model.UserCredential;
import com.bh.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;
	
	@Override
	public String verifyUser(UserCredential userCredential) {
		// TODO Auto-generated method stub
		return loginDao.verifyUser(userCredential);
	}

}
