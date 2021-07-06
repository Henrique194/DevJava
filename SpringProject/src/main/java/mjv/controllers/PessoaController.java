package mjv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mjv.entity.Pessoa;
import mjv.repositories.PessoaRepository;


@RestController // @Controller + @RespondeBody
@RequestMapping("/mjv/pessoa")
public class PessoaController {
	@Autowired
	PessoaRepository repo;
	
	@PostMapping("/post")
	public void create(@RequestBody Pessoa pessoa) {
		repo.save(pessoa);
	}
	
	@PutMapping("/put")
	public void update(@RequestBody Pessoa pessoa) {
		repo.save(pessoa);
	}
	
	@PatchMapping("/patch")
	public void patch(@RequestBody Pessoa pessoa) {
		repo.save(pessoa);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam("id") Integer id) {
		repo.deleteById(id);
	}
	
	@GetMapping("/getById")
	public Pessoa findById(@RequestParam("id") Integer id){
		return repo.findById(id).orElse(null);
	}
	
	@GetMapping("/getAll")
	public Iterable<Pessoa> findAll(){
		return repo.findAll();
	}
}
