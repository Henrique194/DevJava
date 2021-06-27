package pedido.auxiliar;

public abstract class Check {
	private static final int TAMANHOCNPJ = 14;
	private static final int TAMANHOIE = 12;
	private static final int TAMANHOIM = 8;
	
	public static String checkCnpj(Long num) {
		//"33.041.260/0652-90" !!!FAZER COM STRINGBUILDER!!!
		String string = num.toString();
		if(string.length() != TAMANHOCNPJ) {
			throw new IllegalArgumentException("CNPJ DIGITADO INCORRETAMENTE!");
		}
		string = string.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
		return string;
	}
	public static String checkIe(Long num) {
		//"636.169.915.112"
		String string = num.toString();
		if(string.length() != TAMANHOIE) {
			throw new IllegalArgumentException("IE DIGITADO INCORRETAMENTE!");
		}
		string = string.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{3})", "$1.$2.$3.$4");
		return string;
	}
	
	public static String checkIm(Integer num) {
		//"23.126.457"
		String string = num.toString();
		if(string.length() != TAMANHOIM) {
			throw new IllegalArgumentException("IM DIGITADO INCORRETAMENTE!");
		}
		string = string.replaceAll("(\\d{2})(\\d{3})(\\d{3})", "$1.$2.$3");
		return string;
	}
	
	public static int checkColunas(String string) {
		switch(string) {
			case "id":
				return 4;
			case "telefone":
				return 2;
			default:
				return 0;
		}
	}
}
