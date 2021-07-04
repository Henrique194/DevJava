package main;

import java.util.TreeMap;

public class Main {
	//Exemplo De Aplicação De Um Cadastro Simples
	public static void main(String[] args) {
		
		Cadastro[] clientes = new Cadastro[3];
		clientes[0] = new Cadastro();
		clientes[1] = new Cadastro();
		clientes[2] = new Cadastro();
		//Cadastrando Clientes
		clientes[0].setCliente("Luciene Jorge", "luciene@mail.com", 11202392365l);
		clientes[1].setCliente("Henrique Jorge", "henrique@mail.com", 11839503346l);
		clientes[2].setCliente("Pedro Santos", "pedro@mail.com", 11400485745l);
		
		//Inserindo Quantidade De Itens Por Cliente
		clientes[0].setQuantidade(30);
		clientes[1].setQuantidade(20);
	    clientes[2].setQuantidade(10);
		
		//Inserindo Clientes
	    TreeMap<Integer, Cadastro> mapa = Clientes.cadastrar(clientes);
	    TreeMap<Integer, Cadastro> mapaPorQuantidade = Clientes.cadastrarPorQuantidade(clientes);
		
		
		//Printando Clientes
	   System.out.println("MAPA COM ORDEM NATURAL!");
		printClientes(mapa);
		System.out.println("MAPA COM ORDEM POR QUANTIDADE!");
		printClientes(mapaPorQuantidade);
		
	}
	
	public static void printClientes(TreeMap<Integer, Cadastro> mapa) {
		if(mapa.isEmpty()) {
			System.out.println("NENHUM CLIENTE CADASTRADO!");
		} else {
			Action action = new Action();
			mapa.forEach(action);
			System.out.print("\n");
		}
	}
}