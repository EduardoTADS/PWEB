package testes;

import modelo.Livro;

public class Exemplo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Livro livro = new Livro(101, "Aprenda Java em 20 dias", 2016);
		Livro livro2 = new Livro(201, "Java para Web fácil", 2021);
		
		livro.ImprimeDados();
		livro2.ImprimeDados();
	}

}
