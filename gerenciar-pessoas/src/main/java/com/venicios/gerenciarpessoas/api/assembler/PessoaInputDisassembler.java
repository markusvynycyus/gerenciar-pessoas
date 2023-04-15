package com.venicios.gerenciarpessoas.api.assembler;

import com.venicios.gerenciarpessoas.api.dto.input.PessoaInput;
import com.venicios.gerenciarpessoas.domain.model.Pessoa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PessoaInputDisassembler {
    @Autowired
    private ModelMapper modelMapper;

    public Pessoa toDomainObject(PessoaInput pessoaInput) {
        return modelMapper.map(pessoaInput, Pessoa.class);
    }

    public void copyToDomainObject(PessoaInput pessoaInput, Pessoa pessoa) {
        modelMapper.map(pessoaInput, pessoa);
    }

}
