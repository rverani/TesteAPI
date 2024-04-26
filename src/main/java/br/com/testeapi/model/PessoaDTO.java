package br.com.testeapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
public class PessoaDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private Date nascimento;

    public PessoaDTO(String nome, Date nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
    }

}
