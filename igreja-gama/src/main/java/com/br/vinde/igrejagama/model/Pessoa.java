package com.br.vinde.igrejagama.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Pessoa")
@Getter
@Setter
@AllArgsConstructor
public class Pessoa implements Serializable {


    @Serial
    private static final long serialVersionUID = 2082757874081970475L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática pelo banco de dados
    private Integer idPessoa;

    @NonNull
    private String nome;

    private Boolean situacao;

    private LocalDate dhSituacao;

    private LocalDate dhInclusao;


    public Pessoa(){

    }

}
