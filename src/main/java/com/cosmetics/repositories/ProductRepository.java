package com.cosmetics.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetics.models.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	
	public List<Product> findBywarehouse_Id(long warehouse);
	public List<Product> findBycategory_Id(long category);
	public List<Product> findBysupplier_Id(long supplier);
	
}
