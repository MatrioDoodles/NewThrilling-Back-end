package com.cosmetics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetics.models.User;
import com.cosmetics.repositories.UserRepository;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserRepository userService;

	
	@GetMapping("/GetAllUsers")
	public List<User> GetAllUsers()
	{
		return userService.findAll();
	}
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String pass = encoder.encode(user.getPassword());
		user.setPassword(pass);
		return userService.save(user);
	}
	@PostMapping("/ModUser")
	public User ModUser(@RequestBody User user) {
		
		return userService.save(user);
	}
	@GetMapping("/{id}")
	public User GetUserByid(@PathVariable long id) {
		return userService.findById(id).get();
	}
	@GetMapping("/searchUserByUsername/{username}")  
	public User getUserByUsername(@PathVariable("username") String username){  
	return userService.findByusername(username);  
	}

	@GetMapping("/searchUserByRole/{role}")  
	public List<User> getUserByRole(@PathVariable("role") String role){  
	return userService.findByRole_label(role);  
	}

	@DeleteMapping("/DelUser/{User}")
	public void DelAscenseur(@PathVariable long user) {
		
		userService.deleteById(user);
			//return "Utilisateur Supprimé";
	}

	
	

}
