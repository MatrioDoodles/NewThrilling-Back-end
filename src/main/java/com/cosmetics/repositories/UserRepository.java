package com.cosmetics.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cosmetics.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByusername(String username);
}
