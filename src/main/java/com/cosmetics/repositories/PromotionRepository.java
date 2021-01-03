package com.cosmetics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetics.models.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

}
