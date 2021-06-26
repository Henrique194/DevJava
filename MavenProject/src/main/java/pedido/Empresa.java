package pedido;

import sistema.Cadastro;

public class Empresa {
	private Cadastro cadastro;
	private String localizacao;
	private String bairro;
	private String cnpj;
	private String ie;
	private String im;
	
	public Cadastro getCadastro() {
		return cadastro;
	}


	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}


	public String getLocalizacao() {
		return localizacao;
	}


	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getIe() {
		return ie;
	}


	public void setIe(String ie) {
		this.ie = ie;
	}


	public String getIm() {
		return im;
	}


	public void setIm(String im) {
		this.im = im;
	}	
}
