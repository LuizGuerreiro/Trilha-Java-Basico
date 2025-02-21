import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Banco {

	@Getter @Setter private String nome;
	@Getter @Setter private List<Conta> contas;

	public Banco (String nome) {
		this.nome = nome;
	}

	public void listaClientes () {
		if (contas != null) {
			for (Conta conta : contas) {
				System.out.println(conta.cliente.getNome());
			}
		} else {
			System.out.println("Nenhuma conta encontrada!");
		}
	}

}