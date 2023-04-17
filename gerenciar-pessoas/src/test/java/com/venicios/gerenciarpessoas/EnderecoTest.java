package com.venicios.gerenciarpessoas;

import com.venicios.gerenciarpessoas.domain.model.Endereco;
import com.venicios.gerenciarpessoas.domain.model.Pessoa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnderecoTest {

    @Test
    public void deveCriarEnderecoCorretamente() {
        // cenário
        Pessoa pessoa = new Pessoa();
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua A");
        endereco.setCep("12345678");
        endereco.setNumero("10");
        endereco.setCidade("São Paulo");
        endereco.setPrincipal(true);
        endereco.setPessoa(pessoa);

        // verificação
        assertEquals("Rua A", endereco.getLogradouro());
        assertEquals("12345678", endereco.getCep());
        assertEquals("10", endereco.getNumero());
        assertEquals("São Paulo", endereco.getCidade());
        assertTrue(endereco.isPrincipal());
        assertEquals(pessoa, endereco.getPessoa());
    }

    @Test
    public void deveDefinirEnderecoPrincipalCorretamente() {
        // cenário
        Endereco endereco1 = new Endereco();
        endereco1.setPrincipal(true);

        Endereco endereco2 = new Endereco();
        endereco2.setPrincipal(false);

        // ação
        endereco2.setPrincipal(true);
        endereco1.setPrincipal(false);

        // verificação
        assertTrue(endereco2.isPrincipal());
        assertFalse(endereco1.isPrincipal());
    }

}

