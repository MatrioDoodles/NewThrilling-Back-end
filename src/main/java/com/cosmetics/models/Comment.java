package com.cosmetics.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity(name = "comments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 741642924465609820L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMMENT", unique = true)
	private long id;
	private String comment;
	private String nom;
	private int rating;
	private boolean approuved;
	private Date dateCom;
	@ManyToOne
	@JoinColumn(name = "id_product")
	private Product product;



}
