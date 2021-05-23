package com.cosmetics.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity(name="T_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_promotion")
	private Promotion promotion;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_livreur")
	private User livreur;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_consultant")
	private User consultant;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_invoice")
	private Invoice invoice;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@Getter(onMethod_ = @JsonIgnore)
	private Set<OrderProduct> orderproducts;


	
}
