package com.venicios.gerenciarpessoas.domain.service;

import com.venicios.gerenciarpessoas.domain.exception.EnderecoNaoEncontradoException;
import com.venicios.gerenciarpessoas.domain.model.Endereco;
import com.venicios.gerenciarpessoas.domain.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private static final String MSG_ENDERECO_EM_USO
            = "Endereco de código %d não pode ser removido, pois está em uso";

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco buscarOuFalhar(Long enderecoId) {
        return enderecoRepository.findById(enderecoId)
                .orElseThrow(() -> new EnderecoNaoEncontradoException(enderecoId));
    }
}
