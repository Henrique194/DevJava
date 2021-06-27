package sistema;

public class Empresa extends Entidade{
	private String localizacao;
	private String bairro;
	private String cnpj;
	private String ie;
	private String im;
	
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
