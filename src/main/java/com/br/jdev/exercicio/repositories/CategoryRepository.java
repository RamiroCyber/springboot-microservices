package com.br.jdev.exercicio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.jdev.exercicio.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
