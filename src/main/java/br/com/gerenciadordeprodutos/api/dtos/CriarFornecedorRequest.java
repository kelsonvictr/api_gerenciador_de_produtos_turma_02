package br.com.gerenciadordeprodutos.api.dtos;

import br.com.gerenciadordeprodutos.api.enums.TipoFornecedorEnum;

public record CriarFornecedorRequest(
        String nome,
        String cnpj,
        String email,
        TipoFornecedorEnum tipoFornecedor
) {
}
