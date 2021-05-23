package com.cosmetics.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
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
	private String pictureName;
	private String picturePath;
	private Date expiring_date;
	private Boolean perishable;
	@Column(length = 2000)
	private String description;
	private long amount;
	private long supply_amount;
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@Getter(onMethod_ = @JsonIgnore)
	private Set<OrderProduct> orderproducts;
	@OneToMany(mappedBy = "product")
	@Getter(onMethod_ = @JsonIgnore)
	private Set<Comment> comments;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_category")
	private Category category;
	@OneToMany(mappedBy = "product")
	private Set<Promotion> promotions;

	


}
