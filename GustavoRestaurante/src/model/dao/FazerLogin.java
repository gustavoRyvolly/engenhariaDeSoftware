
package model.dao;

import connection.Conex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.AtributoUsuario;
import model.bean.AtributoLogin;


public class FazerLogin {
   // private static AtributoUsuario  usuarioLocalizado = new AtributoUsuario();
      private static ArrayList<AtributoUsuario> usuario = new ArrayList<>();
      private int idUsuario=-1;
    

    public FazerLogin() {
        usuario.clear();
        carregarTodosUsuarioNaLista();
    }
    
     
    
  /*  
    
    public boolean carregarTodosUsuarioNaLista(AtributoLogin usuario){
        boolean existencia = false;
        try {
            Connection con = Conex.getConnection();
            PreparedStatement stmt = con.prepareStatement("select count(*) as qtdUsuario from usuario where usuario = ? and senha = ?");
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getSenha() );
            ResultSet rs = stmt.executeQuery();
            rs.next();
            if(rs.getInt("qtdUsuario")==1){
             existencia = true;   
            }
            con.close();
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FazerLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
      return existencia;  
    }
   
    
  */  
 
    
    private void carregarTodosUsuarioNaLista(){
        try {
            Connection con = Conex.getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from usuario");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                AtributoUsuario acu = new AtributoUsuario();
                acu.setId(rs.getInt("id_usuario"));
                acu.setUsuario(rs.getString("usuario"));
                acu.setNome(rs.getString("nome"));                
                acu.setSenha(rs.getString("senha"));
                acu.setSituacao(rs.getString("situacao"));
                usuario.add(acu);
            }
         
            con.close();
            stmt.close();
            rs.close();
        } catch (SQLException ex){
            Logger.getLogger(FazerLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean getAutenticationUser(AtributoUsuario login){
        boolean retorno = false;
        int i=0;
        for (AtributoUsuario acu: this.usuario) {
            if(login.getUsuario().equals(acu.getUsuario()) && login.getSenha().equals(acu.getSenha())){
                idUsuario = i;
                retorno = true;
                break;
            }
         i++;    
        }
      return retorno;
    }
    
    //JOptionPane.showMessageDialog(null, "Senha ou Usuário inválidos!","Autenticacão",JOptionPane.ERROR_MESSAGE);
    //JOptionPane.showMessageDialog(null, "Usuário não cadastrado!","Autenticacão",JOptionPane.ERROR_MESSAGE);

  
    
    public boolean verificarExistenciaUsuario(AtributoUsuario acu1){
        boolean retorno = false;
        for (AtributoUsuario acu: this.usuario) {
            if(acu1.getId() != acu.getId()){
                if(acu1.getUsuario().equals(acu.getUsuario())){
                    retorno = true;
                    break;
                }
            }
        }
      return retorno;
    }
    
    
    public AtributoUsuario getusuario() {
         AtributoUsuario  usuario = null;
         if(idUsuario!=-1){
           usuario = this.usuario.get(idUsuario);
        }
    return usuario;
    }
    
    
}
