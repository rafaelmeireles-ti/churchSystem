package com.br.vinde.igrejagama.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DadosPessoaisRequest {

    private Integer idPessoa;

    private String telefone;

    private String email;

    private Date dataNascimento;

    private String profissao;

    private String cpf;

    private String identidade;

    private String estadoCivil;

    private String escolaridade;

    private String cargo;
}
