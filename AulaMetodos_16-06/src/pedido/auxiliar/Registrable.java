package pedido.auxiliar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import sistema.Cadastro;

public interface Registrable {
	public static Cadastro cadastrar(Cadastro cliente, String nome, Integer telefone, String email) {
		Cadastro cadastro = new Cadastro();
		Random random = new Random();
		String id = String.format("%d%d%d%d.%d%d%d.%d%d%d%d", random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10));
		cadastro.setNome(nome);
		cadastro.setId(id);
		cadastro.setTelefone(telefone);
		cadastro.setEmail(email);
		return cadastro;
	}
	
	public static String getCliente(Cadastro cliente) {
		String client = String.format("Cliente: %s || ID: %s || Telefone: %s  || Email: %s", cliente.getNome(), cliente.getId().toString(), cliente.getTelefone(), cliente.getEmail());
		return client;
	}
	
	public static Calendar setTime(Integer dia, Integer mes, Integer ano) {
		Calendar data = Calendar.getInstance();
		data.set(ano, mes-1, dia);
		return data;
	}
	
	public static String getTime(Calendar data) {
		String string = null;
		if(data.get(Calendar.YEAR) == 1) {
			string = "Data Do Pedido Não Cadastrada!";
			return string;
		}
		else {
			List<Integer> list = new ArrayList<>();
			list.add(data.get(Calendar.DATE));
			list.add(data.get(Calendar.MONTH)+1);
			list.add(data.get(Calendar.YEAR));
			string = list.toString().substring(1, list.toString().length()-1).replaceAll(", ", "/");
			return string;
		}
	}
	
}
