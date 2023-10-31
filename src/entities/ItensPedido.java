package entities;

public class ItensPedido {

	private Integer quant;
	private double precoPedido;
	
	
	
	public double subTotal() {
		return quant * precoPedido;
	}
}
