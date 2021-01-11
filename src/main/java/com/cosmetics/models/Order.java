package com.cosmetics.models;

import java.io.Serializable;
import java.time.LocalDate;
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



@Entity(name="T_order")
public class Order implements Serializable{
		

	/**
	 * 
	 */
	private static final long serialVersionUID = -4990153836304746270L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_ORDER", unique = true)
	private long id;
	private String description;
	private String matricule;
	private String status;
	private Boolean paid;
	private Boolean shipped;
	private Boolean aborted;
	private LocalDate orde_date;
	private LocalDate Shipping_date;
	private String city;
	private String client_name;
	private String client_mail;
	private String client_tel;
	private String client_adress;
	private float total;
	private float shipping_cost;
	private String payment_status;
	private float total_to_pay;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_promotion")
	private Promotion promotion;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_livreur")
	private User livreur;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_consultant")
	private User consultant;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_invoice")
	private Invoice invoice;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Set<OrderProduct> orderproducts;
	
	
	public LocalDate getShipping_date() {
		return Shipping_date;
	}
	public void setShipping_date(LocalDate shipping_date) {
		Shipping_date = shipping_date;
	}
	@JsonIgnore
	public Set<OrderProduct> getOrderproducts() {
		return orderproducts;
	}
	@JsonIgnore
	public void setOrderproducts(Set<OrderProduct> orderproducts) {
		this.orderproducts = orderproducts;
	}
	public Promotion getPromotion() {
		return promotion;
	}
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	public String getClient_tel() {
		return client_tel;
	}
	public void setClient_tel(String client_tel) {
		this.client_tel = client_tel;
	}
	public String getClient_adress() {
		return client_adress;
	}
	public void setClient_adress(String client_adress) {
		this.client_adress = client_adress;
	}
	public String getClient_mail() {
		return client_mail;
	}
	public void setClient_mail(String client_mail) {
		this.client_mail = client_mail;
	}
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getOrde_date() {
		return orde_date;
	}
	public void setOrde_date(LocalDate orde_date) {
		this.orde_date = orde_date;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getShipping_cost() {
		return shipping_cost;
	}
	public void setShipping_cost(float shipping_cost) {
		this.shipping_cost = shipping_cost;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	public float getTotal_to_pay() {
		return total_to_pay;
	}
	public void setTotal_to_pay(float total_to_pay) {
		this.total_to_pay = total_to_pay;
	}
	public User getLivreur() {
		return livreur;
	}
	public void setLivreur(User livreur) {
		this.livreur = livreur;
	}
	public User getConsultant() {
		return consultant;
	}
	public void setConsultant(User consultant) {
		this.consultant = consultant;
	}

	
}
