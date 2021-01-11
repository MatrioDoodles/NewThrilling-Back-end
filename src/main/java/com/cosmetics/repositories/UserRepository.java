package com.cosmetics.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cosmetics.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByusername(String username);
	public List<User> findByRole_label(String role);
	public List<User> findByRole_labelAndCity(String role,String city);
}
