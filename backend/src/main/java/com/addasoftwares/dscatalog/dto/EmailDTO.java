package com.addasoftwares.dscatalog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailDTO {
	
	@NotBlank(message = "Campo obrigatório")
	@Email(message = "Email inválido")
	private String email;
	
	public EmailDTO() {
		
	}

	public EmailDTO(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

}
