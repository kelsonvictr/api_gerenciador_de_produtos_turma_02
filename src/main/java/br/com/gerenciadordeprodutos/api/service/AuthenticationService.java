package br.com.gerenciadordeprodutos.api.service;

import br.com.gerenciadordeprodutos.api.dtos.LoginUserDto;
import br.com.gerenciadordeprodutos.api.dtos.LoginUserRequest;
import br.com.gerenciadordeprodutos.api.dtos.RegistroUsuarioRequest;
import br.com.gerenciadordeprodutos.api.model.Usuario;
import br.com.gerenciadordeprodutos.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public Usuario signup(RegistroUsuarioRequest input) {
        Usuario usuario = new Usuario();
        usuario.setNomeCompleto(input.nomeCompleto());
        usuario.setEmail(input.email());
        usuario.setCpf(input.cpf());

        // Codificando a senha antes de salvar
        usuario.setSenha(passwordEncoder.encode(input.senha()));

        return usuarioRepository.save(usuario);
    }

    public Usuario authenticate(LoginUserRequest input) {
        // O AuthenticationManager vai comparar a senha fornecida com a senha codificada no banco
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.email(),
                        input.senha()
                )
        );

        return usuarioRepository.findByEmail(input.email()).orElseThrow();
    }

    public List<Usuario> allUsers() {
        return usuarioRepository.findAll();
    }
}
