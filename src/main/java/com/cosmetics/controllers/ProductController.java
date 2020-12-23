package com.cosmetics.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cosmetics.models.Product;
import com.cosmetics.repositories.ProductRepository;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/products")
public class ProductController {

private final Path root = Paths.get("uploads/Products");
	
	public void init() {
	    try {
	      Files.createDirectory(root);
	    } catch (IOException e) {
	      throw new RuntimeException("Could not initialize folder for upload!");
	    }
	  }
	@Autowired
	private ProductRepository ProductService;
	
	@GetMapping("/GetAllProducts")
	public List<Product> GetAllProducts()
	{
		return ProductService.findAll();
	}
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product Product) {
		
		return ProductService.save(Product);
	}
	@PutMapping("/ModProduct")
	public Product ModProduct(@RequestBody Product Product) {
		
		return ProductService.save(Product);
	}
	@GetMapping("/{id}")
	public Product GetProductByid(@PathVariable long id) {
		return ProductService.findById(id).get();
	}

	@DeleteMapping("/DelProduct/{Product}")
	public void DelAscenseur(@PathVariable long Product) {
		
		ProductService.deleteById(Product);
			//return "Produit Supprimé";
	}
	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file,@RequestParam("id") long id) {
		
		String message = "";
	    try {
	    	init();
			try {
				if(Files.exists(this.root.resolve("Product."+id+"."+FilenameUtils.getExtension(file.getOriginalFilename()))))
				{Files.delete(this.root.resolve("Product."+id+"."+FilenameUtils.getExtension(file.getOriginalFilename())));}
					
			      Files.copy  (file.getInputStream(), 
			    		  this.root.resolve("Product."+id+"."+FilenameUtils.getExtension(file.getOriginalFilename())));
			    } catch (Exception e) {
			      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
			    }
	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(message);
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
	    }
	}
	@GetMapping("/img/{id}")	
	@ResponseBody
	public ResponseEntity<Resource> getimg(@PathVariable long id)
	{   
		try {	
		      Path file = root.resolve(ProductService.findById(id).get().getPicture());
		      Resource resource = new UrlResource(file.toUri());

		      if (resource.exists() || resource.isReadable()) {
		    	  return ResponseEntity.ok()
		    		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
		      } else {
		        throw new RuntimeException("Could not read the file!");
		      }
		    } catch (MalformedURLException e) {
		      throw new RuntimeException("Error: " + e.getMessage());
		    }
	    
	}
}
