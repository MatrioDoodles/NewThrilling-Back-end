package com.cosmetics.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cosmetics.models.User;
import com.cosmetics.repositories.UserRepository;




@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  static List<User> userList = new ArrayList<>();
  @Autowired
  private UserRepository UserRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	  userList = UserRepository.findAll();
    Optional<User> findFirst = userList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}


