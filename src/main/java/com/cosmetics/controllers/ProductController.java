package com.cosmetics.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.cosmetics.configuration.BucketName;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.ContentType.*;
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
@AllArgsConstructor
public class ProductController {

	private final AmazonS3 amazonS3;

	@Autowired
	private ProductRepository ProductService;
	
	@GetMapping("/GetAllProducts")
	public List<Product> GetAllProducts()
	{
		return ProductService.findAll();
	}
	
	@GetMapping("/GetRandomProducts")
	public List<Product> GetRandomProducts()
	{
		List<Product> produitsResult = ProductService.findAll() ;
		List<Product> produits = new ArrayList<Product>() ;
		for(int i=0;i<9;i++)
		{
			Random random = new Random();
			int number = random.nextInt((int)produitsResult.size());
			produits.add(produitsResult.get(number));
			
		}
		
		return produits;
	}
	
	@GetMapping("/GetProductsByLabel/{label}")
	public List<Product> GetProductsByLabel(@PathVariable String label)
	{
		return ProductService.findBylabel(label);
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
	public void upload(@RequestParam("file") MultipartFile file,@RequestParam("id") long id) {
		Optional<Map<String, String>> optionalMetaData;
		InputStream inputStream;
		if (file.isEmpty()) {
			throw new IllegalStateException("Cannot upload empty file");
		}
		//Check if the file is an image
		if (!Arrays.asList(ContentType.IMAGE_PNG.getMimeType(),
				ContentType.IMAGE_BMP.getMimeType(),
				ContentType.IMAGE_GIF.getMimeType(),
				ContentType.IMAGE_JPEG.getMimeType()).contains(file.getContentType())) {
			throw new IllegalStateException("File uploaded is not an image");
		}
		Map<String, String> metadata = new HashMap<>();
		metadata.put("Content-Type", file.getContentType());
		metadata.put("Content-Length", String.valueOf(file.getSize()));
		String path = String.format("%s/%s", BucketName.TODO_IMAGE.getBucketName(), UUID.randomUUID());
		String fileName = String.format("Product."+id+""+FilenameUtils.getExtension(file.getOriginalFilename()));
		Product pp = ProductService.findById(id).get();
		pp.setPictureName(fileName);
		pp.setPicturePath(path);
		ProductService.save(pp);
		optionalMetaData = Optional.of(metadata);
		ObjectMetadata objectMetadata = new ObjectMetadata();
		optionalMetaData.ifPresent(map -> {
			if (!map.isEmpty()) {
				map.forEach(objectMetadata::addUserMetadata);
			}
		});
		try {
			amazonS3.putObject(path, fileName, file.getInputStream(), objectMetadata);
		} catch (AmazonServiceException | IOException e) {
			throw new IllegalStateException("Failed to upload the file", e);
		}
	}

	@GetMapping("/img/{id}")	
	@ResponseBody
	public byte[] download(@PathVariable long id) {
		Product pp = ProductService.findById(id).get();
		try {
			S3Object object = amazonS3.getObject(pp.getPicturePath(), pp.getPictureName());
			S3ObjectInputStream objectContent = object.getObjectContent();
			return IOUtils.toByteArray(objectContent);
		} catch (AmazonServiceException | IOException e) {
			throw new IllegalStateException("Failed to download the file", e);
		}
	}
	/*public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file,@RequestParam("id") long id) {
		Product pp = new Product();
		String message = "";
	    try {
			try {
				//if(Files.exists(this.root.resolve("Product."+id+"."+FilenameUtils.getExtension(file.getOriginalFilename()))))
				//{Files.delete(this.root.resolve("Product."+id+"."+FilenameUtils.getExtension(file.getOriginalFilename())));}
				pp = ProductService.findById(id).get();
				pp.setPicture("Product."+id+"."+FilenameUtils.getExtension(file.getOriginalFilename()));
				ProductService.save(pp);

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
	}*/
/*	public ResponseEntity<Resource> getimg(@PathVariable long id)
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
	    
	}*/
}
