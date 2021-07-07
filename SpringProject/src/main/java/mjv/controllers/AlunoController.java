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

import mjv.entity.Aluno;
import mjv.entity.enums.NivelAluno;
import mjv.exceptions.NotFoundException;
import mjv.exceptions.PostException;
import mjv.repositories.AlunoRepository;

@RestController // @Controller + @RespondeBody
@RequestMapping("/mjv/aluno")
public class AlunoController {
	@Autowired
	AlunoRepository repo;
	
	@PostMapping("/post")
	public void create(@RequestParam("id") Integer id, @RequestParam("nivel") NivelAluno nivel, @RequestBody Aluno aluno) {
		Aluno alunoDb = findById(id);
		if(alunoDb != null) {
			throw new PostException(id);
		}
		aluno.setId(id);
		aluno.setNivel(nivel);
		aluno.getPessoa().setId(id);
		repo.save(aluno);
	}
	
	@PutMapping("/put")
	public void update(@RequestParam("id") Integer id, @RequestParam("nivel") NivelAluno nivel, @RequestBody Aluno aluno) {
		Aluno alunoDb = findById(id);
		if(alunoDb == null) {
			throw new NotFoundException(id, "PUT");
		}
		aluno.setId(id);
		aluno.setNivel(nivel);
		aluno.getPessoa().setId(id);
		repo.save(aluno);
	}
	
	@PatchMapping("/patch")
	public void patch(@RequestParam("id") Integer id, @RequestBody Aluno aluno) {
		Aluno alunoDb = findById(id);
		if(alunoDb == null) {
			throw new NotFoundException(id, "PATCH");
		}
		aluno.setId(id);
		aluno.getPessoa().setId(id);
		Aluno alunoVelho = findById(id);
		Aluno alunoUpdate = updater(aluno, alunoVelho);
		repo.save(alunoUpdate);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam("id") Integer id) {
		Aluno aluno = findById(id);
		if(aluno == null) {
			throw new NotFoundException(id, "DELETE");
		}
		repo.deleteById(id);
	}
	
	@GetMapping("/getById")
	public Aluno findById(@RequestParam("id") Integer id){
		return repo.findById(id).orElse(null);
	}
	
	@GetMapping("/getAll")
	public Iterable<Aluno> findAll(){
		return repo.findAll();
	}
	
	private Aluno updater(Aluno aluno, Aluno alunoVelho) {
		if(aluno.getPessoa().getBairro() 		 != null) alunoVelho.getPessoa().setBairro(aluno.getPessoa().getBairro());
		if(aluno.getPessoa().getCep() 			 != null) alunoVelho.getPessoa().setCep(aluno.getPessoa().getCep());
		if(aluno.getPessoa().getCidade() 		 != null) alunoVelho.getPessoa().setCidade(aluno.getPessoa().getCidade());
		if(aluno.getPessoa().getCpf() 			 != null) alunoVelho.getPessoa().setCpf(aluno.getPessoa().getCpf());
		if(aluno.getPessoa().getEstado() 		 != null) alunoVelho.getPessoa().setEstado(aluno.getPessoa().getEstado());
		if(aluno.getPessoa().getNacionalidade()  != null) alunoVelho.getPessoa().setNacionalidade(aluno.getPessoa().getNacionalidade());
		if(aluno.getPessoa().getNascimento() 	 != null) alunoVelho.getPessoa().setNascimento(aluno.getPessoa().getNascimento());
		if(aluno.getPessoa().getNome() 		 	 != null) alunoVelho.getPessoa().setNome(aluno.getPessoa().getNome());
		if(aluno.getPessoa().getNumeroRua() 	 != null) alunoVelho.getPessoa().setNumeroRua(aluno.getPessoa().getNumeroRua());
		if(aluno.getPessoa().getRg() 			 != null) alunoVelho.getPessoa().setCpf(aluno.getPessoa().getCpf());
		if(aluno.getPessoa().getRua() 			 != null) alunoVelho.getPessoa().setRua(aluno.getPessoa().getRua());
		if(aluno.getContato1().getNome()	 	 != null) alunoVelho.getContato1().setNome(aluno.getContato1().getNome());
		if(aluno.getContato1().getParentesco()	 != null) alunoVelho.getContato1().setParentesco(aluno.getContato1().getParentesco());
		if(aluno.getContato1().getTelefone()	 != null) alunoVelho.getContato1().setTelefone(aluno.getContato1().getTelefone());
		if(aluno.getContato1().getEmail() 	 	 != null) alunoVelho.getContato1().setEmail(aluno.getContato1().getEmail());
		alunoVelho = updaterContato2(aluno, alunoVelho);
		return alunoVelho;
	}
	
	private Aluno updaterContato2(Aluno aluno, Aluno alunoVelho) {
		if(aluno.getContato2() != null && alunoVelho.getContato2() == null) {
			alunoVelho.setContato2(aluno.getContato2());
			return alunoVelho;
		} else {
			if(aluno.getContato2().getNome()	 	 != null) alunoVelho.getContato2().setNome(aluno.getContato2().getNome());
			if(aluno.getContato2().getParentesco()	 != null) alunoVelho.getContato2().setParentesco(aluno.getContato2().getParentesco());
			if(aluno.getContato2().getTelefone()	 != null) alunoVelho.getContato2().setTelefone(aluno.getContato2().getTelefone());
			if(aluno.getContato2().getEmail() 	 	 != null) alunoVelho.getContato2().setEmail(aluno.getContato2().getEmail());
			return alunoVelho;
		}
	}
}
