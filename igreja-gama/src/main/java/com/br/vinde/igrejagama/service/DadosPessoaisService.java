package com.br.vinde.igrejagama.service;

import com.br.vinde.igrejagama.dto.request.DadosPessoaisRequest;
import com.br.vinde.igrejagama.dto.response.DadosPessoaisResponse;
import com.br.vinde.igrejagama.dto.response.PessoaResponse;
import com.br.vinde.igrejagama.model.DadosPessoais;
import com.br.vinde.igrejagama.model.Pessoa;
import com.br.vinde.igrejagama.repository.DadosPessoaisRepository;
import com.br.vinde.igrejagama.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DadosPessoaisService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DadosPessoaisRepository dadosPessoaisRepository;

    @Transactional
    public DadosPessoais createAndSaveDadosPessoais(DadosPessoaisRequest request) {
        Pessoa pessoa = getPessoa(request.getIdPessoa());

        DadosPessoais entity = new DadosPessoais();

        entity.setCpf(request.getCpf());
        entity.setEmail(request.getEmail());
        entity.setPessoa(pessoa);
        entity.setEscolaridade(request.getEscolaridade());
        entity.setIdentidade(request.getIdentidade());
        entity.setTelefone(request.getTelefone());
        entity.setProfissao(request.getProfissao());
        entity.setEstadoCivil(request.getEstadoCivil());
        entity.setDataNascimento(request.getDataNascimento());
        entity.setCargo(request.getCargo());


        dadosPessoaisRepository.save(entity);
        return entity;
    }

    public List<DadosPessoaisResponse> findById(Integer id) {

        List<DadosPessoais> dados = dadosPessoaisRepository.findAllByPessoaIdPessoa(id);

        if (dados.isEmpty()){
            throw new EmptyResultDataAccessException(0);
        }

        return  dados
                .stream()
                .map(this::toDadosPessoaisResponse)
                .toList();
    }


    @Transactional
    public DadosPessoais createAndSavPessoaComDados(DadosPessoaisRequest request , String nome) {

        Pessoa novaPessoa = pessoaService.createAndSavePessoa(nome);

        DadosPessoais entity = new DadosPessoais();

        entity.setCpf(request.getCpf());
        entity.setEmail(request.getEmail());
        entity.setPessoa(novaPessoa);
        entity.setEscolaridade(request.getEscolaridade());
        entity.setIdentidade(request.getIdentidade());
        entity.setTelefone(request.getTelefone());
        entity.setProfissao(request.getProfissao());
        entity.setEstadoCivil(request.getEstadoCivil());
        entity.setDataNascimento(request.getDataNascimento());
        entity.setCargo(request.getCargo());

        dadosPessoaisRepository.save(entity);
        return entity;
    }

    private Pessoa getPessoa(Integer idPessoa) {
        return pessoaRepository.findById(idPessoa).
                orElseThrow(() -> new EmptyResultDataAccessException(0));
    }

    private DadosPessoaisResponse toDadosPessoaisResponse(DadosPessoais dados) {
        return modelMapper.map(dados , DadosPessoaisResponse.class);
    }


}
