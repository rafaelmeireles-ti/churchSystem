package com.br.vinde.igrejagama.repository;

import com.br.vinde.igrejagama.model.DadosPessoais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DadosPessoaisRepository extends JpaRepository<DadosPessoais, Integer> {

    List<DadosPessoais> findAllByPessoaIdPessoa(Integer idPessoa);

}
