package br.com.gerenciadordeprodutos.api.repository;

import br.com.gerenciadordeprodutos.api.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
