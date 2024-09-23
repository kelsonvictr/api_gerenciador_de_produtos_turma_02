package br.com.gerenciadordeprodutos.api.service;

import br.com.gerenciadordeprodutos.api.dtos.CriarClienteRequest;
import br.com.gerenciadordeprodutos.api.dtos.ClienteCriadoResponse;
import br.com.gerenciadordeprodutos.api.model.Cliente;
import br.com.gerenciadordeprodutos.api.model.Endereco;
import br.com.gerenciadordeprodutos.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public ClienteCriadoResponse criarCliente(CriarClienteRequest criarClienteRequest) {
        Endereco endereco = new Endereco(
                null,
                criarClienteRequest.endereco().logradouro(),
                criarClienteRequest.endereco().numero(),
                criarClienteRequest.endereco().complemento(),
                criarClienteRequest.endereco().bairro(),
                criarClienteRequest.endereco().cidade(),
                criarClienteRequest.endereco().estado(),
                criarClienteRequest.endereco().pais(),
                criarClienteRequest.endereco().cep()
        );

        Cliente cliente = new Cliente();
        cliente.setNome(criarClienteRequest.nome());
        cliente.setCpf(criarClienteRequest.cpf());
        cliente.setEmail(criarClienteRequest.email());
        cliente.setEndereco(endereco);

        Cliente clienteCriado = clienteRepository.save(cliente);

        return new ClienteCriadoResponse(
                "Cliente criado com sucesso",
                clienteCriado.getId()
        );
    }

    @Override
    public Cliente atualizarCliente(Long id, CriarClienteRequest criarClienteRequest) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        Endereco endereco = clienteExistente.getEndereco();
        if (endereco == null) {
            endereco = new Endereco();
        }

        endereco.setLogradouro(criarClienteRequest.endereco().logradouro());
        endereco.setNumero(criarClienteRequest.endereco().numero());
        endereco.setComplemento(criarClienteRequest.endereco().complemento());
        endereco.setBairro(criarClienteRequest.endereco().bairro());
        endereco.setCidade(criarClienteRequest.endereco().cidade());
        endereco.setEstado(criarClienteRequest.endereco().estado());
        endereco.setPais(criarClienteRequest.endereco().pais());
        endereco.setCep(criarClienteRequest.endereco().cep());

        clienteExistente.setNome(criarClienteRequest.nome());
        clienteExistente.setCpf(criarClienteRequest.cpf());
        clienteExistente.setEmail(criarClienteRequest.email());
        clienteExistente.setEndereco(endereco);

        return clienteRepository.save(clienteExistente);
    }

    @Override
    public void deletarClientePeloId(Long id) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        clienteRepository.delete(clienteExistente);
    }

    @Override
    public Cliente buscarClientePeloId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @Override
    public List<Cliente> buscarTodosClientes() {
        return clienteRepository.findAll();
    }
}