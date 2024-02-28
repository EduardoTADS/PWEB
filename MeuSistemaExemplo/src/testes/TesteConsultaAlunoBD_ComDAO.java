package testes;

import java.util.Scanner;

import DAO.AlunoDAO;
import modelo.Aluno;

public class TesteConsultaAlunoBD_ComDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Aluno aluno = new Aluno();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o id do aluno: ");
		int idSelecao = scanner.nextInt();
		
		AlunoDAO alunoDAO = new AlunoDAO();
		
		alunoDAO.consultarPorID(idSelecao);
		if(alunoDAO.consultarPorID(idSelecao).getNome() != null) {
			System.out.println("Aluno -> "+ alunoDAO.consultarPorID(idSelecao).getNome() + " - Idade -> " 
					+ alunoDAO.consultarPorID(idSelecao).getIdade());			
		}else {
			System.out.println("NÃO EXISTE ALUNO");
		}
		
	}

}
