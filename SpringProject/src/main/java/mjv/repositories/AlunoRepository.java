package mjv.repositories;

import org.springframework.data.repository.CrudRepository;
import java.lang.RuntimeException;
import mjv.entity.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Integer>{
}
