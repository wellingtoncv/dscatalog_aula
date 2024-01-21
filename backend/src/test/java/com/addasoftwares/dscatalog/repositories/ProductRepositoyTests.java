package com.addasoftwares.dscatalog.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.addasoftwares.dscatalog.entities.Product;
import com.addasoftwares.dscatalog.tests.Factory;

@DataJpaTest
public class ProductRepositoyTests {

	@Autowired
	private ProductRepository repository;

	private Long existingId;
	private Long nonexistingId;
	private Long countTotalProducts;

	@BeforeEach
	void setUp() throws Exception {
		existingId = 1L;
		nonexistingId = 1000L;
		countTotalProducts = 25L;
	}

	@Test
	public void saveShouldPersistWithAutoincrementWhenIdIsNull() {

		Product product = Factory.createProduct();
		product.setId(null);
		product = repository.save(product);

		Assertions.assertNotNull(product.getId());
		Assertions.assertEquals(countTotalProducts + 1, product.getId());
	}

	@Test
	public void deleteShouldDeletObjectWhenIdExists() {
		// Arrange

		// Action
		repository.deleteById(1L);

		// Assert
		Optional<Product> result = repository.findById(existingId);
		Assertions.assertFalse(result.isPresent());

	}

	@Test
	public void findByIdShouldReturnNonEmptyOptionalWhenIdExists() {
		// Arrange

		// Action
		repository.findById(existingId);

		// Assert
		Optional<Product> result = repository.findById(existingId);
		Assertions.assertTrue(result.isPresent());

	}

	@Test
	public void findByIdShouldReturnEmptyOptionalWhenIdDoesNotExists() {

		// Assert
		Optional<Product> result = repository.findById(nonexistingId);
		Assertions.assertTrue(result.isEmpty());

	}

}
