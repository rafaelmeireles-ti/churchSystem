package com.br.vinde.igrejagama.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class PessoaResponse {

    private Integer IdPessoa;
    private String nome;
    private Boolean situacao;
    private LocalDate dhInclusao;
    private LocalDate dhSituacao;
}
