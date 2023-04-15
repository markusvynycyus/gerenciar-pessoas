package com.venicios.gerenciarpessoas.domain.repository;

import com.venicios.gerenciarpessoas.domain.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
}
