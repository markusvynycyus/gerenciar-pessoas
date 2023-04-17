package com.venicios.gerenciarpessoas.api.dto.input;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PessoaInput {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;

}
