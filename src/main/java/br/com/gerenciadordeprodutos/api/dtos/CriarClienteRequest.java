package br.com.gerenciadordeprodutos.api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record CriarClienteRequest(
        @NotBlank(message = "O nome não pode estar em branco.")
        String nome,

        @CPF(message = "CPF inválido")
        String cpf,

        @Email(message = "Email inválido")
        String email,

        EnderecoDTO endereco
) {
}
