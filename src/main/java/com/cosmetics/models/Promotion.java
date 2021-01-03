package com.cosmetics.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity(name="promotion")
public class Promotion {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PROMOTION", unique = true)
	private long id;
	private String code;
	private Date expiring_date;
	private float reduction;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_product")
	private Product product;
	@OneToMany(mappedBy = "promotion",fetch = FetchType.EAGER)
	private Set<Order> orders;
	
	
	
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getExpiring_date() {
		return expiring_date;
	}
	public void setExpiring_date(Date expiring_date) {
		this.expiring_date = expiring_date;
	}
	public float getReduction() {
		return reduction;
	}
	public void setReduction(float reduction) {
		this.reduction = reduction;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	
}
