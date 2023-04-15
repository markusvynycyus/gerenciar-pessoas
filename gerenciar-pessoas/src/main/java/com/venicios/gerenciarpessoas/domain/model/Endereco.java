package com.venicios.gerenciarpessoas.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String cidade;

    private boolean principal;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Pessoa pessoa;

}
