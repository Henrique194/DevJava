package pedido.auxiliar;

import java.util.Random;

import pedido.Empresa;
import sistema.Cadastro;

public abstract class Register {	
	public static Cadastro cadastrarCliente(String nome, String email, Integer telefone) {
		Cadastro cadastro = new Cadastro();
		Random random = new Random();
		String id = String.format("%d%d%d%d.%d%d%d.%d%d%d%d", random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10));
		cadastro.setNome(nome);
		cadastro.setId(id);
		cadastro.setTelefone(telefone);
		cadastro.setEmail(email);
		return cadastro;
	}
	public static Empresa cadastrarEmpresa(String nome, String localizacao, String bairro, String rua, Integer numero, Long cnpj, Long ie, Integer im) {
		//Instanciar sem construtor e com metodos private?
		Empresa empresa = new Empresa();
		Cadastro cadastro = Register.cadastrarCliente(nome, rua, numero);
		String cnpjFormatado = Check.checkCnpj(cnpj);
		String ieFormatado = Check.checkIe(ie);
		String imFormatado = Check.checkIm(im);
				
				
		empresa.setCadastro(cadastro);
		empresa.setLocalizacao(localizacao);
		empresa.setBairro(bairro);
		empresa.setCnpj(cnpjFormatado);
		empresa.setIe(ieFormatado);
		empresa.setIm(imFormatado);
				
		return empresa;
	}
}
