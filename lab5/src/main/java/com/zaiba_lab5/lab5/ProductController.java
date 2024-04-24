package com.zaiba_lab5.lab5;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private final List<Product> products=new ArrayList<>();
	
	@PostMapping
	public ResponseEntity<?> addProduct(@Valid @RequestBody Product p, BindingResult result){
		
		List<String> displayErrors=getErrors(result);
		
		if(!displayErrors.isEmpty()) {
			return ResponseEntity.badRequest().body(displayErrors);
		}
		
		products.add(p);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
		
	}
	
	public List<String> getErrors(BindingResult result){

		List<String> displayErrors=new ArrayList<>();
		
		
		if(result.hasErrors()) {
			List<FieldError> errors=result.getFieldErrors();
			for(FieldError error:errors) {
				displayErrors.add(error.getField()+":"+error.getDefaultMessage());
			}
		}
		
		return displayErrors;
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable Long id,@Valid @RequestBody Product p, BindingResult result){
		
		Product ep=findProductById(id);
		
		if(ep==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
		}
		
		List<String> displayErrors=getErrors(result);
		
		if(!displayErrors.isEmpty()) {
			return ResponseEntity.badRequest().body(displayErrors);
		}
		
		ep.setName(p.getName());
		ep.setPrice(p.getPrice());
		return ResponseEntity.ok(ep);
		
	}
	
	public Product findProductById(Long id) {
		for(Product p:products) {
			if(p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}

}
