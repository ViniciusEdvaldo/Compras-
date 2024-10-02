package dao;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;

import model.Compra;
import model.NotaFiscal;
import model.Produto;

public class TesteDAO {
	
		  public static void main(String[] args) {

				
				/*try { 
					Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
					System.out.println("Driver carregado com sucesso!");
				} catch(Exception e) {
					System.out.println("Driver  não pode ser carregado");
				}*/
			
			  
			  ProdutoDAO pd = new ProdutoDAO();
			  CompraDAO cd = new CompraDAO();
			  NotaFiscalDAO nfd = new NotaFiscalDAO();
			  Time time = new Time(System.currentTimeMillis());
			  Date data = new Date(System.currentTimeMillis());
			  
			  System.out.println(cd.listar().get(cd.listar().size() -1).getIdCompra());
			  
			  NotaFiscal nota = new NotaFiscal(16.50, time, data, "321456789", 123456, " dinheiro" );
			  
			  nfd.inserir(nota);
			  
	
			  
		
			  
		

			  
			 
			 for(Produto p : pd.buscarProduto("teclado")){
					System.out.println("Nome: " + p.getNome());
					System.out.println("Valor :" + p.getValor());
					System.out.println("Codigo: " + p.getCodigo());
					System.out.println();
				}
			  
			  
		}
	}


	

