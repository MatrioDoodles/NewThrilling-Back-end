package com.cosmetics.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name="expenses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Expenses implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3766463414748083338L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_EXPENSES", unique = true)
	private long id;
	private String advertising;
	private String phone;
	private String salaries;
	private String rent;
	private String iam;
	private String one;
	private String ramsa;
	private String maids;
	private String misc;
	private int month;
	private int year;
	

	
	
}
