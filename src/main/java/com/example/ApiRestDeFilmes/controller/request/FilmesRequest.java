package com.example.ApiRestDeFilmes.controller.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class FilmesRequest {

    @NotEmpty @NotNull
    private String nome;
    @NotEmpty @NotNull
    private String lancamento;
    @NotNull @Min(1)
    private Long generoId;
    @NotEmpty @NotNull
    private String diretor;

}
