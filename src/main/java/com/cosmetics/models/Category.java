package com.cosmetics.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="category")
public class Category implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8201586255984317214L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_CATEGORY", unique = true)
	private long id;
	private String label;
	private String description;
	@OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
	private Set<Product> products;
	
	
	@JsonIgnore
	public Set<Product> getProducts() {
		return products;
	}
	@JsonIgnore
	public void setProducts(Set<Product> products) {
		this.products = products;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
