package transmissao;

import java.util.Date;
import sistema.Cadastro;

public abstract class TransmissorMensagem{
	private Date data;
	private Cadastro destinatario;
	
	public abstract void enviar(String mensagem);
}
