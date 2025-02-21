import lombok.Getter;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	public static final String linha = "----------------------------------------";

	@Getter protected int agencia;
	@Getter protected int numero;
	@Getter protected double saldo = 0.00;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public boolean sacar(double valor) {
		if(valor > saldo) {
			System.out.println("Saldo insuficente!");
			return false;
		}
		else {
			saldo -= valor;
			return true;
		}
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public boolean transferir(double valor, IConta contaDestino) {
		if (this.sacar(valor)) {
			contaDestino.depositar(valor);
			return true;
		} else {
			return false;
		}
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}