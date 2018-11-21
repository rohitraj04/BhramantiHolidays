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

	double pp = 0;
	@Autowired
	private SessionFactory sessionFactory;
	int totalnumber = 0;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	protected double PromoPrice(double basePrice, double discount) {
		double promoPrice = basePrice - ((discount / 100) * basePrice);
		return promoPrice;
	}

	@Override
	public Packages showPackage(int packageId) {
		List<Packages> packages = getSession().createQuery("from PACKAGES where packageId = ?")
				.setParameter(0, packageId).list();
		return packages.get(0);
	}

	@Override
	public String addPackage(PackageDetails packageDetails) {

		try {
			if (packageDetails.getPackagePrice() > 0) {
				if (packageDetails.getPackageDiscount() < 100 || packageDetails.getPackageDiscount() == 100) {
					pp = PromoPrice(packageDetails.getPackagePrice(), packageDetails.getPackageDiscount());
					Packages packages = new Packages();
					packages.setPackageName(packageDetails.getPackageName());
					packages.setPackageDetail(packageDetails.getPackageDetail());
					packages.setPackagePrice(packageDetails.getPackagePrice());
					packages.setPackageDiscount(packageDetails.getPackageDiscount());
					packages.setPackagePromoPrice(pp);

					getSession().save(packages);

					return "Added";
				} else {
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
		String id = getSession().createQuery("SELECT packageId FROM PACKAGES WHERE packageName = ?")
				.setParameter(0, packageDetails.getPackageName()).list().toString();
		System.out.println("package id : " + id);
		if (id.equals("[]")) {
			return "Package is not added";
		}
		if (packageDetails.getPackagePrice() > 0) {
			if (packageDetails.getPackageDiscount() < 100 || packageDetails.getPackageDiscount() == 100) {
				double ppp = PromoPrice(packageDetails.getPackagePrice(), packageDetails.getPackageDiscount());
				String idd = id.substring(1, id.length() - 1);
				int iddd = Integer.parseInt(idd);
				getSession()
						.createQuery(
								"UPDATE PACKAGES SET packageName = ?, packageDetail= ?,packagePrice = ?, packageDiscount = ?, packagePromoPrice = ? WHERE packageId = ? ")
						.setParameter(0, packageDetails.getPackageName())
						.setParameter(1, packageDetails.getPackageDetail())
						.setParameter(2, packageDetails.getPackagePrice())
						.setParameter(3, packageDetails.getPackageDiscount())
						.setParameter(4, ppp).setParameter(5, iddd)
						.executeUpdate();

				return "Updated";
			}
		}

		return "base price should be greeter than 0";
	}

	@Override
	public String deletePackage(int packageId) {
		System.out.println("In daoImpl");
		getSession().createQuery("DELETE FROM PACKAGES WHERE packageId = ?").setParameter(0, packageId).executeUpdate();
		return "Deleted";
	}

	@Override
	public List<Packages> showAllPackage() {
		List<Packages> packages = getSession().createQuery("from PACKAGES")
				.list();
		return packages;
		
	}

	@Override
	public Packages showPackage1(int packageId) {
		Packages package1;
		package1 = (Packages) getSession().get(Package.class, packageId);
		System.out.println(package1.getPackageName());
		return package1;
	}

}
