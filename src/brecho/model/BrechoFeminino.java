package brecho.model;

public class BrechoFeminino extends Brecho {

	private String genero;

	public BrechoFeminino(int numero, String nomeBrecho, String tipo, String titular, float saldo, String genero) {
		super(numero,nomeBrecho,tipo, saldo, titular);
		this.genero = genero;
	}
	
	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public void visualizar() {
		super.visualizar();
		System.out.println("Gênero:                           " + this.genero);
	}
}
