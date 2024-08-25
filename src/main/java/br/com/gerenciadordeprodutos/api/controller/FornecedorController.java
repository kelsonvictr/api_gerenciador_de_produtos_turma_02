package br.com.gerenciadordeprodutos.api.controller;

import br.com.gerenciadordeprodutos.api.dtos.CriarFornecedorRequest;
import br.com.gerenciadordeprodutos.api.dtos.FornecedorCriadoResponse;
import br.com.gerenciadordeprodutos.api.model.Fornecedor;
import br.com.gerenciadordeprodutos.api.service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    FornecedorService fornecedorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FornecedorCriadoResponse criarFornecedor(@Valid @RequestBody CriarFornecedorRequest criarFornecedorRequest) {
        return fornecedorService.criarFornecedor(criarFornecedorRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Fornecedor buscarFornecedorPeloId(@PathVariable Long id) {
        return fornecedorService.buscarFornecedorPeloId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Fornecedor> buscarTodosFornecedores() {
        return fornecedorService.buscarTodosFornecedores();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Fornecedor atualizarFornecedor(@PathVariable Long id, @RequestBody CriarFornecedorRequest criarFornecedorRequest) {
        return fornecedorService.atualizarFornecedor(id, criarFornecedorRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarFornecedorPeloId(@PathVariable Long id) {
        fornecedorService.deletarFornecedorPeloId(id);
    }

}
