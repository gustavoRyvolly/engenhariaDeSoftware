
package model.dao;

import connection.Conex;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.AtributoUsuario;

public class CadUsuario {
    
    
    
   // AtributoUsuario acu = new AtributoUsuario();
    
    
   public void inserirDados(AtributoUsuario acu){
       Connection con = Conex.getConnection();
       PreparedStatement stmt = null;
       try {
           stmt = con.prepareStatement("INSERT INTO usuario( nome, usuario, senha, email, privilegio, situacao,imagem) VALUES (?, ?, ?, ?, ?, ?, ?)");
           stmt.setString(1, acu.getNome());
           stmt.setString(2, acu.getUsuario());
           stmt.setString(3, acu.getSenha());
           stmt.setString(4, acu.getEmail());
           stmt.setString(5, acu.getPrivilegio());
           stmt.setString(6, acu.Desativado() );
           stmt.setBytes(7, acu.getFotoEmByte() );
           
           stmt.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
    
    
   public ArrayList<AtributoUsuario> getUsuarios(){
       
       Connection con = Conex.getConnection();
       
       PreparedStatement stmt = null;
       ResultSet rs = null;
       ArrayList<AtributoUsuario> usuarios = new ArrayList();
       try {
           stmt = con.prepareStatement("select * from usuario order by nome");
           rs = stmt.executeQuery();
           while(rs.next()){
             AtributoUsuario acu = new AtributoUsuario();
             acu.setId(rs.getInt("id_usuario"));
             acu.setNome(rs.getString("nome"));
             acu.setUsuario(rs.getString("usuario"));
             acu.setSenha(rs.getString("senha"));
             acu.setEmail(rs.getString("email"));
             acu.setPrivilegio(rs.getString("privilegio"));
             acu.setSituacao(rs.getString("situacao"));
             acu.setFotoEmByte(rs.getBytes("imagem"));
             
             usuarios.add(acu);
           }
       } catch (SQLException ex) {
           Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
       }
     return usuarios;  
   }
    
    public void deletar(AtributoUsuario acu){
       Connection con = Conex.getConnection();
       PreparedStatement stmt = null;
       try {
           stmt = con.prepareStatement("DELETE FROM usuario WHERE id_usuario = ? ");
           stmt.setInt(1, acu.getId());
           stmt.executeUpdate();
           con.close();
           stmt.close();
       } catch (SQLException ex) {
           Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }

    public void redefinirSenha(AtributoUsuario acu) {
       Connection con = Conex.getConnection();
       PreparedStatement stmt = null;
       try {
           stmt = con.prepareStatement("update usuario set usuario = ?, senha = ?, situacao = ? where id_usuario = ? ");
           stmt.setString(1, acu.getUsuario());
           stmt.setString(2, acu.getSenha());           
           stmt.setString(3, acu.Ativado());           
           stmt.setInt(4, acu.getId());
           stmt.executeUpdate();
           JOptionPane.showMessageDialog(null, "Senha redefinida com sucesso!","Autenticacão",JOptionPane.INFORMATION_MESSAGE);
       } catch (SQLException ex) {
           Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
        
    }

    public void AtivarDesativar(AtributoUsuario acu) {
       Connection con = Conex.getConnection();
       PreparedStatement stmt = null;
       try {
           stmt = con.prepareStatement("update usuario set situacao = ? where id_usuario = ? ");
           stmt.setString(1, acu.getSituacao());           
           stmt.setInt(2, acu.getId());
           stmt.executeUpdate();
           JOptionPane.showMessageDialog(null, "Situaçao alterada com sucesso!","Autenticacão",JOptionPane.INFORMATION_MESSAGE);
       } catch (SQLException ex) {
           Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
       }
    }



     
     public byte[] imageToByte(String image) throws IOException{
         InputStream is = null;
         byte[] buffer = null;
         is = new FileInputStream(image);
         buffer = new byte[is.available()];
         is.read(buffer);
         is.close();
         return buffer;
     }
    
    
    
    
    
    
    
}
