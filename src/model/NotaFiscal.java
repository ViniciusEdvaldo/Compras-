package model;

import java.sql.Date;
import java.sql.Time;

import javax.xml.crypto.Data;

public class NotaFiscal {

	private int codigo;
	private double valorTotal;
	private Time horario;
	private Date dia;
	private final String cnpj = "03.773.700/0001-07";
	private int idCompra;
	private String formaDePagamento;
	
	
	public NotaFiscal(int codigo, double valorTotal, Time horario, Date dia, int idCompra, String formaDePagamento) {
		super();
		this.codigo = codigo;
		this.valorTotal = valorTotal;
		this.horario = horario;
		this.dia = dia;
		
		this.idCompra = idCompra;
		this.formaDePagamento = formaDePagamento;
		
	}
	
	
	public NotaFiscal(double valorTotal, Time horario, Date dia, String cnpj, int idCompra, String formaDePagamento) {
		super();
		this.valorTotal = valorTotal;
		this.horario = horario;
		this.dia = dia;
		this.idCompra = idCompra;
		this.formaDePagamento = formaDePagamento;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public Time getHora() {
		return horario;
	}


	public void setHora(Time horario) {
		this.horario = horario;
	}


	public Date getDia() {
		return dia;
	}


	public void setDia(Date dia) {
		this.dia = dia;
	}


	public String getCnpj() {
		return cnpj;
	}


	


	public int getIdCompra() {
		return idCompra;
	}


	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}


	public String getFormaDePagamento() {
		return formaDePagamento;
	}


	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	
	
	
}
