package com.example.ApiRestDeFilmes.controller;

import com.example.ApiRestDeFilmes.controller.request.FilmesRequest;
import com.example.ApiRestDeFilmes.entity.Filmes;
import com.example.ApiRestDeFilmes.entity.Genero;
import com.example.ApiRestDeFilmes.service.FilmesService;
import com.example.ApiRestDeFilmes.service.GeneroService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/filmes")
@CrossOrigin("*")
public class FilmesController {

    private FilmesService filmesService;
    private GeneroService generoService;

    public FilmesController(FilmesService filmesService, GeneroService generoService) {
        this.filmesService = filmesService;
        this.generoService = generoService;
    }

    @GetMapping
    public List<Filmes> ObterTodosFilmes(){
     return filmesService.todosFilmes();
    }

   @PutMapping("{id}")
    public void editarFilme(@PathVariable("id") long id, @RequestBody @Valid FilmesRequest filmesRequest){
        Filmes filme = filmesService.filmePorId(id);
        Genero genero = generoService.obterGeneroPorId(filmesRequest.getGeneroId());

        filme.setNome(filmesRequest.getNome());
        filme.setLancamento(filmesRequest.getLancamento());
        genero.setId(filmesRequest.getGeneroId());
        filme.setDiretor(filmesRequest.getDiretor());

        filme.setGenero(genero);

        filmesService.edtFilme(filme);
    }


    @PostMapping
    public void adicionarFilme (@RequestBody @Valid FilmesRequest filmesRequest){
        Filmes filme = new Filmes();
        Genero genero = new Genero();

        filme.setNome(filmesRequest.getNome());
        filme.setLancamento(filmesRequest.getLancamento());
        genero.setId(filmesRequest.getGeneroId());
        filme.setDiretor(filmesRequest.getDiretor());

        filme.setGenero(genero);

        filmesService.cadastrarFilme(filme);
    }

    @DeleteMapping("{id}")
    public void deletarFilme(@PathVariable("id") Long id){
        filmesService.deleteFilme(id);
    }



}
