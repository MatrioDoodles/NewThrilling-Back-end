package com.cosmetics.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetics.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	public List<Order> findByconsultantIsNull();
	public List<Order> findBylivreur_username(String username);
	public List<Order> findByconsultant_username(String username);
	public List<Order> findBycity(String city);
}
