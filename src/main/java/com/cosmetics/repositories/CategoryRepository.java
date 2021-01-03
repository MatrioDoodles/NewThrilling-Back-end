package com.cosmetics.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetics.models.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
