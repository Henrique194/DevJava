package mjv.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mjv.entity.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Integer>{
	Pessoa findByNome(String nome);
	List<Pessoa> findByNomeContaining(String nome);
}
