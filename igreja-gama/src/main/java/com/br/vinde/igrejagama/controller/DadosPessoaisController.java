package com.br.vinde.igrejagama.controller;


import com.br.vinde.igrejagama.dto.request.DadosPessoaisRequest;
import com.br.vinde.igrejagama.dto.response.DadosPessoaisResponse;
import com.br.vinde.igrejagama.model.DadosPessoais;
import com.br.vinde.igrejagama.service.DadosPessoaisService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dados-pessoais/")
public class DadosPessoaisController {

    @Autowired
    private DadosPessoaisService dadosPessoaisService;

    private static final Logger logger = LoggerFactory.getLogger(DadosPessoaisController.class);

    @Operation(summary = "inclui / altera dados basicos de pessoa", description = "inclui dados basicos de pessoa")
    @PostMapping("/incluir-dados-pessoais")
    public ResponseEntity<DadosPessoais> incluirDadosPessoais(@RequestBody DadosPessoaisRequest request ){

        DadosPessoais dadosSalvo = dadosPessoaisService.createAndSaveDadosPessoais(request );
        return ResponseEntity.status(HttpStatus.CREATED).body(dadosSalvo);

    }

    @Operation(summary = "inclui / altera dados basicos de pessoa", description = "inclui dados basicos de pessoa")
    @PostMapping("/incluir-pessoa-com-dados/{nome}")
    public ResponseEntity<DadosPessoais> incluirPessoaComDadosPessoais(@RequestBody DadosPessoaisRequest request,
                                                                       @PathVariable String nome){

        DadosPessoais dadosSalvo = dadosPessoaisService.createAndSavPessoaComDados(request , nome);
        return ResponseEntity.status(HttpStatus.CREATED).body(dadosSalvo);

    }

    @Operation(summary = " busca dados basicos de pessoa", description = "busca dados basicos de pessoa por id")
    @GetMapping("/busca-dados-pessoais/{id}")
    public ResponseEntity<List<DadosPessoaisResponse>> buscaDadosPessoais(@PathVariable Integer id){

        logger.info("********** Listando dados Pessoais");
        return ResponseEntity.ok(dadosPessoaisService.findById(id));

    }



}
