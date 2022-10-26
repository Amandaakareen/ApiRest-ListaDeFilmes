package com.example.ApiRestDeFilmes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "filmes")
@Entity
public class Filmes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "lancamento")
    private String lancamento;

    @ManyToOne
    @JoinColumn(name = "generoId")
    private Genero genero;

    @Column(name = "diretor")
    private String diretor;


}
