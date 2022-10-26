package com.example.ApiRestDeFilmes.controller;


import com.example.ApiRestDeFilmes.controller.request.UsuarioCadastroRequest;
import com.example.ApiRestDeFilmes.entity.Usuario;
import com.example.ApiRestDeFilmes.repository.UsuarioRepository;
import com.example.ApiRestDeFilmes.service.UsuarioCadastroService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("cadastro")
@CrossOrigin("*")
public class UsuarioCadastroController {

    UsuarioCadastroService usuarioCadastroService;

    public UsuarioCadastroController(UsuarioCadastroService usuarioCadastroService) {
        this.usuarioCadastroService = usuarioCadastroService;
    }
    @GetMapping
    public List<Usuario> getUsuarios(){
       return usuarioCadastroService.getUsuario();
    }

    @PostMapping
    public void CadastrarUsuario(@RequestBody @Valid UsuarioCadastroRequest usuarioCadastroRequest){
        Usuario novoUsuario = new Usuario();

        novoUsuario.setNome(usuarioCadastroRequest.getNome());
        novoUsuario.setEmail(usuarioCadastroRequest.getEmail());
        novoUsuario.setNascimento(usuarioCadastroRequest.getNascimento());
        novoUsuario.setSenha(usuarioCadastroRequest.getSenha());

        usuarioCadastroService.verificarUsuario(novoUsuario);
    }
}