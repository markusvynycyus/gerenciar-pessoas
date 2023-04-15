package com.venicios.gerenciarpessoas.api.controller;


import com.venicios.gerenciarpessoas.api.assembler.EnderecoModelAssembler;
import com.venicios.gerenciarpessoas.api.dto.EnderecoDTO;
import com.venicios.gerenciarpessoas.domain.model.Endereco;
import com.venicios.gerenciarpessoas.domain.repository.EnderecoRepository;
import com.venicios.gerenciarpessoas.domain.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoModelAssembler enderecoModelAssembler;


    @GetMapping
    public List<EnderecoDTO> listar() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecoModelAssembler.toCollectionModel(enderecos);
    }

    @GetMapping("/{enderecoId}")
    public EnderecoDTO buscar(@PathVariable Long enderecoId) {
        Endereco endereco = enderecoService.buscarOuFalhar(enderecoId);
        return enderecoModelAssembler.toModel(endereco);
    }

}
