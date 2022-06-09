package biblioteca_poo;

public class LivroTerror extends Livro {
	private int classInd;
	
	public LivroTerror(String tit, String aut, boolean dig, int pag, int ISBN, int claind) {
		super(tit, aut, dig, pag, ISBN);
		this.setGenero("Terror");
		this.setClassInd(claind);
	}

	@Override
	public String promove() {
		return "medo naquele que lê!";
	}
	
	public int getClassInd() {
		return classInd;
	}
	public void setClassInd(int classInd) {
		this.classInd = classInd;
	}
}
