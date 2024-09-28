package br.com.gerenciadordeprodutos.api.dtos;

public record LoginResponse(
        String token,
        Long expiraEm
) {
}
