package brechó;

import java.util.InputMismatchException;
import java.util.Scanner;

//e-commerc brechó 
/*
 * criar um brechó online para que o usuário possa cadastrar suas roupas, retirá-las, apagar brechó e atualizar dados, 
 * sem se preocupar com a estrutura de vendas
 */
//Menu para usuário cadastrar produtos, excluir etc
public class Menu {
	public static void main(String[] args) {
		int opcao;
		
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
			System.out.println("                   2 - listar todos brechós                    ");
			System.out.println("                   3 - atualizar dados do brechó               ");
			System.out.println("                   4 - apagar brechó                           ");
			System.out.println("                   5 - retirar roupa                           ");//sacar
			System.out.println("                   6 - adicionar roupa                         ");//depositar
			System.out.println("                   7 - sair                                    ");
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
			
			//caso entre em 7 método sobre é acionado e o while fechado
			if(opcao == 7) {
				System.out.println("\nSeu Brechó, o jeito mais fácil de vender suas roupas!");
				sobre();
				scanner.close();
				System.exit(0);
			}
			
			//opções em swtich case
			switch(opcao) {
			case 1:
				System.out.println("criar Brechó\n\n");
				break;
			case 2:
				System.out.println("listar Brechós\n\n");
				break;
			case 3:
				System.out.println("atualizar Dados do Brechó\n\n");
				break;
			case 4:
				System.out.println("apagar Brechó\n\n");
				break;
			case 5:
				System.out.println("retirar Roupa\n\n");
				break;
			case 6:
				System.out.println("adicionar Roupa\n\n");
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
}
