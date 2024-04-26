package br.com.testeapi;

import br.com.testeapi.entity.Endereco;
import br.com.testeapi.entity.Pessoa;
import br.com.testeapi.model.EnderecoDTO;
import br.com.testeapi.model.PessoaDTO;
import br.com.testeapi.repository.EnderecoRepository;
import br.com.testeapi.repository.PessoaRepository;
import br.com.testeapi.service.EnderecoService;
import br.com.testeapi.service.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
class TesteDeApiApplicationTest {

    private PessoaRepository pessoaRepository;
    private EnderecoRepository enderecoRepository;
    private PessoaService pessoaService;
    private EnderecoService enderecoService;
    private Endereco enderecos;

    @Mock
    private Pessoa pessoa;

    @BeforeEach
    void setup() {
        pessoaRepository = Mockito.mock(PessoaRepository.class);
        enderecoRepository = Mockito.mock(EnderecoRepository.class);
        pessoaService = new PessoaService(pessoaRepository);
        enderecoService = new EnderecoService(enderecoRepository);

        enderecos = new Endereco();
        enderecos.setId(1L);
        enderecos.setIdPessoa(1L);
        enderecos.setCep(20541350);
        enderecos.setCidade("Rio de Janeiro");
        enderecos.setEstado("Rio de Janeiro");
        enderecos.setPrincipal(true);


    }

    @Test
    void testCreatePessoaSuccess() {
        var person = new PessoaDTO("teste", Date.valueOf("2024-04-25"));
        var pessoas = new Pessoa();
        pessoas.setId(1L);
        pessoas.setNome("teste");
        pessoas.setNascimento(Date.valueOf("2024-04-25"));
        Mockito.when(pessoaRepository.save(any())).thenReturn(pessoas);
        List<Pessoa> pessoa = this.pessoaService.creatPessoa(person);

        assertTrue(pessoa.isEmpty());

    }
    @Test
    void testCreatePessoaFailure() {
        Mockito.when(pessoaRepository.save(any())).thenThrow(NullPointerException.class);

        assertThrows(NullPointerException.class, () -> pessoaRepository.save(any()));

    }

    @Test
    void testUpdatePessoaSuccess() {
        var pessoas = new Pessoa();
        pessoas.setId(1L);
        pessoas.setNome("teste");
        pessoas.setNascimento(Date.valueOf("2024-04-25"));
        Mockito.when(pessoaRepository.save(any())).thenReturn(pessoas);
        List<Pessoa> pessoa = this.pessoaService.updatePessoa(pessoas);

        assertTrue(pessoa.isEmpty());

    }
    @Test
    void testUpdatePessoaFailure() {
        Mockito.when(pessoaRepository.save(any())).thenThrow(NullPointerException.class);

        assertThrows(NullPointerException.class, () -> pessoaRepository.save(any()));

    }
    @Test
    void testlistPessoaSuccess() {
        var pessoas = new Pessoa();
        pessoas.setId(1L);
        pessoas.setNome("teste");
        pessoas.setNascimento(Date.valueOf("2024-04-25"));
        Mockito.when(pessoaRepository.findAll()).thenReturn(List.of(pessoas));
        List pessoa = this.pessoaService.listPessoa();

        assertEquals(List.of(pessoas), pessoa);
        Mockito.verify(this.pessoaRepository).findAll();
    }
    @Test
    void testlistPessoaFailure() {
        Mockito.when(pessoaRepository.findAll()).thenThrow(NullPointerException.class);

        assertThrows(NullPointerException.class, () -> pessoaRepository.findAll());

    }

    @Test
    void testdeletePessoaSuccess() {
        var pessoas = new Pessoa();
        pessoas.setId(1L);
        Mockito.doNothing().when(pessoaRepository).deleteById(pessoas.getId());
        this.pessoaService.deletePessoa(pessoas.getId());

        Mockito.verify(this.pessoaRepository).deleteById(pessoas.getId());
    }
    @Test
    void testdeletePessoaFailure() {
        assertThrows(Exception.class, () -> {
          Mockito.doThrow().when(pessoaRepository).deleteById(0L);
        });
    }



    @Test
    void testCreateEnderecoSuccess() {
        var ender = new EnderecoDTO(1L, "Rua Teste", 20541350, "Rio de Janeiro", "Rio de Janeiro", true);
        Mockito.when(enderecoRepository.save(any())).thenReturn(this.enderecos);
        List<Endereco>  endereco = this.enderecoService.createEndereco(ender);

        assertTrue(endereco.isEmpty());

    }
    @Test
    void testCreateEnderecoFailure() {
        Mockito.when(enderecoRepository.save(any())).thenThrow(NullPointerException.class);

        assertThrows(NullPointerException.class, () -> enderecoRepository.save(any()));

    }

    @Test
    void testUpdateEnderecoSuccess() {
        Mockito.when(enderecoRepository.save(any())).thenReturn(enderecos);
        List<Endereco> enderecos1 = this.enderecoService.updateEndereco(enderecos);

        assertTrue(enderecos1.isEmpty());

    }
    @Test
    void testUpdateEnderecoFailure() {
        Mockito.when(enderecoRepository.save(any())).thenThrow(NullPointerException.class);

        assertThrows(NullPointerException.class, () -> enderecoRepository.save(any()));

    }
    @Test
    void testlistEnderecoSuccess() {
        Mockito.when(enderecoRepository.queryEnderecosByIdPessoa(any())).thenReturn(List.of(enderecos));
        List endereco = this.enderecoService.listEndereco(1L);

        assertEquals(List.of(enderecos), endereco);
        Mockito.verify(this.enderecoRepository).queryEnderecosByIdPessoa(1L);
    }
    @Test
    void testlistEnderecoFailure() {
        Mockito.when(enderecoRepository.queryEnderecosByIdPessoa(1L)).thenThrow(NullPointerException.class);

        assertThrows(NullPointerException.class, () -> enderecoRepository.queryEnderecosByIdPessoa(1L));

    }

    @Test
    void testdeleteEnderecoSuccess() {
        Mockito.doNothing().when(enderecoRepository).deleteById(1L);
        this.enderecoService.deleteEndereco(1L);

        Mockito.verify(this.enderecoRepository).deleteById(1L);
    }
    @Test
    void testdeleteEnderecoFailure() {
        assertThrows(Exception.class, () -> {
            Mockito.doThrow().when(enderecoRepository).deleteById(0L);
        });
    }
}