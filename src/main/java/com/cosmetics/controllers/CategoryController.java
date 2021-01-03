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

import com.cosmetics.models.Category;
import com.cosmetics.repositories.CategoryRepository;


@RestController
@CrossOrigin("*")
@RequestMapping(value = "/categories")
public class CategoryController {

	@Autowired
	private CategoryRepository CategoryRepository;
	
	@GetMapping("/GetAllCategorys")
	public List<Category> GetAllCategorys()
	{
		return CategoryRepository.findAll();
	}
	
	@PostMapping("/addCategory")
	public com.cosmetics.models.Category addCategory(@RequestBody Category Category) {
		
		return CategoryRepository.save(Category);
	}
	@PutMapping("/ModCategory")
	public Category ModCategory(@RequestBody Category Category) {
		
		return CategoryRepository.save(Category);
	}
	@GetMapping("/{id}")
	public Category GetCategoryByid(@PathVariable long id) {
		return CategoryRepository.findById(id).get();
	}

	@DeleteMapping("/DelCategory/{Category}")
	public void DelAscenseur(@PathVariable long Category) {
		
		CategoryRepository.deleteById(Category);
			//return "Categorie Supprimé";
	}
}
