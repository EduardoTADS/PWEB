package testes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import auxiliar.FabricaDeConexoesBD;

public class TesteSelectBD_PorFaixaDeIdade {
	
public static void main(String[] args) {
	
	try {
		Connection connection = new FabricaDeConexoesBD().obterConexao();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite a idade mínima: ");
		int idadeMinima = scanner.nextInt();
		
		System.out.print("Digite a idade máxima: ");
		int idadeMaxima = scanner.nextInt();
		scanner.close();
		
		String query = "SELECT * FROM aluno WHERE idade BETWEEN " + idadeMinima + " AND " + idadeMaxima + "ORDER BY idade";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet  resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			//pega o valor da tabela enquanto houver dados, trabalhando com cursor

			String nome = resultSet.getString("nome");
			int idade = resultSet.getInt("idade");
			
			System.out.println("\nNOME: " + nome);
			System.out.println("IDADE: " + idade);
			System.out.println("*******");
		}
		
		//fecha conexão com o SGBD e libera a memoria
			resultSet.close();
			preparedStatement.close();
			connection.close();		
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}