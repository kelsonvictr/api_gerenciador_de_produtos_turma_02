package br.com.gerenciadordeprodutos.api.service;

import br.com.gerenciadordeprodutos.api.model.Usuario;
import br.com.gerenciadordeprodutos.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> todosUsuarios() {
        return usuarioRepository.findAll();
    }
}