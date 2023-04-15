package com.venicios.gerenciarpessoas.domain.model;



import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity

public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String nome;

    private LocalDate dataNascimento;


}
