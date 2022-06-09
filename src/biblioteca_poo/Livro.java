package biblioteca_poo;

public abstract class Livro {
	private String titulo, autor, genero;
	private boolean digital;
	private int paginas, ISBN;

	// Construtor
	public Livro(String tit, String aut, boolean dig, int pag, int ISBN) {
		this.titulo = tit;
		this.autor = aut;
		this.digital = dig;
		this.paginas = pag;
		this.ISBN = ISBN;
	}
	
	// Retorna as informa��es dos livros cadastrados.
	public String infos() {
		StringBuilder str = new StringBuilder();
		str.append("~ Livro ~\n");
		str.append("T�tulo: " + this.getTitulo() + "\n");
		str.append("Autor: " + this.getAutor() + "\n");
		str.append("ISBN: " + this.getISBN() + "\n");
		str.append("G�nero: " + this.getGenero() + "\n");
		str.append("P�ginas: " + this.getPaginas() + "\n");
		str.append("� digital? " + this.isDigital() + "\n");	
		str.append("Este � um livro que proporciona " + this.promove() + "\n");
		return str.toString();
	}

	// M�todo abstrato a ser desenvolvido pelas classes subsequentes.
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
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	
}

