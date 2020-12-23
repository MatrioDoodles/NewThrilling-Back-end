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

import com.cosmetics.models.Invoice;
import com.cosmetics.repositories.InvoiceRepository;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/invoices")
public class InvoiceController {

	@Autowired
	private InvoiceRepository InvoiceService;
	
	@GetMapping("/GetAllInvoices")
	public List<Invoice> GetAllInvoices()
	{
		return InvoiceService.findAll();
	}
	
	@PostMapping("/addInvoice")
	public Invoice addInvoice(@RequestBody Invoice Invoice) {
		
		return InvoiceService.save(Invoice);
	}
	
	@PutMapping("/ModInvoice")
	public Invoice ModInvoice(@RequestBody Invoice Invoice) {
		
		return InvoiceService.save(Invoice);
	}
	@GetMapping("/{id}")
	public Invoice GetInvoiceByid(@PathVariable long id) {
		return InvoiceService.findById(id).get();
	}

	@DeleteMapping("/DelInvoice/{Invoice}")
	public void DelAscenseur(@PathVariable long Invoice) {
		
		InvoiceService.deleteById(Invoice);
			//return "Facture Supprimé";
	}
}
