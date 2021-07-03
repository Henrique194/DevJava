package main;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	//Exemplo De Aplicação De Um Cadastro Simples
	public static void main(String[] args) {
		HashMap<Integer, Cadastro> mapa = new HashMap<Integer, Cadastro>();
		Cadastro henrique = new Cadastro();
		Cadastro joao = new Cadastro();
		Cadastro andre = new Cadastro();
		Cadastro pedro = new Cadastro();
		Cadastro luciene = new Cadastro();
		
		//Cadastrando Clientes
		henrique.setCliente("Henrique Jorge", "henrique@mail.com", 11839503346l);
		joao.setCliente("Joao Silva", "joao@mail.com", 11385044905l);
		andre.setCliente("Andre Matos", "andre@mail.com", 11486036830l);
		pedro.setCliente("Pedro Santos", "pedro@mail.com", 11400485745l);
		luciene.setCliente("Luciene Jorge", "luciene@mail.com", 11202392365l);
		
		//Inserindo Clientes
		mapa.put(1, luciene);
		mapa.put(2, joao);
		mapa.put(3, andre);
		mapa.put(4, pedro);
		mapa.put(5, henrique);
		
		//Printando Clientes
		if(mapa.isEmpty()) {
			System.out.println("NENHUM CLIENTE CADASTRADO!");
		} else {
			Action action = new Action();
			mapa.forEach(action);
		}
	}
}