package mjv.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import mjv.entity.enums.Sexo;

@Entity
@Table(name = "tab_pessoa", schema = "escola")
public class Pessoa {
	@Id
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(length = 9,nullable = false)
	private String rg;
	
	@Column(length = 12, nullable = false)
	private String cpf;
	
	@Column(length = 11, nullable = false)
	private Long telefone;
	
	@Column(length = 8)
	private Long cep;
	
	@Column(length = 80)
	private String rua;
	
	@Column(length = 5)
	private String numeroRua;
	
	@Column(length = 30)
	private String bairro;
	
	@Column(length = 50)
	private String cidade;
	
	@Column(length = 2)
	private String estado;
	
	@Column(length = 20)
	private String nacionalidade;
	
	@Column(length = 8)
	private LocalDate nascimento;
	
	@Column(length = 9)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy = "pessoa")
	Aluno aluno;
	//Abaixo Se Encontra getters e setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumeroRua() {
		return numeroRua;
	}

	public void setNumeroRua(String numeroRua) {
		this.numeroRua = numeroRua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	
}
