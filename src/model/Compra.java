package model;

public class Compra {

	private int idCompra;
	private String formaPagamento;
	private double valor;
	
	
	public Compra(int idCompra, String formaPagamento, double valor) {
		super();
		this.idCompra = idCompra;
		this.formaPagamento = formaPagamento;
		this.valor = valor;
	}


	public Compra( String formaPagamento) {
		super();
		this.formaPagamento = formaPagamento;
		
	}


	public int getIdCompra() {
		return idCompra;
	}


	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}


	public String getFormaPagamento() {
		return formaPagamento;
	}


	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
