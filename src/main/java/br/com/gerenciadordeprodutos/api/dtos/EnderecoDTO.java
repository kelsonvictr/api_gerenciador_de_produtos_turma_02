package br.com.gerenciadordeprodutos.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EnderecoDTO(
        @NotBlank(message = "O logradouro não pode estar em branco")
        @Size(max = 150, message = "O logradouro não pode ter mais que 150 caracteres")
        String logradouro,

        @NotBlank(message = "O número não pode estar em branco")
        @Size(max = 10, message = "O número não pode ter mais que 10 caracteres")
        String numero,

        @Size(max = 50, message = "O complemento não pode ter mais que 50 caracteres")
        String complemento,

        @NotBlank(message = "O bairro não pode estar em branco")
        @Size(max = 50, message = "O bairro não pode ter mais que 50 caracteres")
        String bairro,

        @NotBlank(message = "A cidade não pode estar em branco")
        @Size(max = 50, message = "A cidade não pode ter mais que 50 caracteres")
        String cidade,

        @NotBlank(message = "O estado não pode estar em branco")
        @Size(max = 50, message = "O estado não pode ter mais que 50 caracteres")
        String estado,

        @NotBlank(message = "O país não pode estar em branco")
        @Size(max = 50, message = "O país não pode ter mais que 50 caracteres")
        String pais,

        @NotBlank(message = "O CEP não pode estar em branco")
        @Size(max = 20, message = "O CEP não pode ter mais que 20 caracteres")
        String cep
) {}
