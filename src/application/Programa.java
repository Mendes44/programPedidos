package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Clientes;
import entities.ItensPedido;
import entities.Pedido;
import entities.Produtos;
import entities.StatusPedido;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		//ENTRADA DE DADOS DO CLIENTE
		System.out.println(":::::::::::::::PROGRAMA DE PEDIDOS:::::::::::::::::::::::::");
		System.out.println();
		System.out.println(">>>>>>>> CADASTRO CLIENTE <<<<<<<<<<");
		System.out.println("Entre com as Informações do cliente:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data de Aniversario: ");
		Date dataNiver = sdf.parse(sc.next());

		Clientes cliente = new Clientes(nome,email,dataNiver);
		
		//INFORMAÇÕES DO PEDIDO E STATUS.
		System.out.println("\n>>> INFORMAÇÕES DO PEDIDO <<<");
		System.out.println("\nATENÇÃO! ENTRAR SOMENTE COM OS DADOS DO PEDIDO A SEGUIR:");
		System.out.print("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"
				+ "\n>>>>>  "
				+ " PAGAMENTO_PENDENTE,\r\n>>>>>"
				+ "	PROCESSANDO,\r\n>>>>>"
				+ "	ENVIADO,\r\n>>>>>"
				+ "	ENTREGUE\n");
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.print("\nEntre com STATUS do pedido: ");
		//CONVERTENDO STRING PARA STATUS - POR ISSO E IMPORTANTE COLOCAR DA FORMA CERTA.
		StatusPedido status = StatusPedido.valueOf(sc.next());
		
		//LANÇAMENTO DE QUANTIDADE DE PEDIDOS + INFORMAÇÕES DO PRODUTO.
		
		Pedido pedido = new Pedido (new Date(), status, cliente);
		
		System.out.print("QUANTOS PRODUTOS SERÃO LANÇANDOS? ");
		int n = sc.nextInt();
		
		for (int i=1; i<= n; i++) {
			System.out.println("ENTRE ABAIXO COM OS DADOS DO #"+i+"º ITEM");
			System.out.print("Nome do Produto: ");
			sc.nextLine();
			String nomeProduto = sc.nextLine();
			System.out.print("Preço do Produto: ");
			double precoProduto = sc.nextDouble();
			System.out.print("Quantidade: ");
			int quant = sc.nextInt();
			
			Produtos produto = new Produtos(nomeProduto,precoProduto);
			ItensPedido it = new ItensPedido(quant,precoProduto, produto);
			pedido.addItens(it);
		}
		
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(">>>>>>>>>>>>>>> RESUMO DO PEDIDO <<<<<<<<<<<<<<< ");
		System.out.println(pedido);
		
	sc.close();

	}

}
