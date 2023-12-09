package com.addasoftwares.dscatalog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addasoftwares.dscatalog.dto.CategoryDTO;
import com.addasoftwares.dscatalog.services.CategoryService;

// Esta classe implementa os recursos REST, é a API para a aplicação;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	// 1º endpoint da de Categories
	@Autowired
	private CategoryService service;

	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll() {
		List<CategoryDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
