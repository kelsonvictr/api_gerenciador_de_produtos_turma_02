package br.com.gerenciadordeprodutos.api.controller;

import br.com.gerenciadordeprodutos.api.dtos.CriarClienteRequest;
import br.com.gerenciadordeprodutos.api.dtos.ClienteCriadoResponse;
import br.com.gerenciadordeprodutos.api.dtos.ClienteResponse;
import br.com.gerenciadordeprodutos.api.model.Cliente;
import br.com.gerenciadordeprodutos.api.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public ClienteResponse buscarClientePeloId(@PathVariable Long id) {
        var cliente = clienteService.buscarClientePeloId(id);
        return new ClienteResponse(cliente);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteResponse> buscarTodosClientes() {
        return clienteService.buscarTodosClientes().stream()
                .map(ClienteResponse::new)
                .collect(Collectors.toList());
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