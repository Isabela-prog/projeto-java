package brecho.repository;

import brecho.model.Brecho;

public interface BrechoRepository {	
		// CRUD da Conta (Create, Read, Update e Delete)
		public void procurarPorNumero(int numero);
		public void listarTodos();
		public void cadastrar(Brecho brecho);
		public void atualizar(Brecho brecho);
		public void deletar(int numero);
		
		// Métodos Bancários (Saque e Deposito)
		public void sacar(int numero, float valor);
		public void computar(int numero, float valor);
}
