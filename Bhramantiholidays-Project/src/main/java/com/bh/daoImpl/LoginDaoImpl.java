package com.bh.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bh.dao.LoginDao;
import com.bh.model.UserCredential;
@Repository
@Transactional
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	int totalnumber = 0;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public String verifyUser(UserCredential userCredential) {
		String username = getSession().createQuery("select firstName from USER_DETAILS where email = ?").setParameter(0, userCredential.getUsername()).list().toString();
		if(username.equals("[]")){
			return "Username notregistered";
		}
		String password = getSession().createQuery("select password from USER_SECURITY where email = ?").setParameter(0, userCredential.getUsername()).list().toString();
		String pswd = password.substring(1, password.length() - 1);
		System.out.println(pswd);
		if(pswd.equals(userCredential.getPassword())){
			return "password match";
		}
		return "password doesnt match";
	}

}
