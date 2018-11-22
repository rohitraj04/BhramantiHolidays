package com.bh.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bh.dao.AdminDao;
import com.bh.model.Admin;

@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SessionFactory sessionFactory;
	int totalnumber = 0;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public String verifyAdmin(Admin admin) {
		String passwordFromDB = getSession().createQuery("SELECT password FROM ADMIN WHERE username = ?")
				.setParameter(0, admin.getUsername()).list().toString();
		String password = passwordFromDB.substring(1, passwordFromDB.length() - 1);
		if (password.equals(admin.getPassword())) {
			return "Login Sucessfull";
		}
		return "Userame or Password is incorrect";
	}

	@Override
	public List<Admin> allAdmins() {
		return getSession().createQuery("FROM ADMIN").list();
	}

	@Override
	public String addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		getSession().save(admin);
		return "Added new Admin";
	}

	@Override
	public String deleteAdmin(int id) {
		getSession().createQuery("DELETE FROM ADMIN WHERE id = ?").setParameter(0, id).executeUpdate();
		return "Deleted";
	}

}
