package com.cosmetics.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;


@Entity(name="invoice")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Invoice implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -36183869276039051L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_INVOICE", unique = true)
	private long id;
	private Date creation_date;
	private Date pay_date;
	private String total;
	private long tenantid;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_client")
	private Client client;
	@OneToOne(mappedBy = "invoice",fetch = FetchType.LAZY)
	@JoinColumn(name="id_order")
	private Order order;
	 

}
