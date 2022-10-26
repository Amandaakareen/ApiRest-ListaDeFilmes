package com.example.ApiRestDeFilmes.controller;


import com.example.ApiRestDeFilmes.controller.request.UsuarioLoginRequest;
import com.example.ApiRestDeFilmes.entity.Usuario;
import com.example.ApiRestDeFilmes.service.UsuariaLoginService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class UsuarioLoginController {

    UsuariaLoginService usuariaLoginService;

    public UsuarioLoginController(UsuariaLoginService usuariaLoginService) {
        this.usuariaLoginService = usuariaLoginService;
    }

    @PostMapping
    public void logarUsuario(@RequestBody @Valid UsuarioLoginRequest usuarioLoginRequest){
        Usuario novoLogin = new Usuario();

        novoLogin.setEmail(usuarioLoginRequest.getEmail());
        novoLogin.setSenha(usuarioLoginRequest.getSenha());

        usuariaLoginService.verificarUsuarioLogado(novoLogin);
    }
}
