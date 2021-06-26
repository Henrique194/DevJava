package pedido.auxiliar;

public abstract class Check {
	public static String checkCnpj(Long num) {
		//"33.041.260/0652-90", "636.169.915.112", "23.126.457"
		String string = num.toString();
		if(string.length() != 14) {
			throw new IllegalArgumentException("CNPJ DIGITADO INCORRETAMENTE!");
		}
		char[] character = string.toCharArray();
		//
		string = String.format("%c%c.%c%c%c.%c%c%c/%c%c%c%c-%c%c", character[0], character[1], character[2], character[3], character[4], character[5], character[6], character[7], character[8], character[9], character[10], character[11], character[12], character[13]);
		/*StringBuilder strbuilder = new StringBuilder();
		char[] symbols = {'.', '/', '-'};
		strbuilder = strbuilder.append(character);
		strbuilder = strbuilder.insert(2, symbols[0]);
		strbuilder = strbuilder.insert(4, symbols[0]);
		strbuilder = strbuilder.insert(4, symbols[0]);
		formattedstring.append(formattedstring);
		formattedstring.*/
		return string;
	}
	public static String checkIe(Long num) {
		String string = num.toString();
		if(string.length() != 12) {
			throw new IllegalArgumentException("IE DIGITADO INCORRETAMENTE!");
		}
		char[] character = string.toCharArray();
		string = String.format("%c%c%c.%c%c%c.%c%c%c.%c%c%c", character[0], character[1], character[2], character[3], character[4], character[5], character[6], character[7], character[8], character[9], character[10], character[11]);
		return string;
	}
	
	public static String checkIm(Integer num) {
		String string = num.toString();
		if(string.length() != 8) {
			throw new IllegalArgumentException("IM DIGITADO INCORRETAMENTE!");
		}
		char[] character = string.toCharArray();
		string = String.format("%c%c.%c%c%c.%c%c%c", character[0], character[1], character[2], character[3], character[4], character[5], character[6], character[7]);
		return string;
	}
}
