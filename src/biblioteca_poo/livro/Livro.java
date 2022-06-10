package biblioteca_poo.livro;

import java.io.Serializable;

public abstract class Livro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String titulo, autor;
	protected String genero;
	private boolean digital;
	private int paginas;
	private long ISBN;

	// Construtor
	public Livro(String tit, String aut, boolean dig, int pag, int ISBN) {
		this.titulo = tit;
		this.autor = aut;
		this.digital = dig;
		this.paginas = pag;
		this.ISBN = ISBN;
	}
	
	// Retorna as informações dos livros cadastrados.
	public String infos() {
		StringBuilder str = new StringBuilder();
		str.append("~ Livro ~\n");
		str.append("Título: " + this.getTitulo() + "\n");
		str.append("Autor: " + this.getAutor() + "\n");
		str.append("ISBN: " + this.getISBN() + "\n");
		str.append("Gênero: " + this.getGenero() + "\n");
		str.append("Páginas: " + this.getPaginas() + "\n");
		str.append("É digital? " + this.isDigital() + "\n");	
		str.append("Este é um livro que proporciona " + this.promove() + "\n");
		return str.toString();
	}

	// Método abstrato a ser desenvolvido pelas classes subsequentes.
	public abstract String promove();

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public boolean isDigital() {
		return digital;
	}
	public void setDigital(boolean digital) {
		this.digital = digital;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public long getISBN() {
		return ISBN;
	}
	public void setISBN(long ISBN) {
		this.ISBN = ISBN;
	}
	
}

