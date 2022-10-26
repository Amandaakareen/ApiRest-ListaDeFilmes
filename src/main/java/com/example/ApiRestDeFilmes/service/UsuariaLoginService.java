package com.example.ApiRestDeFilmes.service;


import com.example.ApiRestDeFilmes.entity.Usuario;
import com.example.ApiRestDeFilmes.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuariaLoginService {

    UsuarioRepository usuarioRepository;
    MD5Service md5Service;

    public UsuariaLoginService(UsuarioRepository usuarioRepository,  MD5Service md5Service) {
        this.usuarioRepository = usuarioRepository;
        this.md5Service = md5Service;
    }

   public void verificarUsuarioLogado(Usuario usuario){
        String md5 = md5Service.gerarMD5(usuario.getSenha());

       Optional<Usuario> obterUsuario = usuarioRepository.obterUsuario(usuario.getEmail(), md5);

       if (obterUsuario.isEmpty()){
           throw new RuntimeException("esse usuario não existe");
       }
   }
}
