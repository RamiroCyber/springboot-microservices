package com.br.jdev.exercicio.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.jdev.exercicio.DTO.UserDTO;
import com.br.jdev.exercicio.entities.User;
import com.br.jdev.exercicio.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/all")
	public ResponseEntity<List<UserDTO>> getAll() {
		List<UserDTO> listAll = userService.getAll();
		return ResponseEntity.ok().body(listAll);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> find(@PathVariable Long id) {
		
		return ResponseEntity.ok().body();
	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user) {
		userService.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody User user) {
		if (user.getId() == null) {
			return new ResponseEntity<String>("Id não encontrado", HttpStatus.BAD_REQUEST);
		}

		User updatedUser = userService.update(user);
		return ResponseEntity.ok().body(updatedUser);
	}

}
