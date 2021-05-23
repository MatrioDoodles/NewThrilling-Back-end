package com.cosmetics.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Orders_products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class OrderProduct implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2054711335476510860L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private long id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order")
	private Order order;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product")
	private Product product;
	private long quantity;

	
	

}
