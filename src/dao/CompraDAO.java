package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Compra;

public class CompraDAO {
	
	 private Connection conn;

	  public CompraDAO(){

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
	    public boolean inserir(Compra compra){

	      String sql = "INSERT INTO Compra(idCompra, formaPagamento, valor) VALUES(?, ?, ?)";

	      try{
	        PreparedStatement ps = conn.prepareStatement(sql);
	    
	        ps.setInt(1, compra.getIdCompra());
	        ps.setString(2, compra.getFormaPagamento());
	        ps.setDouble(3, compra.getValor());
	        ps.execute();
            return true;
	        
	      } catch(SQLException e){
	        e.printStackTrace();
	        return false;
	      }
	    }
	    
	  //CRUD - READ
	    
	    
	    public List<Compra> listar(){
			List<Compra>listarCompras = new ArrayList<Compra>();
			String sql = "SELECT * FROM compra";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery(sql);
				
				while(rs.next()) {
					int idCompra = rs.getInt("idCompra");
					String formaPagamento = rs.getString("formaPagamento");
					double valor = rs.getDouble("valor");
					Compra compra = new Compra(idCompra, formaPagamento, valor);
					listarCompras.add(compra);
		
				}
				return listarCompras;
			} catch(SQLException e) {
				e.printStackTrace();
				return listarCompras;
			}
		}
	   
	  //CRUD - UPDATE
	    
	    public boolean atualizar( String novaFormaPagamento) {
	  		String sql = "UPDATE Compra SET formaPagamento = ? WHERE codigo = ?";
	  		
	  		try {
	  			PreparedStatement ps = conn.prepareStatement(sql);
	  			ps.setString(1, novaFormaPagamento);
	  	
	  			int rowsAffected = ps.executeUpdate();
	  			return rowsAffected > 0; //Returna true se pelo menos uma linha foi afetada
	  			
	  		}catch(SQLException e) {
	  			e.printStackTrace();
	  			return false;
	  		}
	    }
	    
	  //CRUD - DELETE
	    
	    public boolean deletar(int codigo) {
	  	  String sql = "DELETE FROM Compra WHERE codigo = ?";
	  	  try {
	  		  PreparedStatement ps = conn.prepareStatement(sql);
	  		  ps.setInt(1, codigo);
	  		  int rowsAffected = ps.executeUpdate();
	  		  return rowsAffected > 0;
	  	  }catch(SQLException e) {
	  		  e.printStackTrace();
	  		  return false;
	  	  }
       }
}