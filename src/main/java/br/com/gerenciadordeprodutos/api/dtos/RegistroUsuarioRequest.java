package br.com.gerenciadordeprodutos.api.dtos;

public record RegistroUsuarioRequest(
        String email,
        String senha,
        String nomeCompleto,
        String cpf
) {
}
