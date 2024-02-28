package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import auxiliar.FabricaDeConexoesBD;
import modelo.Disciplina;

public class DisciplinaDAO {
	
	// a conexão com o banco de dados
	private Connection connection;
	
	public DisciplinaDAO() {
		this.connection = new FabricaDeConexoesBD().obterConexao();
		}
	
	public void adiciona(Disciplina Disciplina) {

		String sql = "INSERT INTO Disciplina (nome, cargaHr, ativa) VALUES (?,?,?)";
		
		try {
			// objeto PreparedStatement para inserção com parâmetros
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores dos parâmetros
			stmt.setString(1, Disciplina.getNome());
			stmt.setInt(2, Disciplina.getCargaHr());
			stmt.setBoolean(3, Disciplina.isAtiva());
		
			// executa a query
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}	
	
	public Disciplina consultarPorID(int idDisciplinaBuscado) {
		try {
			String sql = "SELECT id, nome, cargaHr, ativa FROM Disciplina WHERE id = ?";
		
			// objeto PreparedStatement para consulta com parâmetros
			PreparedStatement prepStmt = connection.prepareStatement(sql);
		
			// seta o valor do parâmetro com o valor recebido do método			
			prepStmt.setInt(1, idDisciplinaBuscado);
		
			// executa a query
			ResultSet resultSet = prepStmt.executeQuery();
			Disciplina DisciplinaBD = new Disciplina();
			
			while (resultSet.next()) {
				//pega o valor de cada coluna da linha corrente do cursor
				int idBD = resultSet.getInt("id");
				String nomeBD = resultSet.getString("nome");
				int cargaHrBD = resultSet.getInt("cargaHr");
				boolean ativaBD = resultSet.getBoolean("ativa");
	
				DisciplinaBD.setId(idBD);	
				DisciplinaBD.setNome(nomeBD);
				DisciplinaBD.setCargaHr(cargaHrBD);
				DisciplinaBD.setAtiva(ativaBD);
				
			}
			prepStmt.close();
			resultSet.close();
			return DisciplinaBD;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		
		}
	}
	public void excluir(Disciplina umDisciplina) {
		String sql = "DELETE FROM Disciplina WHERE id = ?";
		int idDisciplina = umDisciplina.getId();
       
        try {
        	// objeto PreparedStatement para consulta com parâmetros
    		PreparedStatement stmt = connection.prepareStatement(sql);
    	
            stmt.setInt(1, idDisciplina);
            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public List<Disciplina> listar(){
		try {
			String sql = "SELECT id, nome, cargaHr, ativa FROM Disciplina";
			PreparedStatement prepStmt = connection.prepareStatement(sql);
			ResultSet resultSet = prepStmt.executeQuery();	
			
			List<Disciplina> listaDisciplina = new ArrayList<Disciplina>();
			
			while(resultSet.next()) {
				Disciplina DisciplinaBD = new Disciplina();
				
				int idBD = resultSet.getInt("id");
				String nomeBD = resultSet.getString("nome");
				int cargaHrBD = resultSet.getInt("cargaHr");
				boolean ativaBD = resultSet.getBoolean("ativa");
				
				DisciplinaBD.setId(idBD);
				DisciplinaBD.setNome(nomeBD);
				DisciplinaBD.setCargaHr(cargaHrBD);
				DisciplinaBD.setAtiva(ativaBD);
				
				listaDisciplina.add(DisciplinaBD);
			}
			prepStmt.close();
			resultSet.close();
			return listaDisciplina;
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}