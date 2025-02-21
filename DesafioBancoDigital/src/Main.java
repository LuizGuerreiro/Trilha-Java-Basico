import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static String nome = "";
	static int option = -1;
	static Banco banco;
	static List<Conta> listaContas = new ArrayList<>();

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		do {
			System.out.println(Conta.linha);
			System.out.println("Bem vindo! Vamos criar um banco novo.");
			System.out.print("Qual o nome do banco? ");
			try {
				nome = scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
				System.out.println("Digite um nome válido!");
			}
		} while (nome.isEmpty());

		banco = new Banco(nome);
		nome = "";

		do {
			System.out.println(Conta.linha);
			System.out.println("Bem vindo ao banco " + banco.getNome());
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Criar conta corrente");
			System.out.println("2 - Criar conta poupança");
			System.out.println("3 - Listar todos os clientes");
			System.out.println("4 - Acessar conta");
			System.out.println("0 - Sair");
			System.out.print("Opção: ");
			try {
				option = scan.nextInt();
			} catch (Exception e) {
				option =-1 ;
			}
			scan.nextLine();

			switch (option) {
				case 0: //Sair
					break;
				case 1: //CC
					criarContaCorrente(scan);
					break;
				case 2: //Poupança
					criarPoupanca(scan);
					break;
				case 3: //Listar clientes
					System.out.println(Conta.linha);
					if (listaContas.size() > 0) {
						banco.listaClientes();					
					} else {
						System.out.println("Nenhuma conta registrada!");
					}
					break;
				case 4: //Acessar
					System.out.println(Conta.linha);
					if (listaContas.size() > 0) {
						acessarConta(scan);						
					} else {
						System.out.println("Nenhuma conta registrada!");
					}
					break;
			
				default:
					System.out.println("Opção inválida!");
					break;
			}
		} while (option!=0);

	}

	private static void criarContaCorrente(Scanner scan) {
		String nome = "";
		do {
			System.out.println(Conta.linha);
			System.out.print("Digite o nome do cliente: ");
			try {
				nome = scan.nextLine();
			} catch (Exception e) {
				System.out.println("Opção inválida!");
			}

			Cliente cliente = new Cliente();
			cliente.setNome(nome);
			Conta cc = new ContaCorrente(cliente);
			listaContas.add(cc);
			banco.setContas(listaContas);
			
		} while (nome.isEmpty());
	}

	private static void criarPoupanca(Scanner scan) {
		String nome = "";
		do {
			System.out.println(Conta.linha);
			System.out.print("Digite o nome do cliente: ");
			try {
				nome = scan.nextLine();					
			} catch (Exception e) {
				scan.nextLine();
				System.out.println("Opção inválida!");
			}

			Cliente cliente = new Cliente();
			cliente.setNome(nome);
			Conta poupanca = new ContaPoupanca(cliente);
			listaContas.add(poupanca);
			banco.setContas(listaContas);
			
		} while (nome.isEmpty());
	}

	private static void acessarConta(Scanner scanner) {
		int option = -1;
		int contador = 0;
		int indexConta = 0;
		double valor = 0;
		Conta acesso = null;
		Conta destino = null;

		do {
			System.out.println("Escolha uma conta:");
			for (Conta conta : listaContas) {
				System.out.println(++contador + " - " + conta.cliente.getNome());
			}
			System.out.print("Opção: ");

			try {
				option = scanner.nextInt();
			} catch (Exception e) {
				option = -1;
				scanner.nextLine();
			}

			if (0 < option && option <= listaContas.size()) {
				indexConta = option - 1;
				acesso = listaContas.get(indexConta);
				option = 0;
			} else {
				System.out.println("Opção inválida!");
				option = -1;
			}
			contador = 0;
		} while (option != 0);

		do {
			System.out.println(Conta.linha);
			System.out.println("Conta de " + acesso.cliente.getNome() + ":");
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Consultar saldo");
			System.out.println("2 - Depositar");
			System.out.println("3 - Sacar");
			System.out.println("4 - Transferir");
			System.out.println("5 - Extrato");
			System.out.println("0 - Voltar");
			System.out.print("Opção: ");

			try {
				option = scanner.nextInt();
			} catch (Exception e) {
				option = -1;
			}

			scanner.nextLine();

			switch (option) {
				case 0: //Voltar
					break;
				case 1: //Saldo
					System.out.println(Conta.linha);
					System.out.println(String.format("Saldo: R$%.2f", acesso.getSaldo()));
					break;
				case 2: //Depósito
					System.out.println(Conta.linha);
					System.out.print("Digite o valor a ser depositado: ");
					try {
						valor = scanner.nextDouble();						
						acesso.depositar(valor);
						System.out.println(String.format("Depósito de R$%.2f efetuado com sucesso!", valor));
					} catch (Exception e) {
						System.out.println("Valor inválido!");
						scanner.nextLine();
					}
					break;
				case 3: //Sacar
					System.out.println(Conta.linha);
					System.out.print("Digite o valor a ser sacado: ");
					try {
						valor = scanner.nextDouble();
						if (acesso.sacar(valor)) {
							System.out.println(String.format("Saque de R$%.2f efetuado com sucesso!", valor));							
						}
					} catch (Exception e) {
						System.out.println("Valor inválido!");
						scanner.nextLine();
					}
					break;
				case 4: //Transferir
					valor = 0;
					System.out.println(Conta.linha);
					System.out.println("Escolha uma conta:");
					for (Conta conta : listaContas) {
						if (contador == indexConta) {
							contador++;
							continue;
						}
						System.out.println(++contador + " - " + conta.cliente.getNome());
					}
					System.out.print("Opção: ");

					try {
						option = scanner.nextInt();
						destino = listaContas.get(option - 1);
					} catch (Exception e) {
						System.out.println("Valor inválido!");
						scanner.nextLine();
					}

					if (destino != null) {
						System.out.println(Conta.linha);
						System.out.print("Digite o valor a ser transferido: ");
						try {
							valor = scanner.nextDouble();
							if (acesso.transferir(valor, destino)) {
								System.out.println(String.format("Transferência de R$%.2f para %s efetuado com sucesso!", valor, destino.cliente.getNome()));								
							}
						} catch (Exception e) {
							System.out.println("Valor inválido!");
						}
					}

					contador = 0;
					break;
				case 5: //Extrato
					System.out.println(Conta.linha);
					acesso.imprimirExtrato();
					break;
			
				default:
					System.out.println("Opção inválida!");
					break;
			}
		} while (option != 0);
}

}