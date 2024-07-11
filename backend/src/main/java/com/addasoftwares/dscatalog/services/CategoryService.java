package com.addasoftwares.dscatalog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.addasoftwares.dscatalog.dto.CategoryDTO;
import com.addasoftwares.dscatalog.entities.Category;
import com.addasoftwares.dscatalog.repositories.CategoryRepository;
import com.addasoftwares.dscatalog.services.exceptions.DatabaseException;
import com.addasoftwares.dscatalog.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

//Registra a classe como um componente que participará do sistema de inseção de dependências; 

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	// Garantias das propriedades ASID pelo framwork;
	/*
	 * @Transactional(readOnly = true) public List<CategoryDTO> findAll() {
	 * List<Category> list = repository.findAll();
	 * 
	 * // utilizando a função de alta ordem e lambida return list.stream().map(x ->
	 * new CategoryDTO(x)).collect(Collectors.toList());
	 * 
	 * }
	 */

	/*
	 * @Transactional(readOnly = true)
	public Page<CategoryDTO> findAllPaged(PageRequest pageRequest) {
		Page<Category> list = repository.findAll(pageRequest);
	 */
	
	/*@Transactional(readOnly = true)
	public Page<CategoryDTO> findAllPaged(Pageable pageable) {
		Page<Category> list = repository.findAll(pageable);

		// utilizando a função de alta ordem e lambida
		return list.map(x -> new CategoryDTO(x));

	}*/
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> list = repository.findAll();
		return list.stream().map(x -> new CategoryDTO(x)).toList();

	}

	@Transactional(readOnly = true)
	public CategoryDTO findByid(Long id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new CategoryDTO(entity);
	}

	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
		Category entity = new Category();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new CategoryDTO(entity);
	}

	@Transactional
	public CategoryDTO update(Long id, CategoryDTO dto) {
		try {
			Category entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new CategoryDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {

		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Falha de integridade referencial");
		}
	}

}
