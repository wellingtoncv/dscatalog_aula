package com.addasoftwares.dscatalog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class NewPasswordDTO {

	@NotBlank(message = "Campo obrigatório")
	private String token;
	
	@NotBlank(message = "Campo obrigatório")
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "Mínimo de oito caracteres, pelo menos uma letra, um número e um caractere especial")
	private String password;
	
	public NewPasswordDTO() {
		
	}
	
	public NewPasswordDTO(String token, String password) {
		this.token = token;
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
