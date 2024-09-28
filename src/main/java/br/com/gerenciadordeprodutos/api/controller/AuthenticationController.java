package br.com.gerenciadordeprodutos.api.controller;

import br.com.gerenciadordeprodutos.api.dtos.LoginResponse;
import br.com.gerenciadordeprodutos.api.dtos.LoginUsuarioRequest;
import br.com.gerenciadordeprodutos.api.dtos.RegistroUsuarioRequest;
import br.com.gerenciadordeprodutos.api.model.Usuario;
import br.com.gerenciadordeprodutos.api.service.AuthenticationService;
import br.com.gerenciadordeprodutos.api.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario signup(@RequestBody RegistroUsuarioRequest registroUsuarioRequest) {
        return authenticationService.signup(registroUsuarioRequest);
    }

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse signin(@RequestBody LoginUsuarioRequest loginUsuarioRequest) {
        Usuario usuarioLogado = authenticationService.signin(loginUsuarioRequest);

        String jwtToken = jwtService.generateToken(usuarioLogado);

        return new LoginResponse(jwtToken, jwtService.getExpirationTime());
    }

}
