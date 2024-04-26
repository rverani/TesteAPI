package br.com.testeapi.service;

import br.com.testeapi.entity.Endereco;
import br.com.testeapi.entity.Pessoa;
import br.com.testeapi.model.EnderecoDTO;
import br.com.testeapi.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }
    public List<Endereco> createEndereco(EnderecoDTO enderecoDTO) {
       Pessoa pessoa = new Pessoa();
       pessoa.setId(enderecoDTO.getIdPessoa());
        Endereco endereco = new Endereco();
        endereco.setPrincipal(enderecoDTO.getPrincipal());
        endereco.setCep(enderecoDTO.getCep());
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setIdPessoa(enderecoDTO.getIdPessoa());
        endereco.setEstado(enderecoDTO.getEstado());
        endereco.setCidade(enderecoDTO.getCidade());
        enderecoRepository.save(endereco);
        return listEndereco(enderecoDTO.getIdPessoa());
    }

    public List<Endereco> listEndereco(Long id) {
        return enderecoRepository.queryEnderecosByIdPessoa(id);
    }
    public List<Endereco> deleteEndereco(Long id) {
        enderecoRepository.deleteById(id);
        return listEndereco(id);
    }
    public List<Endereco> updateEndereco(Endereco endereco) {
        enderecoRepository.save(endereco);
        return listEndereco(endereco.getId());
    }
}
