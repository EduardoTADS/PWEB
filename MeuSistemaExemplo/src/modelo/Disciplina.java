package modelo;


public class Disciplina {
	private int id;
	private String nome;
	private int cargaHr;
	private boolean ativa;
	
	public Disciplina() {
		
	}
	
	public Disciplina(int id, String nome, int cargaHr, boolean ativa) {
		this.setId(id);
		this.setNome(nome);
		this.setCargaHr(cargaHr);
		this.setAtiva(ativa);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCargaHr() {
		return cargaHr;
	}
	public void setCargaHr(int cargaHr) {
		this.cargaHr = cargaHr;
	}
	public boolean isAtiva() {
		return ativa;
	}
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}	
	
	
}
