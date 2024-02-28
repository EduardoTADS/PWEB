package testes;
import DAO.AlunoDAO;
import modelo.Aluno;
public class TesteInserirAlunoBD_ComDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Aluno umAluno = new Aluno();
		umAluno.setNome("Luiz");
		umAluno.setIdade(35);
		
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.adiciona(umAluno);
		System.out.println("aluno(a) inserido(a) no banco de dados");
		
	}

}
