package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAO {
	
	private Connection conn;
	
	public UsuarioDAO() {
	
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
	    public boolean inserir(Usuario usuario){

	      String sql = "INSERT INTO Usuario(nome, senha) VALUES(?, ?)";

	      try{
	        PreparedStatement ps = conn.prepareStatement(sql);
	    
	        ps.setString(1, usuario.getNome());
	        ps.setString(2, usuario.getSenha());
	        ps.execute();
            return true;
	        
	      } catch(SQLException e){
	        e.printStackTrace();
	        return false;
	      }
	    }
	    
	    //CRUD - READ
	    
	    public List<Usuario> listar(){
			List<Usuario>listarUsuarios = new ArrayList<Usuario>();
			String sql = "SELECT * FROM usuario";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery(sql);
				
				while(rs.next()) {
					String nome = rs.getString("nome");
					String senha = rs.getString("senha");
					
					Usuario usuario = new Usuario(nome, senha);
					listarUsuarios.add(usuario);
		
				}
				return listarUsuarios;
			} catch(SQLException e) {
				e.printStackTrace();
				return listarUsuarios;
			}
		}
	    
	  //CRUD - UPDATE
	    
	    public boolean atualizar(String novoNome) { //n sei se da pra alterar senha sem da problema com a criptografia
	  		String sql = "UPDATE Usuario SET nome = ? WHERE senha = ?";
	  	
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
	  
 //CRUD - DELETE
	    
	    public boolean deletar(String senha) {
	  	  String sql = "DELETE FROM Usuario WHERE senha = ?";
	  	  try {
	  		  PreparedStatement ps = conn.prepareStatement(sql);
	  		  ps.setString(1, senha);
	  		  int rowsAffected = ps.executeUpdate();
	  		  return rowsAffected > 0;
	  	  }catch(SQLException e) {
	  		  e.printStackTrace();
	  		  return false;
	  	  }
       }

}

