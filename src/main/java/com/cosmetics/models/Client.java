package com.cosmetics.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity(name="client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Client implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5200184481705165473L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_CLIENT", unique = true)
	private long id;
	private String name;
	@Column(name="MAIL", unique = true)
	private String mail;
	private String phone;
	private String adress;
	private Float amount_bought;
	@OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
	private Set<Invoice> invoices;


}
