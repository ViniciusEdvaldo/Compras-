package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Caixa;
import model.Usuario;

public class CaixaDao {

private Connection conn;
	
	public CaixaDao() {
	
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
	
	public boolean inserir(Caixa caixa){

	      String sql = "INSERT INTO caixa(nome, id) VALUES(?, ?)";

	      try{
	        PreparedStatement ps = conn.prepareStatement(sql);
	    
	        ps.setString(1, caixa.getNome());
	        ps.setInt(2, caixa.getId());
	        ps.execute();
          return true;
	        
	      } catch(SQLException e){
	        e.printStackTrace();
	        return false;
	      }
	    }
	
	public List<Caixa> listar(){
		List<Caixa>listarCaixas = new ArrayList<Caixa>();
		String sql = "SELECT * FROM caixa";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				
				
				Caixa c = new Caixa(id, nome);
				listarCaixas.add(c);
	
			}
			return listarCaixas;
		} catch(SQLException e) {
			e.printStackTrace();
			return listarCaixas;
		}
	}
	
	 public boolean atualizar(String novoNome) { 
	  		String sql = "UPDATE caixa SET nome = ? WHERE id = ?";
	  	
	  		try {
	  			PreparedStatement ps = conn.prepareStatement(sql);
	  			ps.setString(1, novoNome);
	  			
	  			int rowsAffected = ps.executeUpdate();
	  			return rowsAffected > 0; 
	  			
	  		}catch(SQLException e) {
	  			e.printStackTrace();
	  			return false;
	  		}
	    }
	 
	 public boolean deletar(int id) {
	  	  String sql = "DELETE FROM caixa WHERE id = ?";
	  	  try {
	  		  PreparedStatement ps = conn.prepareStatement(sql);
	  		  ps.setInt(1, id);
	  		  int rowsAffected = ps.executeUpdate();
	  		  return rowsAffected > 0;
	  	  }catch(SQLException e) {
	  		  e.printStackTrace();
	  		  return false;
	  	  }
      }
	
}
