package com.bh.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bh.dao.UserDetailsDao;
import com.bh.model.SignupDetails;
import com.bh.model.UserDetails;
import com.bh.service.UserDetailsService;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserDetailsDao userDetailsDao;

	@Override
	public String addUser(SignupDetails signupUserDetail) {
		
		return userDetailsDao.addUser(signupUserDetail);
	}

	@Override
	public List<UserDetails> showUser(String email) {
		// TODO Auto-generated method stub
		return userDetailsDao.showUser(email);
	}

	@Override
	public UserDetails updateUser(UserDetails userDetail) {
		// TODO Auto-generated method stub
		return null;
	}

}
