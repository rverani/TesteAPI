package br.com.testeapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {
    private Long idPessoa;
    private String logradouro;
    private int cep;
    private String cidade;
    private String estado;
    private Boolean principal;

    public EnderecoDTO(Long idPessoa, String logradouro, int cep, String cidade, String estado, Boolean principal) {
        this.idPessoa = idPessoa;
        this.logradouro = logradouro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.principal = principal;
    }
}
