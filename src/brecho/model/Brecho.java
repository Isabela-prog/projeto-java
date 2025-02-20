package brecho.model;

public abstract class Brecho {
	/*
	 * atributos da classe Conta
	 * private: 
	 * - acessível apenas na classe conta - encapsulamento; atributos só
	 * podem ser capturados e manipulados por outra classe utilizando o GET e SET
	 */
	
	private int numero;
	private String nomeBrecho;
	private String titular;
	private float saldo;
	private String tipo;
	
	//contrutor
	public Brecho(int numero, String nomeBrecho, String titular, float saldo, String tipo) {
		this.numero = numero;
		this.nomeBrecho = nomeBrecho;
		this.titular = titular;
		this.saldo = saldo;
		this.tipo = tipo;
	}
	
	//getters and setters
	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getNomeBrecho() {
		return nomeBrecho;
	}


	public void setNomeBrecho(String nomeBrecho) {
		this.nomeBrecho = nomeBrecho;
	}



	public String getTitular() {
		return titular;
	}


	public void setTitular(String titular) {
		this.titular = titular;
	}


	public float getSaldo() {
		return saldo;
	}


	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	// recebe o valor a ser sacado
	public boolean sacar(float valor) {
		// tratar quando usuário não tive saldo
		if (this.getSaldo() < valor) {
			System.out.println("\nSaldo insuficiente!");
			return false;
		}
		// o get busca o valor do saldo e set atualiza com a subtraçãod do valor
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	public void computar(float valor) {
		this.setSaldo(this.getSaldo() + valor);
	}
	
	public void visualizar() {
		
		System.out.println("\n\n************************************");
		System.out.println("            Dados do Brechó         ");
		System.out.println("************************************");
		System.out.println("Número do brechó:                 " + this.numero);
		System.out.println("Nome do brechó:                   " + this.nomeBrecho);
		System.out.println("Titular:                          " + this.titular);
		System.out.println("Saldo:                            " + this.saldo);
	}

	
	
	
}
