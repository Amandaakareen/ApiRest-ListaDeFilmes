package com.example.ApiRestDeFilmes.controller.request;


import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UsuarioCadastroRequest {

    @NotEmpty @NonNull
    private String nome;
    @Email
    private String email;
    @NotEmpty @NonNull
    private String nascimento;
    @NotEmpty @NonNull
    private String senha;
}
