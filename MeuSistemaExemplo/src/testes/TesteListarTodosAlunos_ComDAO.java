package testes;

import java.util.ArrayList;
import java.util.List;

import DAO.AlunoDAO;
import modelo.Aluno;

public class TesteListarTodosAlunos_ComDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlunoDAO  alunoDAO = new AlunoDAO();
		
		List<Aluno> listaAluno = new ArrayList<Aluno>();
		
		listaAluno = alunoDAO.listar();
		
		for(int i = 0 ; i <listaAluno.size(); i++) {
			Aluno alunoTemp = listaAluno.get(i);
			
			System.out.println("Aluno -> " + alunoTemp.getNome() +" Idade -> " + alunoTemp.getIdade());
		}
		
	}

}
