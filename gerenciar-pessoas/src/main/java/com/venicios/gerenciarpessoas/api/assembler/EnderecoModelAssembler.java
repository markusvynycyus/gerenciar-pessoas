package com.venicios.gerenciarpessoas.api.assembler;


import com.venicios.gerenciarpessoas.api.dto.EnderecoDTO;
import com.venicios.gerenciarpessoas.api.dto.PessoaDTO;
import com.venicios.gerenciarpessoas.domain.model.Endereco;
import com.venicios.gerenciarpessoas.domain.model.Pessoa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EnderecoModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public EnderecoDTO toModel(Endereco endereco) {
        return modelMapper.map(endereco, EnderecoDTO.class);
    }

    public List<EnderecoDTO> toCollectionModel(List<Endereco> enderecos) {
        return enderecos.stream()
                .map(endereco -> toModel(endereco))
                .collect(Collectors.toList());
    }
}
