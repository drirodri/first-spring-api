package com.dri.first_api.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateUserDTO {

    @NotEmpty
    @NotBlank
    @Size(min = 4, max = 100, message = "O nome deve ter entre 4 e 100 caracteres")
    private String name;

    @NotBlank(message = "O e-mail não pode ser vazio")
    @Email(message = "E-mail inválido")
    private String email;

    @NotBlank(message = "O tipo não pode ser vazio")
    private String type;

}

