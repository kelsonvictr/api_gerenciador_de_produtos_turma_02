package br.com.gerenciadordeprodutos.api.dtos;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CriarProdutoRequest(
        @NotBlank(message = "O nome não pode estar em branco")
        @Size(max = 100, message = "O nome não pode ter mais que 100 caracteres")
        String nome,

        @NotNull(message = "O preço é obrigatório")
        @Digits(integer = 13, fraction = 2, message = "O preço deve ter no máximo 13 dígitos inteiros e 2 decimais")
        @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero")
        BigDecimal preco,

        @Size(max = 255, message = "A descrição não pode ter mais que 255 caracteres")
        String descricao,

        @NotNull(message = "O fornecedor é obrigatório")
        Long fornecedorId
) {
}
