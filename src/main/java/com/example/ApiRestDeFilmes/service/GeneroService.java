package com.example.ApiRestDeFilmes.service;


import com.example.ApiRestDeFilmes.entity.Genero;
import com.example.ApiRestDeFilmes.repository.GeneroRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {

    private GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public List<Genero> obterTodos(){
       return generoRepository.findAll();
    }
    public Genero obterGeneroPorId(Long id){
        Optional<Genero> generoPorId =  generoRepository.findById(id);

        if(!generoPorId.isPresent()){
            throw new RuntimeException("não existe");
        }


        return  generoPorId.get();
    }

}
