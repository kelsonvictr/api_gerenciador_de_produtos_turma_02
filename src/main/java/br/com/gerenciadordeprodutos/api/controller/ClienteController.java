package br.com.gerenciadordeprodutos.api.controller;

import br.com.gerenciadordeprodutos.api.dtos.ClienteCriadoResponse;
import br.com.gerenciadordeprodutos.api.dtos.CriarClienteRequest;
import br.com.gerenciadordeprodutos.api.model.Cliente;
import br.com.gerenciadordeprodutos.api.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteCriadoResponse criarCliente(@Valid @RequestBody CriarClienteRequest criarClienteRequest) {
        return clienteService.criarCliente(criarClienteRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente buscarClientePeloId(@PathVariable Long id) {
        return clienteService.buscarClientePeloId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> buscarTodosClientes() {
        return clienteService.buscarTodosClientes();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente atualizarCliente(@PathVariable Long id, @Valid @RequestBody CriarClienteRequest criarClienteRequest) {
        return clienteService.atualizarCliente(id, criarClienteRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarClientePeloId(@PathVariable Long id) {
        clienteService.deletarClientePeloId(id);
    }

}
