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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity(name="T_order")
public class Order implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 2412558815119710708L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_ORDER", unique = true)
	private long id;
	private String description;
	private String matricule;
	private Boolean paid;
	private Boolean shipped;
	private Boolean aborted;
	private Date creation_date;
	private Date shipping_date;
	private Date pay_date;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_client")
	private Client client;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_invoice")
	private Invoice invoice;
	@ManyToMany
	@JoinTable(
			  name = "order_product", 
			  joinColumns = @JoinColumn(name = "product_id"), 
			  inverseJoinColumns = @JoinColumn(name = "order_id"))
	private Set<Product> products;
	
	
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getPaid() {
		return paid;
	}
	public void setPaid(Boolean paid) {
		this.paid = paid;
	}
	public Boolean getShipped() {
		return shipped;
	}
	public void setShipped(Boolean shipped) {
		this.shipped = shipped;
	}
	public Boolean getAborted() {
		return aborted;
	}
	public void setAborted(Boolean aborted) {
		this.aborted = aborted;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public Date getShipping_date() {
		return shipping_date;
	}
	public void setShipping_date(Date shipping_date) {
		this.shipping_date = shipping_date;
	}
	public Date getPay_date() {
		return pay_date;
	}
	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}
	
}
