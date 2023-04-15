package com.venicios.gerenciarpessoas.domain.service;

import com.venicios.gerenciarpessoas.domain.exception.PessoaNaoEncontradaException;
import com.venicios.gerenciarpessoas.domain.model.Pessoa;
import com.venicios.gerenciarpessoas.domain.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private static final String MSG_PESSOA_EM_USO
            = "Pessoa de código %d não pode ser removida, pois está em uso";
    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa buscarOuFalhar(Long pessoaId) {
        return pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new PessoaNaoEncontradaException(pessoaId));
    }

}
