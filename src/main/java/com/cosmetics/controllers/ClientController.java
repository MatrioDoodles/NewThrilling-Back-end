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

import com.cosmetics.models.Client;
import com.cosmetics.repositories.ClientRepository;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
	private ClientRepository clientrepo;
	
	@GetMapping("/GetAllClients")
	public List<Client> GetAllClients()
	{
		return clientrepo.findAll();
	}
	
	@PostMapping("/addClient")
	public Client addClient(@RequestBody Client Client) {
		
		return clientrepo.save(Client);
	}
	@PutMapping("/ModClient")
	public Client ModClient(@RequestBody Client Client) {
		
		return clientrepo.save(Client);
	}
	@GetMapping("/{id}")
	public Client GetClientByid(@PathVariable long id) {
		return clientrepo.findById(id).get();
	}

	@DeleteMapping("/DelClient/{id}")
	public void DelAscenseur(@PathVariable long id) {
		
		clientrepo.deleteById(id);
			//return "Client Supprimé";
	}
}
