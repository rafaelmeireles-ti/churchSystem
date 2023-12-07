package com.br.vinde.igrejagama.repository;

import com.br.vinde.igrejagama.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    List<Pessoa> findPessoaByIdPessoa(Integer id);
}
