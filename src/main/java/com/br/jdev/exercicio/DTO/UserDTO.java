package com.br.jdev.exercicio.DTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.br.jdev.exercicio.entities.User;

public class UserDTO {

	private String name;
	private String cpf;
	private String adress;
	private String email;
	private Set<String> phones = new HashSet<>();
	private Date dateRegister;

	public UserDTO() {
	}

	public UserDTO(String name, String cpf, String adress, String email, Date dateRegister) {
		this.name = name;
		this.cpf = cpf;
		this.adress = adress;
		this.email = email;
		this.dateRegister = dateRegister;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}

	public static UserDTO convert(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setName(user.getName());
		userDTO.setAdress(user.getAdress());
		userDTO.setCpf(user.getCpf());
		userDTO.setEmail(user.getEmail());
		userDTO.getPhones().addAll(user.getPhones());
		userDTO.setDateRegister(user.getDateRegister());
		return userDTO;
	}

}
