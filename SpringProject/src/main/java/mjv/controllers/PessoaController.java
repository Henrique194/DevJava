package mjv.controllers;

import mjv.entity.Pessoa;
import mjv.exceptions.NotFoundException;
import mjv.exceptions.PostException;
import java.util.List;
import mjv.repositories.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController // @Controller + @RespondeBody
@RequestMapping("/mjv/pessoa")
public class PessoaController {
	@Autowired
	PessoaRepository repo;
	
	@PostMapping("/post")
	public void create(@RequestBody Pessoa pessoa) {
		postChecker(pessoa.getId());
		repo.save(pessoa);
	}
	
	@PutMapping("/put")
	public void update(@RequestBody Pessoa pessoa) {
		foundChecker(pessoa.getId(), "PUT");
		repo.save(pessoa);
	}
	
	@PatchMapping("/patch")
	public void patch(@RequestBody Pessoa pessoa) {
		foundChecker(pessoa.getId(), "PATCH");
		repo.save(pessoa);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam("id") Integer id) {
		foundChecker(id, "DELETE");
		repo.deleteById(id);
	}
	
	@GetMapping("/getById")
	public Pessoa findById(@RequestParam("id") Integer id){
		return repo.findById(id).orElse(null);
	}
	
	@GetMapping("/getByNome")
	public Pessoa findByNome(@RequestParam("nome") String nome){
		return repo.findByNome(nome);
	}
	
	@GetMapping("/getByNomeContaining")
	public List<Pessoa> findByNomeContaining(@RequestParam("nome") String nome){
		return repo.findByNomeContaining(nome);
	}
	
	@GetMapping("/getAll")
	public Iterable<Pessoa> findAll(){
		return repo.findAll();
	}
	
	private void postChecker(Integer id) {
		Pessoa pessoaDb = findById(id);
		if(pessoaDb != null) {
			throw new PostException(id);
		}
	}
	
	private void foundChecker(Integer id, String type) {
		Pessoa pessoaDb = findById(id);
		if(pessoaDb == null) {
			throw new NotFoundException(id, type);
		}
	}
}
