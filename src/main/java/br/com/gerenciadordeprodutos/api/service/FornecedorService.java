package br.com.gerenciadordeprodutos.api.service;

import br.com.gerenciadordeprodutos.api.dtos.CriarFornecedorRequest;
import br.com.gerenciadordeprodutos.api.dtos.FornecedorCriadoResponse;
import br.com.gerenciadordeprodutos.api.model.Fornecedor;

public interface FornecedorService {
    FornecedorCriadoResponse criarFornecedor(CriarFornecedorRequest criarFornecedorRequest);
    Fornecedor buscarFornecedorPeloId(Long id);
}
