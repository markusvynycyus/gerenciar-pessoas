package com.venicios.gerenciarpessoas;

import com.venicios.gerenciarpessoas.domain.model.Endereco;
import com.venicios.gerenciarpessoas.domain.model.Pessoa;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PessoaTest {

    @Test
    void deveCriarUmaPessoa() {
        // cenário
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("João");
        pessoa.setDataNascimento(LocalDate.of(2000, 1, 1));

        // ação
        Long id = pessoa.getId();
        String nome = pessoa.getNome();
        LocalDate dataNascimento = pessoa.getDataNascimento();

        // verificação
        assertEquals(1L, id);
        assertEquals("João", nome);
        assertEquals(LocalDate.of(2000, 1, 1), dataNascimento);
    }

    @Test
    void deveAdicionarEnderecoAUmaPessoa() {
        // cenário
        Pessoa pessoa = new Pessoa();
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua A");
        endereco.setCep("12345678");
        endereco.setNumero("10");
        endereco.setCidade("São Paulo");
        endereco.setPessoa(pessoa);

        // ação
        pessoa.getEnderecos().add(endereco);

        // verificação
        //verifica se a lista de endereços da pessoa contém exatamente um endereço após a adição
        assertEquals(1, pessoa.getEnderecos().size());
        //verifica se o atributo "pessoa" do endereço adicionado é igual à instância de pessoa recém-criada.
        assertEquals(pessoa, endereco.getPessoa());
    }

}
