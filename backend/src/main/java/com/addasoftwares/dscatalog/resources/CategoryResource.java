package com.addasoftwares.dscatalog.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addasoftwares.dscatalog.entities.Category;

// Esta classe implementa os recursos REST, é a API para a aplicação;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	//1º endpoint da de Categories
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = new ArrayList<>();
		list.add(new Category(1L, "Books"));
		list.add(new Category(2L, "Electronics"));
		return ResponseEntity.ok().body(list);
	}

}
