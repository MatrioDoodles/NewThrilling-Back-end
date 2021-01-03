package com.cosmetics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetics.models.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


}
