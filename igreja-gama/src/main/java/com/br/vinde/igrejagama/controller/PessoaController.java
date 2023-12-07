package com.br.vinde.igrejagama.controller;

import com.br.vinde.igrejagama.dto.request.PessoaRequest;
import com.br.vinde.igrejagama.dto.response.PessoaResponse;
import com.br.vinde.igrejagama.model.Pessoa;
import com.br.vinde.igrejagama.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    private static final Logger logger = LoggerFactory.getLogger(PessoaController.class);

    @Autowired
    private PessoaService pessoaService;

    @Operation(summary = "busca todas as pessoas", description = "lista todas as pessoas cadastradas na base")
    @GetMapping("/lista-pessoa")
    public ResponseEntity<List<PessoaResponse>> buscarListaPessoa(){
        logger.info("********** Listando todas as pessoas");
        return ResponseEntity.ok(pessoaService.findByall());
    }

    @Operation(summary = "inclui nova pessoa", description = "inclui nova pessoa somente com nome")
    @PostMapping("/{nome}/{dataNascimento}/incluir-pessoa")
    public ResponseEntity<Pessoa> incluirPessoa(@PathVariable String nome ){
        logger.info("********** Incluindo nova pessoa");
        Pessoa pessoaSalva = pessoaService.createAndSavePessoa(nome );
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @Operation(summary="Deleta registro por código", description = "apaga registro fisicamente")
    @DeleteMapping("/{idPessoa}/deletar-pessoa")
    public ResponseEntity<?> deletePessoa(@PathVariable Integer idPessoa){
        try {
            pessoaService.deleteByCodigo(idPessoa);
        }catch(IllegalArgumentException iae){
            logger.warn("********** Excecao de pessoa que não existe");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não existe a pessoa a ser apagada");
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary="Inativa registro por código", description = "apaga registro logicamente")
    @PostMapping("/{idPessoa}/inativar-pessoa")
    public ResponseEntity<?> inativaPessoa(@PathVariable Integer idPessoa){
        pessoaService.inativeByCodigo(idPessoa);
        return  ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary="Atualiza registro por código", description = "Atualiza dados de Pessoa por id")
    @PutMapping ("/{idPessoa}/atualizar-pessoa")
    public ResponseEntity<?> AtualizaPessoa(@PathVariable Integer idPessoa ,
                                            @RequestBody PessoaRequest request) {
        try {
            pessoaService.updatePessoa(idPessoa, request.getNome());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não existe a pessoa a ser apagada");
        }
        return  ResponseEntity.ok(HttpStatus.OK);
    }



}
