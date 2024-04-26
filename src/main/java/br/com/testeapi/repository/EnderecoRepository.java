package br.com.testeapi.repository;

import br.com.testeapi.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Optional<Endereco> findAllById(Long idPessoa);
    List<Endereco> queryEnderecosByIdPessoa(Long idPessoa);
}
