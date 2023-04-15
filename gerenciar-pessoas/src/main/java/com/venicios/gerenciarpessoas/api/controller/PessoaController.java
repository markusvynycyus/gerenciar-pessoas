package com.venicios.gerenciarpessoas.api.controller;


import com.venicios.gerenciarpessoas.api.assembler.PessoaModelAssembler;
import com.venicios.gerenciarpessoas.api.dto.PessoaDTO;
import com.venicios.gerenciarpessoas.domain.model.Pessoa;
import com.venicios.gerenciarpessoas.domain.repository.PessoaRepository;
import com.venicios.gerenciarpessoas.domain.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaModelAssembler pessoaModelAssembler;

    @GetMapping
    public List<PessoaDTO> listar() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return pessoaModelAssembler.toCollectionModel(pessoas);
    }

    @GetMapping("/{pessoaId}")
    public PessoaDTO buscar(@PathVariable Long pessoaId) {
        Pessoa pessoa = pessoaService.buscarOuFalhar(pessoaId);
        return pessoaModelAssembler.toModel(pessoa);
    }

}
