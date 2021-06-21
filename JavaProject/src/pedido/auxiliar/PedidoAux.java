package pedido.auxiliar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import pedido.Printable;

public class PedidoAux{
	private String id;
	private Calendar data = Calendar.getInstance();
	private Double valorTotal;
	private List<PedidoItem> itens = new ArrayList<>();
	private boolean timeChecker = false;
	
	public void setData(Integer dia, Integer mes, Integer ano) {
		Format.setTime(this.data, dia, mes, ano);
	}
	
	
	public void setData(Integer dia, Integer mes, Integer ano, Integer hora, Integer minuto, Integer segundo) {
		this.timeChecker = true;
		Format.setTime(this.data, dia, mes, ano, hora, minuto, segundo);
	}
	
	
	public String getData() {
		if(this.timeChecker == true) {
			return Format.getTime(this.data);
		}
		else {
			String[] array = Format.getTime(this.data).split(" ");
			String string = String.format("%s %s HORÁRIO NÃO REGISTRADO", array[0], array[1]);
			return string;
		}
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getId() {
		return this.id.toString();
	}
	
	
	public void setPedidoItem(PedidoItem pedidoitem) {
		this.itens.add(pedidoitem);
	}
	
	
	public void printItens() {
		if(this.itens != null) {
			System.out.println("Itens Do Pedido:");
			Printable.printPedidoItem(this.itens);
			System.out.println(Printable.lineMaker());
		}
	}
	
	
	public Double getValorTotal() {
		this.valorTotal = 0.0;
		for(PedidoItem i : this.itens) {
			this.valorTotal += i.getValor();
		}
		return this.valorTotal;
	}
	
}