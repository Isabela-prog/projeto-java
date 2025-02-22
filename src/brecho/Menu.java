package brecho;

import java.io.IOException;

import java.util.InputMismatchException;
import java.util.Scanner;
import brecho.controller.BrechoController;
import brecho.model.BrechoFeminino;

//e-commerc brechó 
/*
 * criar um brechó online para que o usuário possa vender suas roupas, 
 * sem se preocupar com a estrutura
 */

//Menu para usuário 
public class Menu {
	public static void main(String[] args) {
		int opcao, numero;
		float saldo, valor;
		String titular, genero, tipo;
		String nomeBrecho;
		
		//criar brechos
		BrechoController brechos = new BrechoController();
		
		//criar scanner
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("***************************************************************");
			System.out.println("                                                               ");
			System.out.println("                    Seu brechó online                          ");
			System.out.println("                A venda é nossa, o dinheiro é seu!             ");
			System.out.println("                                                               ");
			System.out.println("***************************************************************");
			System.out.println("                                                               ");
			System.out.println("                   1 - criar brechó                            ");
			System.out.println("                   2 - listar brechós                          ");
			System.out.println("                   3 - buscar brechó por número                ");
			System.out.println("                   4 - atualizar dados do brechó               ");
			System.out.println("                   5 - apagar brechó                           ");
			System.out.println("                   6 - sacar saldo                             "); 
			System.out.println("                   7 - computar venda                          ");//depositar
			System.out.println("                   8 - sair                                    ");
			System.out.println("                                                               ");
			System.out.println("***************************************************************");
			System.out.println("                                                               ");
			System.out.println("Entre com a opção desejada: ");
			
			try {
				// tenta pedir
				opcao = scanner.nextInt();
			} catch (InputMismatchException e) {
				// erro gerado
				System.out.println("\nDigite valores inteiros!");
				scanner.nextLine();
				opcao = 0;
			}
			
			//caso entre em 8 método sobre é acionado e o while fechado
			if(opcao == 8) {
				System.out.println("\nSeu Brechó, o jeito mais fácil de vender suas roupas!");
				sobre();
				scanner.close();
				System.exit(0);
			}
			
			//opções em swtich case
			switch(opcao) {
			case 1:
				System.out.println("      criar Brechó       ");
				System.out.println("*************************");
				//entrar com dados
				System.out.println("digite o Nome do Brechó: ");
				// ignorar a quebra de linha
				scanner.skip("\\R?");
				nomeBrecho = scanner.nextLine();
				System.out.println("digite o Titular: ");
				scanner.skip("\\R?");
				titular = scanner.nextLine();
				
				do {
					System.out.println("digite o Tipo de Brechó (F - Brechó Feminino ou M - Brechó Masculino): ");
					tipo = scanner.nextLine();
				}while(tipo == "F" && tipo == "M");
				
				System.out.println("digite o saldo do Brechó (R$): ");
				saldo = scanner.nextFloat();
				
				switch(tipo) {
				case "F" -> {
					genero = "feminino";
					brechos.cadastrar(new BrechoFeminino(brechos.gerarNumero(), nomeBrecho, tipo, titular, saldo, genero));
				}
				case "M" -> {
					genero = "masculino";
					brechos.cadastrar(new BrechoFeminino(brechos.gerarNumero(), nomeBrecho, tipo, titular, saldo, genero));
				}
				}
				
				keyPress();
				break;
			case 2:
				System.out.println("         Listar Brechós          ");
				System.out.println("*********************************");
				brechos.listarTodos();
				
				keyPress();
				break;
			case 3:
				System.out.println("     buscar Brechó por Número    ");
				System.out.println("*********************************");
				System.out.println("     digite o Número do Brechó:  ");
				
				numero = scanner.nextInt();
				
				brechos.procurarPorNumero(numero);
				
				keyPress();
				break;
			case 4:
				System.out.println("  atualizar Dados do Brechó  ");
				System.out.println("*****************************");
				System.out.println("Digite o Número do Brechó:   ");
				//!! depois adicionar exception
				numero = scanner.nextInt();
				
				var buscaBrecho = brechos.buscarNaCollection(numero);
				
				if(buscaBrecho != null) {
					//tipo = buscaBrecho.getTipo();
					
					System.out.println("Digite o Nome do Brechó:  ");
					scanner.skip("\\R?");
					nomeBrecho = scanner.nextLine();
					System.out.println("Digite o Nome do Titular: ");
					scanner.skip("\\R?");
					titular = scanner.nextLine();
					System.out.println("Digite o Tipo do Brechó (F/M): ");
					tipo = scanner.nextLine();
					System.out.println("Digite o Saldo do Brechó (R$): ");
					saldo = scanner.nextFloat();
					
					switch(tipo) {
					case "F" -> {
						genero = "feminino";
						brechos.atualizar(new BrechoFeminino(numero, nomeBrecho, tipo, titular, saldo, genero));
					}
					case "M" -> {
						genero = "masculino";
						brechos.atualizar(new BrechoFeminino(numero, nomeBrecho, tipo, titular, saldo, genero));
					}
					default -> {
						System.out.println("Tipo de Brechó inválido!");
					}
					}
				}else {
					System.out.println("O Brechó não foi encontrado!");
				}	
				
				keyPress();
				break;
			case 5:
				System.out.println("       apagar Brechó      ");
				System.out.println("**************************");
				System.out.println("Digite o Número do Brechó:");
				numero = scanner.nextInt();
				
				brechos.deletar(numero);
				
				keyPress();
				break;
			case 6:
				System.out.println("        sacar Saldo       ");
				System.out.println("**************************");
				System.out.println("Digite o Número do Brechó:");
				
				numero = scanner.nextInt();
				
				do {
					System.out.println("Digite o valor do Saque (R$): ");
					valor = scanner.nextFloat();
				}while(valor <= 0);
				
				brechos.sacar(numero, valor);
				
				break;
			case 7:
				System.out.println("          computar Venda          ");
				System.out.println("**********************************");
				System.out.println("    digite o Núemero do Brechó    ");
				
				numero = scanner.nextInt();
				
				do {
					System.out.println("digite o Valor da Venda (R$): ");
					valor = scanner.nextFloat();
				} while(valor <= 0);
				
				brechos.computar(numero, valor);
				
				keyPress();
				break;
			default:
				System.out.println("insira uma opção válida!\n\n");
				break;
			}
	}	
	}
	
	private static void sobre() {
		System.out.println( "*****************************************\n");
		System.out.println("                                            ");
		System.out.println("Projeto desenvolvido por:                   ");
		System.out.println("Isabela Santos - isantos.ipereira@gmail.com ");
		System.out.println("    https://github.com/Isabela-prog\n\n     ");
		System.out.println("                                            ");
		System.out.println("******************************************\n");		
	}
	
	//método de teclar enter para continuar
	public static void keyPress() {
		try {
			System.out.println("\n\nPressione Enter para continuar...");
			// leitura das teclas -> se for digitado qlqr outra tecla, retorna -1 (método
			// Keyoress)
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você não pressionou Enter");
		}
	}
}
