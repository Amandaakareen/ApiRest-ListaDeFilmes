package com.example.ApiRestDeFilmes.controller.request;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class UsuarioLoginRequest {

    @Email
    private String email;
    @NotEmpty @NonNull
    private String senha;

}
