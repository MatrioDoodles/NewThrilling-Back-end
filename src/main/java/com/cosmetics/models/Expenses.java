package com.cosmetics.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="expenses")
public class Expenses implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3766463414748083338L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_EXPENSES", unique = true)
	private long id;
	private String advertising;
	private String phone;
	private String salaries;
	private String rent;
	private String iam;
	private String one;
	private String ramsa;
	private String maids;
	private String misc;
	private int month;
	private int year;
	
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAdvertising() {
		return advertising;
	}
	public void setAdvertising(String advertising) {
		this.advertising = advertising;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSalaries() {
		return salaries;
	}
	public void setSalaries(String salaries) {
		this.salaries = salaries;
	}
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public String getIam() {
		return iam;
	}
	public void setIam(String iam) {
		this.iam = iam;
	}
	public String getOne() {
		return one;
	}
	public void setOne(String one) {
		this.one = one;
	}
	public String getRamsa() {
		return ramsa;
	}
	public void setRamsa(String ramsa) {
		this.ramsa = ramsa;
	}
	public String getMaids() {
		return maids;
	}
	public void setMaids(String maids) {
		this.maids = maids;
	}
	public String getMisc() {
		return misc;
	}
	public void setMisc(String misc) {
		this.misc = misc;
	}
	
	
}
