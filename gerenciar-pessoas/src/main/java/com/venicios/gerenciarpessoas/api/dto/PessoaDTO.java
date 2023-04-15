package com.venicios.gerenciarpessoas.api.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PessoaDTO {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
//    private List<EnderecoDTO> enderecos;

}
