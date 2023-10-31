package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

	private static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
	private Date momento;
	private StatusPedido status;
	private Clientes cliente;
	private List<ItensPedido> itens = new ArrayList<ItensPedido>();
	
	public Pedido() {
		
	}

	public Pedido(Date momento, StatusPedido status, Clientes cliente, List<ItensPedido> itens) {
		super();
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
		this.itens = itens;
	}

	public static SimpleDateFormat getSdf() {
		return sdf;
	}

	public static void setSdf(SimpleDateFormat sdf) {
		Pedido.sdf = sdf;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	
	//OPERAÇÕES DE ADIÇÃO E REMOÇÃO DO PEDIDO - TOTAL DO PRODUTO
	public void addItens(ItensPedido item) {
		itens.add(item);
	}
	public void removeItens(ItensPedido item) {
		itens.remove(item);
	}
	public double total() {
		double soma = 0.0;
		for (ItensPedido it : itens) {
			soma += it.subTotal();
		}
		return soma;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
			
		sb.append("MOMENTO DO PEDIDO: ");
		sb.append(sdf.format(momento)+"\n");
		sb.append("Order Status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(cliente + "\n");
		for (ItensPedido item : itens) {
			sb.append(item + "\n");
		}
		sb.append("PREÇO TOTAL: R$");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
	
}