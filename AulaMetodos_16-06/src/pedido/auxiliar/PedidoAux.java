package pedido.auxiliar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PedidoAux implements Requestable, Registrable{
	private String id;
	private Calendar data = Calendar.getInstance();
	private Double valorTotal;
	private List<PedidoItem> itens = new ArrayList<>();
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id.toString();
	}
	
	public Double getValorTotal() {
		this.valorTotal = 0.0;
		for(PedidoItem i : this.itens) {
			this.valorTotal += i.getValor();
		}
		return this.valorTotal;
	}
	
	public void setData(Integer dia, Integer mes, Integer ano) {
		this.data = Registrable.setTime(dia, mes, ano);
	}
	
	public String getData() {
		String string = Registrable.getTime(this.data);
		if(string == "Data Do Pedido Não Cadastrada!") {
			return string;
		}
		else {
			string = String.format("Data Do Pedido: %s", string);
			return string;
		}
	}
	
	public void setPedidoItem(PedidoItem pedidoitem) {
		this.itens.add(pedidoitem);
	}
	
	public void printItens() {
		if(this.itens != null) {
			System.out.println("Itens Do Pedido:");
			for(PedidoItem item : this.itens) {
				if(item.getLivro() != null) {
					System.out.print("	" + item.getProduto().getTitulo() + " || Editora: " + item.getId() + " || Páginas: " + item.getLivro().getPaginas() + "|| Quantidade: " + item.getQuantidade() + " || Valor Unitário: R$ " + item.getProduto().getValorVenda() + " || SubTotal: R$ " + item.getValor() + "\n");
				}
				
				else if(item.getCd() != null) {
					System.out.print("	" + item.getProduto().getTitulo() + " || Artista: " + item.getId() + " || Faixas: " + item.getCd().getFaixas() + " || Quantidade: " + item.getQuantidade() + " || Valor Unitário: R$ " + item.getProduto().getValorVenda() + " || SubTotal: R$ " + item.getValor() + "\n");
				}
				
				else {
					System.out.print("	" + item.getProduto().getTitulo() + " || Quantidade: " + item.getQuantidade() + " || Valor Unitário: R$ " + item.getProduto().getValorVenda() + " || SubTotal: R$ " + item.getValor() + "\n");
				}
			}
		}
	}
	
}