package com.cosmetics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetics.models.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
