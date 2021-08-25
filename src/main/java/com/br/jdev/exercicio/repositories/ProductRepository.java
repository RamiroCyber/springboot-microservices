package com.br.jdev.exercicio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.jdev.exercicio.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	
	@Query(value = "select p.name, p.price" 
			+ "p.productIdentifier , p.description"
			+ "from product p"
			+ "join category c on p.category.id = c.id"
			+ "where c.id = :categoryId" )
	public List<Product> getProductByCategory(@Param("categoryId") long categoryId);
}
