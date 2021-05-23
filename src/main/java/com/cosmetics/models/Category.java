package com.cosmetics.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name="category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Category implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8201586255984317214L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_CATEGORY", unique = true)
	private long id;
	private String label;
	private String description;
	@OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
	@Getter(onMethod_ = @JsonIgnore)
	private Set<Product> products;

}
