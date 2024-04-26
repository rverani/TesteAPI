package br.com.testeapi.controller;

import br.com.testeapi.entity.Pessoa;
import br.com.testeapi.model.PessoaDTO;
import br.com.testeapi.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }
    @PostMapping
    List<Pessoa> create(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return pessoaService.creatPessoa(pessoaDTO);
    }
    @GetMapping
    List<Pessoa> listpessoa() {
        return pessoaService.listPessoa();
    }
    @DeleteMapping("{id}")
    List<Pessoa> delete(@PathVariable("id") Long id) {
        return pessoaService.deletePessoa(id);
    }
    @PutMapping
    List<Pessoa> update(@RequestBody @Valid Pessoa pessoa) {
        return pessoaService.updatePessoa(pessoa);
    }
}
