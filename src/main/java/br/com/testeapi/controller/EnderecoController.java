package br.com.testeapi.controller;

import br.com.testeapi.entity.Endereco;
import br.com.testeapi.model.EnderecoDTO;
import br.com.testeapi.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    private EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }
    @PostMapping
    List<Endereco> create(@RequestBody EnderecoDTO enderecoDTO) {
        return enderecoService.createEndereco(enderecoDTO);
    }
    @GetMapping("{id}")
    List<Endereco> list(@PathVariable("id") Long id) {
        return enderecoService.listEndereco(id);
    }
    @DeleteMapping("{id}")
    List<Endereco> delete(@PathVariable("id") Long id) {
        return enderecoService.deleteEndereco(id);
    }
    @PutMapping
    List<Endereco> update(@RequestBody Endereco endereco) {
        return enderecoService.updateEndereco(endereco);
    }


}
