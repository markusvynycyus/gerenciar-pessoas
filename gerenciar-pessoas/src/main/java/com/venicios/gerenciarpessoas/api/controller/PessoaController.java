package com.venicios.gerenciarpessoas.api.controller;

import com.venicios.gerenciarpessoas.api.assembler.EnderecoModelAssembler;
import com.venicios.gerenciarpessoas.api.assembler.PessoaInputDisassembler;
import com.venicios.gerenciarpessoas.api.assembler.PessoaModelAssembler;
import com.venicios.gerenciarpessoas.api.dto.EnderecoDTO;
import com.venicios.gerenciarpessoas.api.dto.PessoaDTO;
import com.venicios.gerenciarpessoas.api.dto.input.PessoaInput;
import com.venicios.gerenciarpessoas.domain.model.Endereco;
import com.venicios.gerenciarpessoas.domain.model.Pessoa;
import com.venicios.gerenciarpessoas.domain.repository.PessoaRepository;
import com.venicios.gerenciarpessoas.domain.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private PessoaInputDisassembler pessoaInputDisassembler;


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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaDTO adicionar(@RequestBody @Valid PessoaInput pessoaInput) {
        Pessoa pessoa = pessoaInputDisassembler.toDomainObject(pessoaInput);
        pessoa = pessoaService.salvar(pessoa);

        return pessoaModelAssembler.toModel(pessoa);
    }

    @PutMapping("/{pessoaId}")
    public PessoaDTO atualizar(@PathVariable Long pessoaId,
                                  @RequestBody @Valid PessoaInput pessoaInput) {
        Pessoa pessoaAtual = pessoaService.buscarOuFalhar(pessoaId);
        pessoaInputDisassembler.copyToDomainObject(pessoaInput, pessoaAtual);
        pessoaAtual = pessoaService.salvar(pessoaAtual);

        return pessoaModelAssembler.toModel(pessoaAtual);
    }


}
