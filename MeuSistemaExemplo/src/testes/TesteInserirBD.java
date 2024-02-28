package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;

import auxiliar.FabricaDeConexoesBD;

public class TesteInserirBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Connection connection = new FabricaDeConexoesBD().obterConexao();
			
			String sql = "INSERT INTO aluno (nome, idade) VALUES (?,?)";
			//cada ? da query é um parâmetro, então esta query tem 2 parâmetros
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, "carlos"); //no parâmetro 1 da query entrará João
			preparedStatement.setInt(2, 58); //no parâmetro 2 da query entrará a idade 32
			
			//executa a query
			int saida = preparedStatement.executeUpdate();
			System.out.println("Dado inserido no banco");
			System.out.println("Retorno do SGBD: " + saida);
			
			//fecha a consulta SQL preparada e a conexão após a conclusão do processamento
			preparedStatement.close();
			connection.close();
			
		} catch (Exception e) {
			System.out.println("Erro: " + e);	
		}
	}
}
