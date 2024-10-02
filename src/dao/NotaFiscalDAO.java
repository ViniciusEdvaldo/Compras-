package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import model.NotaFiscal;

public class NotaFiscalDAO {

	private Connection conn;
	
	public NotaFiscalDAO() {
		this.conn = null;
	    String url = "jdbc:mysql://localhost/sistemaCaixa";
	    String user = "vinicius";
	    String password = "vinicius2128";

	    try{
	      conn = DriverManager.getConnection(url, user, password);
	      System.out.println("Conexão com banco de dados estabelecida com sucesso");
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	}
	
	
	//CRUD - CREATE
	public boolean inserir(NotaFiscal notaFiscal) {
		
		String sql = "INSERT INTO notafiscal(valorTotal, horario, dia, cnpj, idCompra, formaPagamento) VALUES(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
				 
			ps.setDouble(1, notaFiscal.getValorTotal());
			ps.setTime(2, notaFiscal.getHora());
			ps.setDate(3, (java.sql.Date) notaFiscal.getDia());
			ps.setString(4,  notaFiscal.getCnpj());
			ps.setInt(5,  notaFiscal.getIdCompra());
			ps.setString(6,  notaFiscal.getFormaDePagamento());
			ps.execute();
			
			return true;
		}catch(SQLException e){
		      e.printStackTrace();
		      return false;
		    }
		
	}
	
	
	//CRUD - READ
	
	public List<NotaFiscal> listar(){
		List<NotaFiscal>listarNotas = new ArrayList<NotaFiscal>();
		
		String sql = "SELECT * FROM notafiscal";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			
			while(rs.next()) {
				int codigo = rs.getInt("codigo");
				double valor = rs.getDouble("valorTotal");
				Time hora = rs.getTime("horario");
				Date dia = rs.getDate("dia");
				String cnpj = rs.getString("cnpj");
				int idCompra = rs.getInt("idCompra");
				String formaPagamento = rs.getString("formaPagamento");
				NotaFiscal notaFiscal = new NotaFiscal(codigo, valor, hora, dia, idCompra, formaPagamento);
				listarNotas.add(notaFiscal);
			}
			return listarNotas;
		}catch(SQLException e) {
			e.printStackTrace();
			return listarNotas;
		}
	}
	
}
