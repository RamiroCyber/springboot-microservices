package com.br.jdev.exercicio.controller;

import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.jdev.exercicio.DTO.UserDTO;
import com.br.jdev.exercicio.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findByName(@RequestParam(name = "name", required = true) String name) {
		List<UserDTO> listUserDTO = userService.findByName(name);
		return ResponseEntity.ok().body(listUserDTO);
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> getAll() {
		List<UserDTO> listAll = userService.getAll();
		return ResponseEntity.ok().body(listAll);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
		UserDTO userDTO = userService.findById(id);
		return ResponseEntity.ok().body(userDTO);
	}

	@PostMapping
	public ResponseEntity<UserDTO> insert(@RequestBody UserDTO userDTO) {
		userService.insert(userDTO);

		return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody UserDTO userDTO) {
		if (userDTO.equals(null)) {
			return new ResponseEntity<String>("Id não encontrado", HttpStatus.BAD_REQUEST);
		}

		UserDTO updatedUser = userService.update(userDTO);
		return ResponseEntity.ok().body(updatedUser);
	}

}
