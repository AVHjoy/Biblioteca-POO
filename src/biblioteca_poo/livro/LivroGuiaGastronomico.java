package biblioteca_poo.livro;

public class LivroGuiaGastronomico extends Livro {

	private static final long serialVersionUID = 1L;
	
	private int cupom;
	
	public LivroGuiaGastronomico(String tit, String aut, boolean dig, int pag, int ISBN, int cup) {
		super(tit, aut, dig, pag, ISBN);
		this.setGenero("Guia");
		this.setCupom(cup);
	}

	@Override
	public String promove() {
		return "uma lista com reviews dos melhores locais para realizar uma refei��o!";
	}

	public int getCupom() {
		return cupom;
	}
	public void setCupom(int cupom) {
		this.cupom = cupom;
	}
}
