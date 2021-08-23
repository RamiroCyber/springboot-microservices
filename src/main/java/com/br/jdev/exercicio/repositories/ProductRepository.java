package com.br.jdev.exercicio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.jdev.exercicio.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
