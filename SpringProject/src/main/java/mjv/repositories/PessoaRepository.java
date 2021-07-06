package mjv.repositories;

import org.springframework.data.repository.CrudRepository;

import mjv.entity.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Integer>{

}
