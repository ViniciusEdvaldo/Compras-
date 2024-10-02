package model;


import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import dao.CompraDAO;
import dao.NotaFiscalDAO;
import dao.ProdutoDAO; //biblioteca importada para poder criar uma instancia de ProdutoDAO.

public class Mercado {
	
	double valorCompra;
	private static List<Produto> listaCompra = new ArrayList<Produto>();
	private List<Produto> listaAdicionados = new ArrayList<Produto>();
 	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private CompraDAO compraDAO = new CompraDAO();
	private NotaFiscalDAO notaFiscalDAO = new NotaFiscalDAO();
	private NotaFiscal notaFiscal;
	
	
	ProdutoDAO produto = new ProdutoDAO();
	
	public List<Produto> listarProdutos(){
		return produto.listar();
	}
	
	public double adicionarACompra(int codigo) {  //metodo para calcular o valor da compra e adicionar um prooduto a compra
		valorCompra = 0;
		Produto p = produtoDAO.buscar(codigo);
		listaCompra.add(p);
		for(Produto produto: listaCompra) {
			valorCompra += produto.getValor();
		}
		return valorCompra;
	}
	
	public double removerDaCompra(int codigo) {  //metodo para calcular o valor da compra e remover um produto da compra.
		valorCompra = 0;
		
		for(int i = 0; i < listaCompra.size(); i++) 
			if(listaCompra.get(i).getCodigo() == codigo) {
				listaCompra.remove(i);
				break;
			}
		
		for(Produto produto: listaCompra) {
			valorCompra += produto.getValor();
		}
		return valorCompra;
	}
	
	
	public boolean finalizarCompra(String formaPagamento) {
		Compra compra = new Compra(formaPagamento);
		for(Produto produto: listaCompra) {
			valorCompra += produto.getValor();
		}
		
		compra.setValor(valorCompra);
		
		
		compraDAO.inserir(compra);
		Time horario = new Time(System.currentTimeMillis());
		Date data = new Date(System.currentTimeMillis());
		
		notaFiscal = new NotaFiscal(valorCompra, horario, data, "'CNPJ'", compraDAO.listar().get(compraDAO.listar().size() -1 ).getIdCompra(), formaPagamento);
		notaFiscalDAO.inserir(notaFiscal);

		listaCompra.clear();

		
		
		return true;
		
	}
	
	public List<NotaFiscal> gerarNotaFiscal() {
		List<NotaFiscal> notas = new ArrayList<NotaFiscal>();
		NotaFiscal nota = notaFiscalDAO.listar().get(notaFiscalDAO.listar().size() -1);

		notas.add(nota);
		
		return notas;
	}
	
	public static List<Produto> getListaCompra(){
		return listaCompra;
	}
	
	public boolean registrarProduto(String nome, String valor) {
		boolean retorno = false;
		try{
			double valorA = Double.parseDouble(valor);
		
			Produto p = new Produto(nome, valorA);
			
			if(produtoDAO.inserir(p)) {
				retorno = true;
				listaAdicionados.add(produtoDAO.listar().get(produtoDAO.listar().size() - 1));
			}
		
			return retorno;
		}catch(Exception e) {
			return retorno;
		}
		
	}
	
	public boolean removerProduto(String nome) {
		boolean retorno = false;
		try{
			
			for(int i = 0; i < listaAdicionados.size(); i++) 
			if(listaAdicionados.get(i).getNome().equals(nome)) {
				listaAdicionados.remove(i);
				break;
			}
		
		for(int i = 0; i < produtoDAO.listar().size(); i++) 
			if(produtoDAO.listar().get(i).getNome().equals(nome)) {
				produtoDAO.deletar(produtoDAO.listar().get(i).getCodigo());
				retorno = true;
				break;
			}
		return retorno;
		}catch(Exception e) {
			return false;
		}
	}
	
	public List<Produto> getListaAdicionados(){
		return listaAdicionados;
	}
	
}