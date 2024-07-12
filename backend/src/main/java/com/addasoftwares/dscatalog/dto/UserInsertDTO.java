package com.addasoftwares.dscatalog.dto;

import com.addasoftwares.dscatalog.services.validation.UserInsertValid;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@UserInsertValid
public class UserInsertDTO extends UserDTO{
	private static final long serialVersionUID = 1L;

	@NotBlank(message =  "Campo obrigatório")
	//@Size(min = 8, message = "Deve ter no mínimo 8 caracteres")
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "Mínimo de oito caracteres, pelo menos uma letra, um número e um caractere especial")
	private String password;
	
	UserInsertDTO(){
		
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
