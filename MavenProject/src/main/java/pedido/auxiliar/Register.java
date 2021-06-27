package pedido.auxiliar;

import sistema.Cadastro;
import sistema.Empresa;

public abstract class Register {	
	public static Cadastro cadastrarCliente(int id, String nome, String email, Long telefone) {
		Cadastro cadastro = new Cadastro();
		//Random random = new Random();
		//String id = String.format("%d%d%d%d.%d%d%d.%d%d%d%d", random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10));
		cadastro.setNome(nome);
		cadastro.setId(id);
		cadastro.setNumero(telefone);
		cadastro.setDescricao(email);
		return cadastro;
	}
	public static Empresa cadastrarEmpresa(String nome, String localizacao, String bairro, String rua, Long numero, Long cnpj, Long ie, Integer im) {
		//Instanciar sem construtor e com metodos private?
		Empresa empresa = new Empresa();
		String cnpjFormatado = Check.checkCnpj(cnpj);
		String ieFormatado = Check.checkIe(ie);
		String imFormatado = Check.checkIm(im);
		
		empresa.setNome(nome);
		empresa.setDescricao(rua);
		empresa.setNumero(numero);
		empresa.setLocalizacao(localizacao);
		empresa.setBairro(bairro);
		empresa.setCnpj(cnpjFormatado);
		empresa.setIe(ieFormatado);
		empresa.setIm(imFormatado);
				
		return empresa;
	}
}
