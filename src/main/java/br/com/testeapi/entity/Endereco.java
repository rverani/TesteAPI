package br.com.testeapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "endereco")
@Getter
@Setter
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idPessoa;
    private String logradouro;
    private int cep;
    private String cidade;
    private String estado;
    private Boolean principal;

    public Endereco() {

    }
}
