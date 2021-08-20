package com.br.jdev.exercicio.services;

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

	public UserDTO insert(UserDTO userDTO) {
		User user = userRepository.save(User.convert(userDTO));
		return UserDTO.convert(user);
	}

	public void delete(Long id) {
		if (id != null) {
			userRepository.deleteById(id);
		}
	}

	public UserDTO findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return UserDTO.convert(user.get());
		}
		return null;
	}

	public UserDTO findByCpf(String cpf) {
		User user = userRepository.findByCpf(cpf);
		if (user != null) {
			return UserDTO.convert(user);
		}
		return null;
	}

	public UserDTO update(UserDTO userDTO) {
		User user = userRepository.saveAndFlush(User.convert(userDTO));
		return UserDTO.convert(user);
	}

	public List<UserDTO> findByName(String name) {
		List<User> listUsers = userRepository.queryByNameLike(name);
		return listUsers.stream().map(UserDTO::convert).collect(Collectors.toList());
	}

}
