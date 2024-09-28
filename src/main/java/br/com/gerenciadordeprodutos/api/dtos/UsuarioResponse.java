package br.com.gerenciadordeprodutos.api.dtos;

public record UsuarioResponse(
        String nomeCompleto,
        String cpf,
        String email
) {}
