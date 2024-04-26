package br.com.testeapi.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoTest {

    private Endereco endereco;

    @BeforeEach
    void setUp() {
        endereco = new Endereco();
        endereco.setPrincipal(true);
        endereco.setCep(20541350);
        endereco.setLogradouro("Rua Caçapava");
        endereco.setIdPessoa(1L);
        endereco.setEstado("Rio de Jwneiro");
        endereco.setCidade("Rio de Jwneiro");
    }

    @Test
    void getId() {
        var v2 = endereco;
        assertEquals(v2.getId(), endereco.getId());
        assertNotNull(v2);
    }

    @Test
    void getIdPessoa() {
        var v2 = endereco;
        assertEquals(v2.getIdPessoa(), endereco.getIdPessoa());
        assertNotNull(v2);
    }

    @Test
    void getLogradouro() {
        var v2 = endereco;
        assertEquals(v2.getLogradouro(), endereco.getLogradouro());
        assertNotNull(v2);

    }

    @Test
    void getCep() {
        var v2 = endereco;
        assertEquals(v2.getCep(), endereco.getCep());
        assertNotNull(v2);
    }

    @Test
    void getCidade() {
        var v2 = endereco;
        assertEquals(v2.getCidade(), endereco.getCidade());
        assertNotNull(v2);
    }

    @Test
    void getEstado() {
        var v2 = endereco;
        assertEquals(v2.getEstado(), endereco.getEstado());
        assertNotNull(v2);
    }

    @Test
    void getPrincipal() {
        var v2 = endereco;
        assertEquals(v2.getPrincipal(), endereco.getPrincipal());
        assertNotNull(v2);
    }
}