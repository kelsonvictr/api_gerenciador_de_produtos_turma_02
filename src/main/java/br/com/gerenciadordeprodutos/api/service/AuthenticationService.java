package br.com.gerenciadordeprodutos.api.service;

import br.com.gerenciadordeprodutos.api.dtos.LoginUsuarioRequest;
import br.com.gerenciadordeprodutos.api.dtos.RegistroUsuarioRequest;
import br.com.gerenciadordeprodutos.api.model.Usuario;
import br.com.gerenciadordeprodutos.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public Usuario signup(RegistroUsuarioRequest registroUsuarioRequest) {
        Usuario usuario = new Usuario();
        usuario.setNomeCompleto(registroUsuarioRequest.nomeCompleto());
        usuario.setEmail(registroUsuarioRequest.email());
        usuario.setCpf(registroUsuarioRequest.cpf());

        //Codificando a senha antes de salvar
        usuario.setSenha(passwordEncoder.encode(registroUsuarioRequest.senha()));

        return usuarioRepository.save(usuario);
    }

    public Usuario signin(LoginUsuarioRequest loginUsuarioRequest) {
        // O AuthenticationManager vai comparar a senha fornecida com a senha codificada no banco
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUsuarioRequest.email(),
                        loginUsuarioRequest.senha()
                )
        );

        return usuarioRepository.findByEmail(loginUsuarioRequest.email()).orElseThrow();
    }

}
