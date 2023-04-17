package com.venicios.gerenciarpessoas.api.dto.input;

import com.venicios.gerenciarpessoas.api.dto.PessoaDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoInput {
    private Long id;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private boolean principal;
    private PessoaInput pessoa;
}


