package com.br.jdev.exercicio.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.jdev.exercicio.DTO.UserDTO;
import com.br.jdev.exercicio.entities.User;
import com.br.jdev.exercicio.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserDTO> getAll() {
		List<User> listUsers = userRepository.findAll();
		return listUsers.stream().map(UserDTO::convert).collect(Collectors.toList());
	}

	public User insert(User user) {
		user.setDateRegister(new Date());
		return userRepository.save(user);
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	public User find(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}

	public User update(User user) {
		return userRepository.saveAndFlush(user);
	}

}
