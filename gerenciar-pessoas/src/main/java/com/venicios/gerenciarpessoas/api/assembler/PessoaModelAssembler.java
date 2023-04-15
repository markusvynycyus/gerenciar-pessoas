package com.venicios.gerenciarpessoas.api.assembler;

import com.venicios.gerenciarpessoas.api.dto.PessoaDTO;
import com.venicios.gerenciarpessoas.domain.model.Pessoa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PessoaModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public PessoaDTO toModel(Pessoa pessoa) {
        return modelMapper.map(pessoa, PessoaDTO.class);
    }

    public List<PessoaDTO> toCollectionModel(List<Pessoa> pessoas) {
        return pessoas.stream()
                .map(pessoa -> toModel(pessoa))
                .collect(Collectors.toList());
    }

}
