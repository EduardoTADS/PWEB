package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;

import auxiliar.FabricaDeConexoesBD;

public class TesteAlterarBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Connection connection = new FabricaDeConexoesBD().obterConexao();
			
			
			String sql = "UPDATE aluno SET nome= 'Leticia' WHERE id = 5";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			//executa a query
			int saida = preparedStatement.executeUpdate();
			System.out.println("Dado alterado no banco");
			System.out.println("Retorno do SGBD: " + saida);
			
			//fecha a consulta SQL preparada e a conexão após a conclusão do processamento
			preparedStatement.close();
			connection.close();
			
		} catch (Exception e) {
			System.out.println("Erro: " + e);	
		}
	}
}

