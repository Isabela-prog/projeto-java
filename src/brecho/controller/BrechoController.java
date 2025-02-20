package brecho.controller;

import java.util.ArrayList;
import brecho.model.Brecho;
import brecho.repository.BrechoRepository;

public class BrechoController implements BrechoRepository {
	// criar um armazenamento local das contas, como um "banco de dados"
	private ArrayList<Brecho> listarBrechos = new ArrayList<Brecho>();
	// armazenar número do último brechó criado
	int numero = 0;

	// método para listar todas as contas através do for each
	// !!! porque override deu erro aqui
	public void listarTodos() {
		for (var brecho : listarBrechos) {
			brecho.visualizar();
		}
	}
	
	// gerar o número da conta
		public int gerarNumero() {
			return ++ numero;
		}
		
	// pegar conta
	// cria uma variável brecho para cada brechó encontrado na lista ListarBrechos
	public Brecho buscarNaCollection(int numero) {
		for(var brecho : listarBrechos) {
			if(brecho.getNumero() == numero) {
				return brecho;
			}
		}
		return null;
	}
	
	@Override
	// busca na lista o brecho com o número digitado no menu
	public void deletar(int numero) {
		var brecho = buscarNaCollection(numero);
		
		// verifica se o brecho não é nulo
		if(brecho != null) {
			// remover o brechó
			if(listarBrechos.remove(brecho) == true) {
				System.out.println("\nO Brechó número " + numero + " foi deletado com sucesso");
			}else {
				System.out.println("\nO Brechó número " + numero + " não foi encontrado!");
			}
		}
		
	}
	
	@Override
	public void procurarPorNumero(int numero) {
		// pegar o brecho com o numero digitado através do método buscarNaCollection
		var brecho = buscarNaCollection(numero);
		
		// verificar se não é nulo e exibir através do método visualizar
		if(brecho != null) {
			brecho.visualizar();
		}else {
			System.out.println("\nO Brechó número: " + numero + " não foi encontrado!");
		}	
	}
	
	@Override
	public void computar(int numero, float valor) {
		// busca brecho através do método buscarNaCollection
		var brecho = buscarNaCollection(numero);
		
		// se o brechó não vier nulo, computa o valor
		if (brecho != null) {
			// usa o método computar da classe Brechó para somar o valor no saldo
			brecho.computar(valor);
			System.out.println("\nO Valor no Brechó Número: " + numero + " foi computado com sucesso!");
		}else {
			System.out.println("\nO Brechó número: " + numero + " não foi encontrado!");
		}	
	}
	
	@Override
	// igual computar só que pegando o método sacar da classe Brechó
	public void sacar(int numero, float valor) {
		var brecho = buscarNaCollection(numero);
		
		if(brecho != null) {
			brecho.sacar(valor);
			System.out.println("\nO saque no Brechó Número: " + numero + " foi efetuado com sucesso!");
		}else {
			System.out.println("\nO Brechí Número: " + numero + " não foi encontrado!");
		}
		
	}

	@Override
	public void cadastrar(Brecho brecho) {
		listarBrechos.add(brecho);
		System.out.println("\nO Brechó Número: " + brecho.getNumero() + " foi criado com sucesso!");
		
	}

	@Override
	public void atualizar(Brecho brecho) {
		var buscaBrecho = buscarNaCollection(brecho.getNumero());
		
		if (buscaBrecho != null) {
			listarBrechos.set(listarBrechos.indexOf(buscaBrecho), brecho);
			System.out.println("\nO Brechó Número: " + brecho.getNumero() + " foi atualizada com sucesso!");		
		}else {
			System.out.println("\nO Brecho Número: " + brecho.getNumero() + " não foi encontrado!");
		}
		
	}



}
