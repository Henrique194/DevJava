package main;

import java.util.Comparator;

public class QuantidadeComparator implements Comparator<Cadastro>{
	@Override
	public int compare(Cadastro c1, Cadastro c2) {
		return c1.getQuantidade().compareTo(c2.getQuantidade());
	}
}
