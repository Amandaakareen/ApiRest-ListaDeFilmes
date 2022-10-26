package com.example.ApiRestDeFilmes.service;


import com.example.ApiRestDeFilmes.entity.Filmes;
import com.example.ApiRestDeFilmes.repository.FilmesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmesService {

    private FilmesRepository filmesRepository;

    public FilmesService(FilmesRepository filmesRepository) {
        this.filmesRepository = filmesRepository;
    }

    public List<Filmes> todosFilmes (){
        List<Filmes> filmesList =  filmesRepository.todosFilmesPorNome();

        if(filmesList.isEmpty()){
            throw new RuntimeException("não existe filme cadastrado");
        }
        return filmesRepository.todosFilmesPorNome();
    }

    public Filmes filmePorId(Long id){
        Optional<Filmes> filmeId = filmesRepository.findById(id);
        return filmeId.get();
    }

    public void edtFilme(Filmes filme){
        Optional<Filmes> verFilmes = filmesRepository.findById(filme.getId());

        if (!verFilmes.isPresent()){
         throw new RuntimeException("Não existe esse filme");}

        filmesRepository.save(filme);
    }

    public void cadastrarFilme(Filmes filmes){
        Optional<Filmes> optFilme = filmesRepository.verificarNome(filmes.getNome());

        if (optFilme.isPresent()){
            throw new RuntimeException("ja cadastrado");
        }
        filmesRepository.save(filmes);


    }
    public void deleteFilme(Long id){
        Optional<Filmes> deleteFilme = filmesRepository.findById(id);

        if(!deleteFilme.isPresent()){
            throw new RuntimeException("não existe");
        }
        filmesRepository.deleteById(id);
    }
}
