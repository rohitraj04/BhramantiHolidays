package com.bh.service;

import java.util.List;

import com.bh.model.SignupDetails;
import com.bh.model.UserDetails;

public interface UserDetailsService {
	public String addUser(SignupDetails signupUserDetail);
	public List<UserDetails> showUser(String email);
	public UserDetails updateUser(UserDetails userDetail);

}
