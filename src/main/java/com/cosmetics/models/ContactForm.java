package com.cosmetics.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name = "contactform")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ContactForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6742089918999698917L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONTACT", unique = true)
	private long id;
	private String requestTitle;
	private String description;
	private String subject;
	private String status;
	private String name;
	private String mail;

	
}
