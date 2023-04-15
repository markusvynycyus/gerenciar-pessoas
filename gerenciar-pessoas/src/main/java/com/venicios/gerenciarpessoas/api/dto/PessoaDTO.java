package com.venicios.gerenciarpessoas.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PessoaDTO {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
}
