package br.com.testeapi.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    private Pessoa pessoa;

    @BeforeEach
    void setUp() {
        pessoa = new Pessoa("TESTE", Date.valueOf("2024-04-25"));
    }

    @Test
    void getNome() {
        var v2 = pessoa;
        assertEquals(v2.getNome(), pessoa.getNome());
        assertNotNull(v2);
    }

    @Test
    void getNascimento() {
        var v2 = pessoa;
        assertEquals(v2.getNascimento(), pessoa.getNascimento());
        assertNotNull(v2);
    }
}