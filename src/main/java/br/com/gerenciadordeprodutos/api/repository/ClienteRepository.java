package br.com.gerenciadordeprodutos.api.repository;

import br.com.gerenciadordeprodutos.api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}