package br.com.gerenciadordeprodutos.api.service;

import br.com.gerenciadordeprodutos.api.dtos.CriarFornecedorRequest;
import br.com.gerenciadordeprodutos.api.dtos.FornecedorCriadoResponse;

public interface FornecedorService {
    // primeira assinatura: criação do fornecedor
    FornecedorCriadoResponse criarFornecedor(CriarFornecedorRequest criarFornecedorRequest);
}
