package br.com.gerenciadordeprodutos.api.controller;

import br.com.gerenciadordeprodutos.api.dtos.LoginResponse;
import br.com.gerenciadordeprodutos.api.dtos.LoginUserRequest;
import br.com.gerenciadordeprodutos.api.dtos.RegistroUsuarioRequest;
import br.com.gerenciadordeprodutos.api.model.Usuario;
import br.com.gerenciadordeprodutos.api.service.AuthenticationService;
import br.com.gerenciadordeprodutos.api.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationService authenticationService;


    @PostMapping("/signup")
    public Usuario register(@RequestBody RegistroUsuarioRequest registroUsuarioRequest) {

        return authenticationService.signup(registroUsuarioRequest);
    }

    @PostMapping("/login")
    public LoginResponse authenticate(@RequestBody LoginUserRequest loginUserRequest) {
        Usuario authenticatedUser = authenticationService.authenticate(loginUserRequest);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        return new LoginResponse(jwtToken, jwtService.getExpirationTime());
    }
}