package com.br.vinde.igrejagama.dto.response;

import com.br.vinde.igrejagama.model.Pessoa;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DadosPessoaisResponse {

    private Integer idDadosPessoais;

    private Pessoa pessoa;

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
