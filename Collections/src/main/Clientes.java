package main;

import java.util.TreeMap;

public class Clientes {
	public static TreeMap<Integer, Cadastro> cadastrar(Cadastro[] clientes){
		TreeMap<Integer, Cadastro> mapa = new TreeMap<Integer, Cadastro>();
		int id = 1;
		for(Cadastro cliente : clientes) {
			mapa.put(id, cliente);
			id++;
		}
		return mapa;
	}
	
	public static TreeMap<Integer, Cadastro> cadastrarPorQuantidade(Cadastro[] clientes){
		TreeMap<Cadastro, Integer> mapaFormatado = new TreeMap<Cadastro, Integer>(new QuantidadeComparator());
		for(Cadastro cliente : clientes) {
			mapaFormatado.put(cliente, cliente.getQuantidade());
		}
		int id = 1;
		TreeMap<Integer, Cadastro> mapa = new TreeMap<Integer, Cadastro>();
		for(Cadastro cliente : mapaFormatado.keySet()) {
			mapa.put(id, cliente);
			id++;
		}
		return mapa;
	}
}