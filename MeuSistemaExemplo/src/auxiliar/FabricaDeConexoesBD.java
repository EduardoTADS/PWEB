package auxiliar;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoesBD {

	public Connection obterConexao() {
		try {
			String jdbcUrl = "jdbc:postgresql://localhost:5432/Eduardo";
			String usuario = "postgres";
			String senha = "postgres";

			Connection connection = DriverManager.getConnection(jdbcUrl, usuario, senha);
			System.out.println("Conexão realizada com sucesso \n");
			return connection;
			
		} catch (SQLException e) {
			System.out.println("Falha na Conexão erro abaixo:::\n");
			
			throw new RuntimeException(e);
		}
	}
}