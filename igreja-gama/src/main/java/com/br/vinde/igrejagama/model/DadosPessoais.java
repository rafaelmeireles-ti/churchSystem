package com.br.vinde.igrejagama.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "dados_pessoais")
@Getter
@Setter
@AllArgsConstructor
public class DadosPessoais  implements Serializable {

    @Serial
    private static final long serialVersionUID = 2652717080735395032L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática pelo banco de dados
    private Integer idDadosPessoais;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pessoa")
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

    public DadosPessoais() {

    }


}
