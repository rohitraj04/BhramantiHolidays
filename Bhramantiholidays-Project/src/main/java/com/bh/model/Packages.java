package com.bh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "PACKAGES")
@Table(name = "PACKAGES")
public class Packages {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	 private int packageId;
	 private String packageName;
	 private String packageDetail;
	 private double packagePrice;
	 private double packageDiscount;
	 private double packagePromoPrice;
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getPackageDetail() {
		return packageDetail;
	}
	public void setPackageDetail(String packageDetail) {
		this.packageDetail = packageDetail;
	}
	public double getPackagePrice() {
		return packagePrice;
	}
	public void setPackagePrice(double packagePrice) {
		this.packagePrice = packagePrice;
	}
	public double getPackageDiscount() {
		return packageDiscount;
	}
	public void setPackageDiscount(double packageDiscount) {
		this.packageDiscount = packageDiscount;
	}
	public double getPackagePromoPrice() {
		return packagePromoPrice;
	}
	public void setPackagePromoPrice(double packagePromoPrice) {
		this.packagePromoPrice = packagePromoPrice;
	}
	 
	 

}