package com.bh.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bh.dao.UserDetailsDao;
import com.bh.model.SignupDetails;
import com.bh.model.UserDetails;
import com.bh.model.UserSecurity;

@Repository
@Transactional
public class UserDetailsDaoImpl implements UserDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;
	int totalnumber = 0;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public String generatePIN(String name) {

		// generate a 4 digit integer 1000 <10000
		int randomPIN = (int) (Math.random() * 9000) + 1000;

		// Store integer in a string
		String PINString = String.valueOf(randomPIN);
		return name + PINString;

	}

	public String checkMail(SignupDetails signupUserDetail) {

		String email = signupUserDetail.getEmail();
		String emailInDB = getSession().createQuery("Select firstName from USER_DETAILS where email = ?")
				.setParameter(0, email).list().toString();
		System.out.println("emailInDB: " + emailInDB);
		if (emailInDB == "[]") {
			return "not present";
		}

		return "present";
	}

	@Override
	public String addUser(SignupDetails signupUserDetail) {
		if (checkMail(signupUserDetail) == "not present") {
			UserDetails ud = new UserDetails();
			UserSecurity us = new UserSecurity();
			ud.setUserID(totalnumber + 1);
			ud.setFirstName(signupUserDetail.getFirstName());
			ud.setLastName(signupUserDetail.getLastName());
			ud.setEmail(signupUserDetail.getEmail());
			ud.setDob(signupUserDetail.getDob());
			ud.setGender(signupUserDetail.getGender());
			ud.setOwn_referanceID(generatePIN(signupUserDetail.getFirstName()));
			System.out.println(ud.getOwn_referanceID());
			us.setEmail(signupUserDetail.getEmail());
			us.setHint(signupUserDetail.getHint());
			us.setPassword(signupUserDetail.getPassword());
			getSession().save(ud);
			getSession().save(us);
			return "Added";
		}
		return "Email Already Present";
	}

	@Override
	public List<UserDetails> showUser(String email) {
		// UserDetails ud = (UserDetails)getSession().createQuery("FROM
		// USER_DETAILS WHERE EMAIL = ?").setParameter(0, email).list();
		ArrayList a = new ArrayList();
		System.out.println(email);
		List<UserDetails> allUsers = getSession().createQuery("FROM USER_DETAILS WHERE own_referanceID = ?")
				.setParameter(0, email).list();
		List<UserDetails> users = new ArrayList<UserDetails>();
		for (UserDetails u : allUsers) {
			users.add(u);
		}
		return users;

	}

	@Override
	public UserDetails updateUser(UserDetails userDetail) {
		return (UserDetails) getSession()
				.createQuery("INSET INTO USERDETAILS (firstName, lastName,dob,gender) values (?,?,?,?) WHERE email = ?")
				.setParameter(0, userDetail.getFirstName()).setParameter(1, userDetail.getLastName())
				.setParameter(2, userDetail.getDob()).setParameter(3, userDetail.getGender())
				.setParameter(4, userDetail.getEmail()).list();

	}

}
