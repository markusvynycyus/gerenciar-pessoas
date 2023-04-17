package com.venicios.gerenciarpessoas.api.dto;


import com.venicios.gerenciarpessoas.domain.model.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {

    private Long id;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private boolean principal;
    private PessoaDTO pessoa;


}
