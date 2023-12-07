package com.br.vinde.igrejagama.service;

import com.br.vinde.igrejagama.dto.response.PessoaResponse;
import com.br.vinde.igrejagama.enums.SituacaoEnum;
import com.br.vinde.igrejagama.model.Pessoa;
import com.br.vinde.igrejagama.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PessoaRepository pessoaRepository;


    public List<PessoaResponse> findByall() {
        List<Pessoa> pessoalist = pessoaRepository.findAll();

        if (pessoalist.isEmpty()){
            throw new EmptyResultDataAccessException(0);
        }

        return pessoalist
                .stream()
                .peek(pessoa -> pessoa.setNome(pessoa.getNome().toUpperCase()))
                .map(this::toPessoaResponse)
                .toList();
    }

    private PessoaResponse toPessoaResponse(Pessoa pessoa) {
        return modelMapper.map(pessoa , PessoaResponse.class);
    }

    @Transactional
    public Pessoa createAndSavePessoa(String nome  ) {
        Pessoa entity = new Pessoa();

        entity.setNome(nome);
        entity.setDhInclusao(LocalDate.now());
        entity.setSituacao(SituacaoEnum.ATIVO.getValor());
        entity.setDhSituacao(LocalDate.now());
        pessoaRepository.save(entity);
        return entity;
    }

    @Transactional
    public ResponseEntity<?> deleteByCodigo(Integer idPessoa) {
        // verifica se a pessoa existe

        List<Pessoa> pessoalist = pessoaRepository.findPessoaByIdPessoa(idPessoa);

        if (!pessoalist.isEmpty()) {
            pessoaRepository.deleteById(idPessoa);
            return ResponseEntity.ok(HttpStatus.OK);

        }else {
            throw new IllegalArgumentException("Não existe a pessoa");
        }
    }

    public void updatePessoa(Integer idPessoa, String nome) {
        Pessoa pessoa = getPessoaById(idPessoa);

        pessoa.setNome(nome);
        pessoa.setDhSituacao(LocalDate.now());

        pessoaRepository.save(pessoa);

    }

    public void inativeByCodigo(Integer idPessoa) {
        Pessoa pessoa = getPessoaById(idPessoa);

        pessoa.setSituacao(SituacaoEnum.INATIVO.getValor());
        pessoa.setDhSituacao(LocalDate.now());

        pessoaRepository.save(pessoa);
    }

    private Pessoa getPessoaById(Integer idPessoa) {
        return pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new EmptyResultDataAccessException("Nao encontrei essa pessoa",0));
    }


}
