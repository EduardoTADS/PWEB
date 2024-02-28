package testes;

import java.util.Scanner;

import DAO.DisciplinaDAO;
import modelo.Disciplina;

public class TesteConsultaDisciplinaBD_ComDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Disciplina disciplina = new Disciplina();
				
				Scanner scanner = new Scanner(System.in);
				System.out.print("Digite o id do Disciplina: ");
				int idSelecao = scanner.nextInt();
				
				DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
				
				disciplinaDAO.consultarPorID(idSelecao);
				
				if(disciplinaDAO.consultarPorID(idSelecao).getNome() != null) {
					System.out.println("Disciplina -> "+ disciplinaDAO.consultarPorID(idSelecao).getNome() + " - Carga Horaria -> " 
							+ disciplinaDAO.consultarPorID(idSelecao).getCargaHr() + " - Situacao -> " 
							);
							if(disciplinaDAO.consultarPorID(idSelecao).isAtiva() == true) {
								System.out.println("ATIVA");
							}else {
								System.out.println("INATIVA");
							}
				}else {
					System.out.println("NÃO EXISTE DISCIPLINA");
				}
	}

}
