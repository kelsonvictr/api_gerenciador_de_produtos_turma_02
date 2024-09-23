package br.com.gerenciadordeprodutos.api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record CriarClienteRequest(
        @NotBlank(message = "O nome não pode estar em branco")
        @Size(max = 100, message = "O nome não pode ter mais que 100 caracteres")
        String nome,

        @CPF(message = "CPF inválido")
        String cpf,

        @Email(message = "Email inválido")
        String email,

        EnderecoDTO endereco
) {}