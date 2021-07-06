package mjv.exceptions;

public class DeleteException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public DeleteException(Integer id) {
		super(String.format("Cadastro com id=%s não foi encontrado!", id));
	}
}
