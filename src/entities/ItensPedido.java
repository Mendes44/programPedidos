package entities;

public class ItensPedido {

	private Integer quant;
	private double precoPedido;
	private Produtos produto;
	
	public ItensPedido() {
		
	}
	
	public ItensPedido(Integer quant, double precoPedido, Produtos produto) {
		this.quant = quant;
		this.precoPedido = precoPedido;
		this.produto = produto;
	}

	public Integer getQuant() {
		return quant;
	}

	public void setQuant(Integer quant) {
		this.quant = quant;
	}

	public double getPrecoPedido() {
		return precoPedido;
	}

	public void setPrecoPedido(double precoPedido) {
		this.precoPedido = precoPedido;
	}

	public Produtos getProduto() {
		return produto;
	}

	public void setProduto(Produtos produto) {
		this.produto = produto;
	}

	//FUNÇÃO PARA CALCULAR O SUBTOTAL DO PRODUTO
	public double subTotal() {
		return quant * precoPedido;
	}
}
