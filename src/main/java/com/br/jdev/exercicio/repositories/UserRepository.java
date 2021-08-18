package com.br.jdev.exercicio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.jdev.exercicio.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByCpf(String cpf);

	List<User> queryByNameLike(String name);
}
