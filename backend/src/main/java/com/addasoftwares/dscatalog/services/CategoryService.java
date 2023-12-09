package com.addasoftwares.dscatalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.addasoftwares.dscatalog.dto.CategoryDTO;
import com.addasoftwares.dscatalog.entities.Category;
import com.addasoftwares.dscatalog.repositories.CategoryRepository;

//Registra a classe como um componente que participará do sistema de inseção de dependências; 

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	// Garantias das propriedades ASID pelo framwork;

	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> list = repository.findAll();

		//utilizando a função de alta ordem e lambida
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());

	}

}
