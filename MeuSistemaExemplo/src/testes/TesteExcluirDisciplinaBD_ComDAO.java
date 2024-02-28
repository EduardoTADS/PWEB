package testes;

import java.util.Scanner;

import DAO.DisciplinaDAO;
import modelo.Disciplina;

public class TesteExcluirDisciplinaBD_ComDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Disciplina disciplina = new Disciplina();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o id do Disciplina: ");
		int idSelecao = scanner.nextInt();
		
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		
			System.out.println("Disciplina -> "+ disciplinaDAO.consultarPorID(idSelecao).getNome());		
			
			disciplina.setId(idSelecao);
			disciplinaDAO.excluir(disciplina);
			
			System.out.println("Disciplina Removida Com sucesso");	
		
	}

}
