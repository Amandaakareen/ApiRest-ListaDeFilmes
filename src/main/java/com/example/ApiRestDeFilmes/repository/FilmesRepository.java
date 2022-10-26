package com.example.ApiRestDeFilmes.repository;


import com.example.ApiRestDeFilmes.entity.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmesRepository extends JpaRepository<Filmes,Long> {

    @Query("select f from Filmes f order by nome")
    List<Filmes> todosFilmesPorNome();

    @Query("select f from Filmes f where nome = :nome")
    Optional<Filmes> verificarNome(String nome);




}
