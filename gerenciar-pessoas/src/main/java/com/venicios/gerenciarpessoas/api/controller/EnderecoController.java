package com.venicios.gerenciarpessoas.api.controller;

import com.venicios.gerenciarpessoas.api.assembler.EnderecoInputDisassembler;
import com.venicios.gerenciarpessoas.api.assembler.EnderecoModelAssembler;
import com.venicios.gerenciarpessoas.api.dto.EnderecoDTO;
import com.venicios.gerenciarpessoas.api.dto.input.EnderecoInput;
import com.venicios.gerenciarpessoas.domain.model.Endereco;
import com.venicios.gerenciarpessoas.domain.repository.EnderecoRepository;
import com.venicios.gerenciarpessoas.domain.service.EnderecoService;
import com.venicios.gerenciarpessoas.domain.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private EnderecoInputDisassembler enderecoInputDisassembler;

    @Autowired
    private PessoaService pessoaService;


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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnderecoDTO adicionar(@RequestBody @Valid EnderecoInput enderecoInput) {
        Endereco endereco = enderecoInputDisassembler.toDomainObject(enderecoInput);
        endereco = enderecoService.salvar(endereco);

        return enderecoModelAssembler.toModel(endereco);
    }

    @GetMapping("/pessoa/{pessoaId}/enderecos")
    public List<EnderecoDTO> listarEnderecosPorPessoa(@PathVariable Long pessoaId) {
        pessoaService.buscarOuFalhar(pessoaId); // Garante que a pessoa existe, caso contrário lança exceção
        List<Endereco> enderecos = enderecoRepository.findByPessoaId(pessoaId);
        return enderecoModelAssembler.toCollectionModel(enderecos);
    }

}
