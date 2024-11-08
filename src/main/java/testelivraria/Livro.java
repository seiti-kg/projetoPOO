package testelivraria;

public class Livro {
	private String titulo;
	private String autor;
	private String categoria;
	private int quantidadeDiponivel;
	
	
	//Getter e Setters
	public String getTituloLivro() {
		return titulo;
	}
	public void setTituloLivro(String titulo) {
		this.titulo = titulo;
	}
	public String getAutorLivro() {
		return autor;
	}
	public void setAutorLivro(String autor) {
		this.autor = autor;
	}
	public String getCategoriaLivro() {
		return categoria;
	}
	public void setCategoriaLivro(String categoria) {
		this.categoria = categoria;
	}
	public int getQuantidadeDiponivelLivro() {
		return quantidadeDiponivel;
	}
	public void setQuantidadeDiponivelLivro(int quantidadeDiponivel) {
		this.quantidadeDiponivel = quantidadeDiponivel;
	}
}
