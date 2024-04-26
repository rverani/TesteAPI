package br.com.testeapi.service;

import br.com.testeapi.entity.Pessoa;
import br.com.testeapi.model.PessoaDTO;
import br.com.testeapi.repository.PessoaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }
    public List<Pessoa> creatPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa(pessoaDTO.getNome(), pessoaDTO.getNascimento());
        pessoaRepository.save(pessoa);
        return listPessoa();
    }

    public List<Pessoa> deletePessoa(Long id) {
        pessoaRepository.deleteById(id);
        return listPessoa();
    }
    public List<Pessoa> updatePessoa(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
        return listPessoa();
    }
    public List<Pessoa> listPessoa() {
        return pessoaRepository.findAll();
    }

}
