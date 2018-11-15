package com.bh.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bh.dao.PackagesDao;
import com.bh.model.PackageDetails;
import com.bh.model.Packages;
import com.bh.model.UserDetails;

@Repository
@Transactional
public class PackagesDaoImpl implements PackagesDao {

	double pp = 0.0;
	@Autowired
	private SessionFactory sessionFactory;
	int totalnumber = 0;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	protected double PromoPrice(double basePrice, float discount) {
		double promoPrice = basePrice - ((discount / 100) * basePrice);
		return promoPrice;
	}

	@Override
	public List<Packages> showPackage(int packageId) {
		List<Packages> packages = getSession().createQuery("from PACKAGES where packageId = ?").setParameter(0, packageId).list();
		List<Packages> ppp = new ArrayList<Packages>();
		for (Packages p : ppp) {
			ppp.add(p);
		}
		return packages;
	}

	@Override
	public String addPackage(PackageDetails packageDetails) {

		try {
			if (packageDetails.getPackagePrice() > 0) {
				if (packageDetails.getPackageDiscount() < 100 || packageDetails.getPackageDiscount() == 100 ) {
					pp = PromoPrice(packageDetails.getPackagePrice(), packageDetails.getPackageDiscount());
					Packages packages = new Packages();
					packages.setPackageName(packageDetails.getPackageName());
					packages.setPackageDetail(packageDetails.getPackageDetail());
					packages.setPackagePrice(packageDetails.getPackagePrice());
					packages.setPackageDiscount(packageDetails.getPackageDiscount());
					packages.setPackagePromoPrice(pp);

					getSession().save(packages);

					return "Added";
				}
				else{
					return "Descount % should be 100 or lessthan 100";
				}
			}
		} catch (Exception ee) {
			ee.getMessage();
		}
		return "base price should be greeter than 0";
		
	}

	@Override
	public String updatePackage(PackageDetails packageDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePackage(int packageId) {
		System.out.println("In daoImpl");
		getSession().createQuery("DELETE FROM PACKAGES WHERE packageId = ?").setParameter(0, packageId).executeUpdate();
		return "Deleted";
	}

	@Override
	public List<Package> showAllPackage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Packages showPackage1(int packageId) {
		Packages package1;
		package1= (Packages)getSession().get(Package.class, packageId);
		System.out.println(package1.getPackageName());
		return package1;
	}

}
