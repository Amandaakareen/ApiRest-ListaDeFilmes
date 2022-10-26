package com.example.ApiRestDeFilmes.controller;


import com.example.ApiRestDeFilmes.entity.Genero;
import com.example.ApiRestDeFilmes.service.GeneroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genero")
@CrossOrigin("*")
public class GeneroController {

    private GeneroService generoService;

    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }
    @GetMapping
    public List<Genero> obterGenero (){
        return  generoService.obterTodos();

    }
    @GetMapping("{id}")
    public Genero obterPorId(@PathVariable("id") Long id){
      return generoService.obterGeneroPorId(id);
    }

}
