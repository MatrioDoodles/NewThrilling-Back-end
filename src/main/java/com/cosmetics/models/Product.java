package com.cosmetics.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "product")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 619290003214874082L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PRODUCT", unique = true)
	private long id;
	private String label;
	private String reference;
	private Float selling_price_HT;
	private Float producing_price_HT;
	private String picture;
	private Date expiring_date;
	private Boolean perishable;
	@Column(length = 2000)
	private String description;
	private long amount;
	private long supply_amount;
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Set<OrderProduct> orderproducts;
	@OneToMany(mappedBy = "product")
	private Set<Comment> comments;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_category")
	private Category category;
	@OneToMany(mappedBy = "product")
	private Set<Promotion> promotions;

	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(Set<Promotion> promotions) {
		this.promotions = promotions;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	public Set<Comment> getComments() {
		return comments;
	}

	@JsonIgnore
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@JsonIgnore
	public Set<OrderProduct> getOrderproducts() {
		return orderproducts;
	}

	@JsonIgnore
	public void setOrderproducts(Set<OrderProduct> orderproducts) {
		this.orderproducts = orderproducts;
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

	public Float getProducing_price_HT() {
		return producing_price_HT;
	}

	public void setProducing_price_HT(Float buying_price_HT) {
		this.producing_price_HT = buying_price_HT;
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
