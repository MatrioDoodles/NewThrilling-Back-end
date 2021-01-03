package com.cosmetics.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="user")
public class User implements UserDetails {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7325751389645179303L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_USER", unique = true)
	private long id;
	private String name;
	private String surname;
	@Column(name="MAIL", unique = true)
	private String mail;
	private String phone;
	private String adress;
	private String username;
	private String password;
	private String city;
	private String Salary;
	@OneToMany(mappedBy = "livreur",fetch = FetchType.EAGER)
	private Set<Order> ordersLivreur;
	@OneToMany(mappedBy = "consultant",fetch = FetchType.EAGER)
	private Set<Order> ordersConsultants;
	@Transient
	private Collection<? extends GrantedAuthority> authorities;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_role")
	private Role role;

	
	public User(long id, String name, String surname, String mail, String phone, String adress, String username
			, String password, Role role,String roles) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.phone = phone;
		this.adress = adress;
		this.username = username;
		this.password = password;
		this.role = role;
		 List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		    authorities.add(new SimpleGrantedAuthority(roles));

		    this.authorities = authorities;
	}
	
	

	public User() {
		super();
	}




	public String getSalary() {
		return Salary;
	}



	public void setSalary(String salary) {
		Salary = salary;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public Set<Order> getOrdersLivreur() {
		return ordersLivreur;
	}



	public void setOrdersLivreur(Set<Order> ordersLivreur) {
		this.ordersLivreur = ordersLivreur;
	}



	public Set<Order> getOrdersConsultants() {
		return ordersConsultants;
	}



	public void setOrdersConsultants(Set<Order> ordersConsultants) {
		this.ordersConsultants = ordersConsultants;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	
}
