package com.venicios.gerenciarpessoas.api.assembler;

import com.venicios.gerenciarpessoas.api.dto.input.EnderecoInput;
import com.venicios.gerenciarpessoas.domain.model.Endereco;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Endereco toDomainObject(EnderecoInput enderecoInput) {

        return modelMapper.map(enderecoInput, Endereco.class);
    }

    public void copyToDomainObject(EnderecoInput enderecoInput, Endereco endereco) {
        modelMapper.map(enderecoInput, endereco);
    }

}
