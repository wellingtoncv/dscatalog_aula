package com.addasoftwares.dscatalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addasoftwares.dscatalog.entities.Category;
import com.addasoftwares.dscatalog.repositories.CategoryRepository;

//Registra a classe como um componente que participará do sistema de inseção de dependências; 

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
		
	}

}
