package modelo;

public class Livro {
	private int codigo;
	private String titulo;
	private int anoPub;
		
	public Livro(int codigo, String titulo, int anoPub) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.anoPub = anoPub;
	}
	
	public void ImprimeDados() {
		System.out.println("Código " + this.codigo + " - titulo: " + this.titulo + " - Ano "+ this.anoPub);
	}
	
}
