package testes;

import java.util.Scanner;

public class Exemplo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o primeiro número: ");
		float num1 =  scanner.nextFloat();
		
		System.out.println("Digite o segundo número: ");
		float num2 =  scanner.nextFloat();
		
		float soma = num1 + num2;
		
		System.out.println("Resultado da Soma: "+ soma);
		
		scanner.close(); //fecha o scanner no final para liberar os recursos...
		
	}

}
