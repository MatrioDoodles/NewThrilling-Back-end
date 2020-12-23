package com.cosmetics.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity(name="product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1294594816848098920L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_PRODUCT", unique = true)
	private long id;
	private String label;
	private String reference;
	private Float selling_price_HT;
	private Float buying_price_HT;
	private String picture;
	private Date expiring_date;
	private Boolean perishable;
	private long amount;
	private long supply_amount;
	@ManyToMany(mappedBy = "products",fetch = FetchType.EAGER)
	private Set<Order> orders;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_user")
	private User user;
	
	
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public Float getSelling_price_HT() {
		return selling_price_HT;
	}
	public void setSelling_price_HT(Float selling_price_HT) {
		this.selling_price_HT = selling_price_HT;
	}
	public Float getBuying_price_HT() {
		return buying_price_HT;
	}
	public void setBuying_price_HT(Float buying_price_HT) {
		this.buying_price_HT = buying_price_HT;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Date getExpiring_date() {
		return expiring_date;
	}
	public void setExpiring_date(Date expiring_date) {
		this.expiring_date = expiring_date;
	}
	public Boolean getPerishable() {
		return perishable;
	}
	public void setPerishable(Boolean perishable) {
		this.perishable = perishable;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getSupply_amount() {
		return supply_amount;
	}
	public void setSupply_amount(long supply_amount) {
		this.supply_amount = supply_amount;
	}
	
	

}
