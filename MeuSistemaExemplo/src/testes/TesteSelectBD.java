package testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import auxiliar.FabricaDeConexoesBD;

public class TesteSelectBD {
	
public static void main(String[] args) {
	
	try {
		Connection connection = new FabricaDeConexoesBD().obterConexao();
		
		
		Statement statement = connection.createStatement();
		ResultSet  resultSet = statement.executeQuery("SELECT id, nome, idade FROM aluno");
		
		while(resultSet.next()) {
			//pega o valor da tabela enquanto houver dados, trabalhando com cursor
			int id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			int idade = resultSet.getInt("idade");
			
			System.out.println("ID: " + id);
			System.out.println("NOME: " + nome);
			System.out.println("IDADE: " + idade);
			System.out.println("*******");
		}
		
		//fecha conexão com o SGBD e libera a memoria
			resultSet.close();
			statement.close();
			connection.close();		
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}