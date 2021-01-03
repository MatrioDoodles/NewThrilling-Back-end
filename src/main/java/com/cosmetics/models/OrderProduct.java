package com.cosmetics.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders_products")
public class OrderProduct implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2054711335476510860L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private long id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_order")
	private Order order;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_product")
	private Product product;
	private long quantity;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	

}
