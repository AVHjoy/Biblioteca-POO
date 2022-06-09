package biblioteca_poo;

public class LivroGuiaGastronomico extends Livro {
	private int cupom;
	
	public LivroGuiaGastronomico(String tit, String aut, boolean dig, int pag, int ISBN, int cup) {
		super(tit, aut, dig, pag, ISBN);
		this.setGenero("Guia");
		this.setCupom(cup);
	}

	@Override
	public String promove() {
		return "uma lista com reviews dos melhores locais para realizar uma refeição!";
	}

	public int getCupom() {
		return cupom;
	}
	public void setCupom(int cupom) {
		this.cupom = cupom;
	}
}
