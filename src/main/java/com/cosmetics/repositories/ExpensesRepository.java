package com.cosmetics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cosmetics.models.Expenses;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long>{

}
