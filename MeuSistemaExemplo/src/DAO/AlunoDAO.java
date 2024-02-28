package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import auxiliar.FabricaDeConexoesBD;
import modelo.Aluno;

public class AlunoDAO {

	// a conexão com o banco de dados
	private Connection connection;

	public AlunoDAO() {
		this.connection = new FabricaDeConexoesBD().obterConexao();
	}

	public void adiciona(Aluno aluno) {

		String sql = "INSERT INTO aluno (nome, idade) VALUES (?,?)";

		try {
			// objeto PreparedStatement para inserção com parâmetros
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores dos parâmetros
			stmt.setString(1, aluno.getNome());
			stmt.setInt(2, aluno.getIdade());

			// executa a query
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Aluno consultarPorID(int idAlunoBuscado) {
		try {
			String sql = "SELECT id, nome, idade FROM aluno WHERE id = ?";

			// objeto PreparedStatement para consulta com parâmetros
			PreparedStatement prepStmt = connection.prepareStatement(sql);

			// seta o valor do parâmetro com o valor recebido do método
			prepStmt.setInt(1, idAlunoBuscado);

			// executa a query
			ResultSet resultSet = prepStmt.executeQuery();
			Aluno alunoBD = new Aluno();

			while (resultSet.next()) {
				// pega o valor de cada coluna da linha corrente do cursor
				int idBD = resultSet.getInt("id");
				String nomeBD = resultSet.getString("nome");
				int idadeBD = resultSet.getInt("idade");

				alunoBD.setId(idBD);
				alunoBD.setNome(nomeBD);
				alunoBD.setIdade(idadeBD);

			}
			prepStmt.close();
			resultSet.close();
			return alunoBD;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

	public void excluir(Aluno umAluno) {
		String sql = "DELETE FROM Aluno WHERE id = ?";
		int idAluno = umAluno.getId();

		try {
			// objeto PreparedStatement para consulta com parâmetros
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, idAluno);
			stmt.executeUpdate();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Aluno> listar() {
		try {
			String sql = "SELECT id, nome, idade FROM aluno";
			PreparedStatement prepStmt = connection.prepareStatement(sql);
			ResultSet resultSet = prepStmt.executeQuery();

			List<Aluno> listaAluno = new ArrayList<Aluno>();

			while (resultSet.next()) {
				Aluno alunoBD = new Aluno();

				int idBD = resultSet.getInt("id");
				String nomeBD = resultSet.getString("nome");
				int idadeBD = resultSet.getInt("idade");

				alunoBD.setId(idBD);
				alunoBD.setNome(nomeBD);
				alunoBD.setIdade(idadeBD);

				listaAluno.add(alunoBD);
			}
			prepStmt.close();
			resultSet.close();
			return listaAluno;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}