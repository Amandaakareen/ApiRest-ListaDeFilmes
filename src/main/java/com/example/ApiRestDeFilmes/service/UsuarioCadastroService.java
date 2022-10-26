package com.example.ApiRestDeFilmes.service;


import com.example.ApiRestDeFilmes.entity.Usuario;
import com.example.ApiRestDeFilmes.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioCadastroService {


     UsuarioRepository usuarioRepository;
     MD5Service md5Service;

    public UsuarioCadastroService(UsuarioRepository usuarioRepository,MD5Service md5Service) {
        this.usuarioRepository = usuarioRepository;
        this.md5Service = md5Service;
    }


    public List<Usuario> getUsuario(){
        return usuarioRepository.findAll();
    }


    public void verificarUsuario(Usuario usuario){
        Optional<Usuario> obterUsuarioVerificado = usuarioRepository.obterUsuarioPorEmail(usuario.getEmail());

        if (obterUsuarioVerificado.isPresent()){
            throw new RuntimeException("esse email ja existe");
        }
        if (obterUsuarioVerificado.isEmpty()){
            String md5 = md5Service.gerarMD5(usuario.getSenha());
            usuario.setSenha(md5);
            usuarioRepository.save(usuario);
        }

    }
}
