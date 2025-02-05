import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
	public static void main(String[] args) {
		Scanner terminal = new Scanner(System.in);
		
		try {
            System.out.println("Digite o primeiro parâmetro");
            int parametroUm = terminal.nextInt();
            System.out.println("Digite o segundo parâmetro");
            int parametroDois = terminal.nextInt();
            
			contar(parametroUm, parametroDois);
		
		}catch(InputMismatchException exception){
            System.out.println("A entrada deve ser um número inteiro!");
        }catch (ParametrosInvalidosException exception) {
            System.out.println("O segundo parâmetro deve ser maior que o primeiro!");
		}finally {
            terminal.close();
        }
		
	}
	static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
        if (parametroUm >= parametroDois) {
            ParametrosInvalidosException error = new ParametrosInvalidosException();
            throw error;
        }else {
            int contagem = parametroDois - parametroUm;
            
            for (int i = 1; i <= contagem; i++) {
                System.out.println("Imprimindo o número " + i);
            }
        }
		
	}
}