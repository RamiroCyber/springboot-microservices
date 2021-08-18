package com.br.jdev.exercicio.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.br.jdev.exercicio.DTO.UserDTO;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String cpf;
	private String adress;
	private String email;
	private Date dateRegister;

	@ElementCollection
	@CollectionTable(name = "phones")
	private Set<String> phones = new HashSet<>();

	public User() {
	}

	public User(String name, String cpf, String adress, String email, Date dateRegister) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.adress = adress;
		this.email = email;
		this.dateRegister = dateRegister;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public static User convert(UserDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		user.setAdress(userDTO.getAdress());
		user.setCpf(userDTO.getCpf());
		user.setEmail(userDTO.getEmail());
		user.getPhones().addAll(userDTO.getPhones());
		user.setDateRegister(userDTO.getDateRegister());
		return user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
