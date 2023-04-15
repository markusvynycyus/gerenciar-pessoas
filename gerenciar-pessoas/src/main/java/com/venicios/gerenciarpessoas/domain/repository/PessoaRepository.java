package com.venicios.gerenciarpessoas.domain.repository;

import com.venicios.gerenciarpessoas.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
}
