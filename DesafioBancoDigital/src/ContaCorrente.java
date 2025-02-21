import lombok.Getter;

public class ContaCorrente extends Conta {

	@Getter protected double chequeEspecial = 1000.00;

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	public boolean sacar(double valor) {
		if(valor > (saldo + chequeEspecial)) {
			System.out.println("Saldo insuficente!");
			return false;
		}
		else {
			saldo -= valor;
			if (saldo < 0) {
				chequeEspecial += saldo;
				saldo = 0.00;
			}
			return true;
		}
	}

	@Override
	public void imprimirExtrato() {
		System.out.println(linha);
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
		System.out.println(String.format("Cheque especial: %.2f", this.chequeEspecial));
	}
	
}