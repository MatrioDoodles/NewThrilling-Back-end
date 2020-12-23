package com.cosmetics.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="role")
public class Role implements Serializable {

	private static final long serialVersionUID = 7979028638168655724L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_ROLE", unique = true)
	private long id;
	private String label;
	@OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
	private Set<User> users;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
//	public Set<User> getUsers() {
//		return users;
//	}
//	public void setUsers(Set<User> users) {
//		this.users = users;
//	}

}
