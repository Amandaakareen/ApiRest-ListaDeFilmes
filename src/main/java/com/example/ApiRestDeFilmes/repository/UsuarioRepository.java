package com.example.ApiRestDeFilmes.repository;

import com.example.ApiRestDeFilmes.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query("select u from Usuario u where u.email = :email ")
    Optional<Usuario> obterUsuarioPorEmail(String email);

    @Query("select u from Usuario u where u.email = :email and u.senha = :senha")
    Optional<Usuario> obterUsuario(String email, String senha);
}
