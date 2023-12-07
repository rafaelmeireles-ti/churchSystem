package com.br.vinde.igrejagama;

import com.br.vinde.igrejagama.model.Pessoa;
import com.br.vinde.igrejagama.repository.PessoaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;


import static org.assertj.core.api.Assertions.assertThat;
@ActiveProfiles("test")
@DataJpaTest
@DisplayName("Teste para o repositorio de pessoas")
public class PessoaRepositoryTest {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Test

    @DisplayName("Persistencia com sucesso.")
    void save_Persistencia_ComSucesso() {

        //cenário
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Maria");
        // ação
        Pessoa pessoaSalvada = pessoaRepository.save(pessoa);
        // verificação

        assertThat(pessoaSalvada).isNotNull();

        assertThat(pessoaSalvada.getIdPessoa()).isNotNull();

        assertThat(pessoaSalvada.getNome()).isEqualTo(pessoa.getNome());
    }



}
