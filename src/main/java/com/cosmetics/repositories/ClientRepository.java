package com.cosmetics.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cosmetics.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
