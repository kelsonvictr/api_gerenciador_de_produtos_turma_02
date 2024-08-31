package br.com.gerenciadordeprodutos.api.repository;

import br.com.gerenciadordeprodutos.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
