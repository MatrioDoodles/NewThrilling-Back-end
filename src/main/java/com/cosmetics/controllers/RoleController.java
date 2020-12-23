package com.cosmetics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetics.models.Role;
import com.cosmetics.repositories.RoleRepository;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/roles")
public class RoleController {
	@Autowired
	private RoleRepository RoleService;
	
	@GetMapping("/GetAllRoles")
	public List<Role> GetAllRoles()
	{
		return RoleService.findAll();
	}
	
	@PostMapping("/addRole")
	public Role addRole(@RequestBody Role Role) {
		
		return RoleService.save(Role);
	}
	@PutMapping("/ModRole")
	public Role ModRole(@RequestBody Role Role) {
		
		return RoleService.save(Role);
	}
	@GetMapping("/{id}")
	public Role GetRoleByid(@PathVariable long id) {
		return RoleService.findById(id).get();
	}

	@DeleteMapping("/DelRole/{Role}")
	public void DelAscenseur(@PathVariable long Role) {
		
		RoleService.deleteById(Role);
			//return "Role Supprimé";
	}
}
