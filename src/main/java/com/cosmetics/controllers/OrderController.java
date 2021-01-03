package com.cosmetics.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import com.cosmetics.models.Order;
import com.cosmetics.models.OrderProduct;
import com.cosmetics.repositories.OrderProductRepository;
import com.cosmetics.repositories.OrderRepository;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	private OrderRepository OrderService;
	@Autowired
	private OrderProductRepository OrderProductService;
	
	@GetMapping("/GetAllOrders")
	public List<Order> GetAllOrders()
	{
		return OrderService.findAll();
	}
	
	@PostMapping("/addOrder")
	public Order addOrder(@RequestBody Order Order) {
		OrderService.save(Order);
		Order.setOrde_date(LocalDate.now());
		DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("yyyy");
	     String today = formatter.format(Order.getOrde_date());
		Order.setMatricule("C"+Order.getId()+"D"+today);
		return OrderService.save(Order);
	}
	
	@PostMapping("/order")
	public List<OrderProduct> addOrder(@RequestBody List<OrderProduct> Order) {
		
		return OrderProductService.saveAll(Order);
	}

	@PutMapping("/ModOrder")
	public Order ModOrder(@RequestBody Order Order) {
		
		return OrderService.save(Order);
	}
	@GetMapping("/{id}")
	public Order GetOrderByid(@PathVariable long id) {
		return OrderService.findById(id).get();
	}

	@DeleteMapping("/DelOrder{Order}")
	public void DelAscenseur(@PathVariable long Order) {
		
		OrderService.deleteById(Order);
			//return "Commande Supprimé";
	}
}
