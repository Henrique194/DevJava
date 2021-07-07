package mjv.exceptions;

public class NotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private final String TYPE;
	
	public NotFoundException(Integer id, String type) {
		super(String.format("Cadastro com id=%d não foi encontrado!", id));
		this.TYPE = type;
	}
	
	public String getType() {
		return this.TYPE;
	}
}
