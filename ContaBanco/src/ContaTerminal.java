import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Olá!");

        System.out.println("Digite seu nome: ");
        String nome = scanner.next();

        System.out.println("Digite seu sobrenome: ");
        String sobrenome = scanner.next();

        System.out.println("Digite o número da sua agência: ");
        String agencia = scanner.next();

        System.out.println("Digite o número da sua conta: ");
        int conta = scanner.nextInt();

        System.out.println("Digite seu saldo: ");
        double saldo = scanner.nextDouble();

        scanner.close();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Olá ");
        stringBuilder.append(nome);
        stringBuilder.append(" ");
        stringBuilder.append(sobrenome);
        stringBuilder.append(", obrigado por criar uma conta em nosso banco! Sua agência é ");
        stringBuilder.append(agencia);
        stringBuilder.append(", conta ");
        stringBuilder.append(conta);
        stringBuilder.append(" e seu saldo de R$");
        stringBuilder.append(saldo);
        stringBuilder.append(" já está disponível para saque.");
        System.out.println(stringBuilder.toString());
    }
}