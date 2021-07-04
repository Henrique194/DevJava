package main;

import java.util.function.BiConsumer;

public class Action implements BiConsumer<Integer, Cadastro>{
	
	public void accept(Integer i, Cadastro c) {
		System.out.println("Cliente " + i + ": " + c);
	}
}