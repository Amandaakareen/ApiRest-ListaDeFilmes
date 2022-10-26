package com.example.ApiRestDeFilmes.repository;

import com.example.ApiRestDeFilmes.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {


}