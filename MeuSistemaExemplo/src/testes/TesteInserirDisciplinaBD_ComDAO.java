package testes;

import DAO.DisciplinaDAO;
import modelo.Disciplina;

public class TesteInserirDisciplinaBD_ComDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Disciplina umDisciplina = new Disciplina();
		umDisciplina.setNome("ED II");
		umDisciplina.setCargaHr(35);
		umDisciplina.setAtiva(false);

		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		disciplinaDAO.adiciona(umDisciplina);
		System.out.println("Disciplina inserida no banco de dados");
		
	}

}
