package mjv.exceptions;

public class PostException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PostException(Integer id) {
		super(String.format("Cadastro com id=%d já existe!", id));
	}
}
