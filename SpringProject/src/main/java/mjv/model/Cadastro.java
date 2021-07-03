package mjv.model;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import mjv.model.enums.Sexo;

@Entity
@Table(name = "tab_cadastro", schema = "spring")
public class Cadastro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50, nullable = false)
	private String nome;
	@Column(length = 70)
	private String email;
	@Column(length = 12, nullable = false)
	private String rg;
	@Column(length = 11, nullable = false)
	private String cpf;
	@Column(length = 11, nullable = false)
	private String telefone;
	
	private LocalDate nascimento;
	
	
	@Embedded
	private Endereco endereco;
	
	private String nacionalidade;
	private LocalDate dataNascimento;
	
	@Embedded
	private ContatoEmergencia contato;
	
	@Embedded
	@AttributeOverrides( {
        @AttributeOverride(name="nome", column = @Column(name="ce2_nome") ),
        @AttributeOverride(name="email", column = @Column(name="ce2_email") ),
        @AttributeOverride(name="parentesco", column = @Column(name="ce2_parentesco") ),
        @AttributeOverride(name="telefone", column = @Column(name="ce2_telefone") )
	} )
	private ContatoEmergencia contato2;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
}