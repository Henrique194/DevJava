package pedido.auxiliar;

import java.util.Calendar;

public abstract class FormatTime {
	public static Calendar setTime(Calendar data, Integer dia, Integer mes, Integer ano) {
		data.set(ano, mes-1, dia);
		return data;
	}
	public static Calendar setTime(Calendar data, Integer dia, Integer mes, Integer ano, Integer hora, Integer minuto, Integer segundo) {
		data.set(ano, mes-1, dia);
		data.set(Calendar.HOUR_OF_DAY, hora);
		data.set(Calendar.MINUTE, minuto);
		data.set(Calendar.SECOND, segundo);
		return data;
	}
	public static String getTime(Calendar data) {
		String[] array = data.getTime().toString().split(" ");
		String string = null;
		array[0] = compareWeekDay(array[0]);
		array[1] = compareMonth(array[1]);
		string = String.format("%s %s/%s/%s %s %s", array[0], array[2], array[1], array[5], array[3], array[4]);
		return string;
	}
	
	private static String compareWeekDay(String string) {
		switch(string) {
			case "Sun":
				string = string.replaceAll("Sun", "Domingo");
				break;
			case "Mon":
				string = string.replaceAll("Mon", "Segunda");
				break;
			case "Tue":
				string = string.replaceAll("Tue", "Terça");
				break;
			case "Wed":
				string = string.replaceAll("Wed", "Quarta");
				break;
			case "Thu":
				string = string.replaceAll("Thu", "Quinta");
				break;
			case "Fri":
				string = string.replaceAll("Fri", "Sexta");
				break;
			case "Sat":
				string = string.replaceAll("Sat", "Sábado");
				break;
			default:
				System.out.println("ERRO: NÃO DEVERIA CHEGAR AQUI!");
				break;
		}
		return string;
	}
	
	private static String compareMonth(String string) {
		switch(string) {
			case "Jan":
				string = string.replaceAll("Jan", "01");
				break;
			case "Feb":
				string = string.replaceAll("Feb", "02");
				break;
			case "Mar":
				string = string.replaceAll("Mar", "03");
				break;
			case "Apr":
				string = string.replaceAll("Apr", "04");
				break;
			case "May":
				string = string.replaceAll("May", "05");
				break;
			case "Jun":
				string = string.replaceAll("Jun", "06");
				break;
			case "Jul":
				string = string.replaceAll("Jul", "07");
				break;
			case "Aug":
				string = string.replaceAll("Aug", "08");
				break;
			case "Sep":
				string = string.replaceAll("Sep", "09");
				break;
			case "Oct":
				string = string.replaceAll("Oct", "10");
				break;
			case "Nov":
				string = string.replaceAll("Nov", "11");
				break;
			case "Dec":
				string = string.replaceAll("Dec", "12");
				break;
			default:
				System.out.println("ERRO: NÃO DEVERIA CHEGAR AQUI!");
				break;
		}
		return string;
	}
}
