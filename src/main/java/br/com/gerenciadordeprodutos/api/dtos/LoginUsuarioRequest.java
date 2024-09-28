package br.com.gerenciadordeprodutos.api.dtos;

public record LoginUsuarioRequest(
        String email,
        String senha
) {
}
