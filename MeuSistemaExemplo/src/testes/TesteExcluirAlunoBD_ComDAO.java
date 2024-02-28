package testes;

import java.util.Scanner;

import DAO.AlunoDAO;
import modelo.Aluno;

public class TesteExcluirAlunoBD_ComDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Aluno aluno = new Aluno();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o id do aluno: ");
		int idSelecao = scanner.nextInt();
		
		AlunoDAO alunoDAO = new AlunoDAO();
		
			System.out.println("Aluno -> "+ alunoDAO.consultarPorID(idSelecao).getNome());		
			
			aluno.setId(idSelecao);
			alunoDAO.excluir(aluno);
			
			System.out.println("Removido Com sucesso");	
			
	}

}

