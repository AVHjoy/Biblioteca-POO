package biblioteca_poo.livro;

public class LivroInfantil extends Livro {

	private static final long serialVersionUID = 1L;
	
	private boolean actionFigure;
	// 
	public LivroInfantil(String tit, String aut, boolean dig, int pag, int ISBN, boolean actfig) {
		super(tit, aut, dig, pag, ISBN);
		this.setGenero("Infantil");
		this.setActionFigure(actfig);
	}

	@Override
	public String promove() {
		return "desenvolvimento sensório-motor infantil.";
	}

	public boolean isActionFigure() {
		return actionFigure;
	}
	public void setActionFigure(boolean actionFigure) {
		this.actionFigure = actionFigure;
	}
}
