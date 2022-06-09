package biblioteca_poo;

public class LivroAutoajuda extends Livro {
	private String categoria;
	
	public LivroAutoajuda(String tit, String aut, boolean dig, int pag, int ISBN, String categoria) {
		super(tit, aut, dig, pag, ISBN);
		this.setGenero("AutoAjuda");
		this.setCategoria(categoria);
	}

	@Override
	public String promove() {
		return "autoconhecimento";
	}

	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
