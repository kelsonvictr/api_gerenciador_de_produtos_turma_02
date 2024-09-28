package br.com.gerenciadordeprodutos.api.dtos;

public record LoginUserRequest(
        String email,
        String senha
) {
}

