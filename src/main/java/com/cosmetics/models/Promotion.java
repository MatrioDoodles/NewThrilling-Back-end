package com.cosmetics.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;


@Entity(name="promotion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Promotion {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PROMOTION", unique = true)
	private long id;
	private String code;
	private Date expiring_date;
	private float reduction;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_product")
	private Product product;
	@OneToMany(mappedBy = "promotion",fetch = FetchType.LAZY)
	@Getter(onMethod_ = @JsonIgnore)
	private Set<Order> orders;

	
	
}
