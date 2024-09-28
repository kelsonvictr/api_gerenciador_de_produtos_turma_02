package br.com.gerenciadordeprodutos.api.controller;

import br.com.gerenciadordeprodutos.api.dtos.UsuarioResponse;
import br.com.gerenciadordeprodutos.api.model.Usuario;
import br.com.gerenciadordeprodutos.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/me")
    public UsuarioResponse authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = (Usuario) authentication.getPrincipal();

        return new UsuarioResponse(usuario.getNomeCompleto(), usuario.getCpf(), usuario.getEmail());
    }

    @GetMapping
    public List<UsuarioResponse> todosUsuarios() {
        return usuarioService.todosUsuarios().stream()
                .map(usuario -> new UsuarioResponse(usuario.getNomeCompleto(), usuario.getCpf(), usuario.getEmail()))
                .collect(Collectors.toList());
    }
}
