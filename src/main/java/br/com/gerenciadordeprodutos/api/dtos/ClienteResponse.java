package br.com.gerenciadordeprodutos.api.dtos;

import br.com.gerenciadordeprodutos.api.model.Cliente;

public record ClienteResponse(
        Long id,
        String nome,
        String cpf,
        String email
) {
    public ClienteResponse(Cliente cliente) {
        this(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail()
        );
    }
}