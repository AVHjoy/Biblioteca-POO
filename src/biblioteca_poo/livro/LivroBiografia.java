package biblioteca_poo.livro;

public class LivroBiografia extends Livro {
	
	private static final long serialVersionUID = 1L;
	
	private String biografado;
	
	public LivroBiografia(String tit, String aut, boolean dig, int pag, int ISBN, String biografado) {
		super(tit, aut, dig, pag, ISBN);
		this.setGenero("Biografia");
		this.setBiografado(biografado);
	}
	
	@Override
	public String promove() {
		return "conhecimento sobre o(a) biografado(a).";
	}	

	public String getBiografado() {
		return biografado;
	}
	public void setBiografado(String biografado) {
		this.biografado = biografado;
	}




}
