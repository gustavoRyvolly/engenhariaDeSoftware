
package model.dao;

import connection.Conex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.AtributoCadastrarCliente;
import model.bean.AtributoUsuario;


public class CadCliente {
   
    
    
    
    public void cadCliente(AtributoCadastrarCliente acc) {
        Date date;
        Timestamp data = new Timestamp(0, 0, 0, 0, 0, 0, 0);// apenas para inicialiar a variavel data
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = sdf.parse(acc.getDataNasc());
            data = new Timestamp(date.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(CadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        //String dataparasql = "'"+sdf.format(date)+"'";
        //java.sql.Date datesql = new java.sql.Date(date.getTime());
        
        
        
        
        
       Connection con = Conex.getConnection();
       PreparedStatement stmt = null;
     /*    String sqlcode2 = "INSERT INTO cliente(\n" +
"            codigo, nome)\n" +
"    VALUES (?, ?);";
       
*/       
     String sqlCode = "INSERT INTO cliente(\n" +
"             codigo, nome, data_nascimento, cpf, rg, sexo, fone_principal, \n" +
"            celular, fone_recado, email, origem, cep, endereco, numero, bairro, \n" +
"            complemento, cidade, uf, referencia)\n" +
"    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
       try {
           stmt = con.prepareStatement(sqlCode);
           stmt.setString(1, acc.getCodigo());
           stmt.setString(2, acc.getNome());
           stmt.setTimestamp(3, data);
           stmt.setString(4, acc.getCpf());
           stmt.setString(5, acc.getRg());
           stmt.setString(6, acc.getSexo() );
           stmt.setString(7, acc.getFonePrincipal() );
           stmt.setString(8, acc.getCelular() );
           stmt.setString(9, acc.getFoneRecado() );
           stmt.setString(10, acc.getEmail() );
           stmt.setString(11, acc.getOrigem() );
           stmt.setString(12, acc.getCep() );
           stmt.setString(13, acc.getEndereco() );
           stmt.setString(14, acc.getNumero() );
           stmt.setString(15, acc.getBairro() );
           stmt.setString(16, acc.getComplemento() );
           stmt.setString(17, acc.getCidade() );
           stmt.setString(18, acc.getUf() );
           stmt.setString(19, acc.getReferencia() );
          
           stmt.executeUpdate();
           JOptionPane.showMessageDialog(null, "Cliente Salvo com Sucesso.");
       } catch (SQLException ex) {
           Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    
    
    public ArrayList<AtributoCadastrarCliente> buscarCliete(String nome_ou_codigo){
        String sqlCode="";
        int num=0;                                 //janaina3
        if(nome_ou_codigo.length()==0){             //45675
         sqlCode="select * from cliente order by nome";
        }else{
            for(int i=0;i<nome_ou_codigo.length();i++){
               if("0123456789".indexOf(nome_ou_codigo.charAt(i))!=-1) {
                num++;  
               }else{
                   break;
               }    
            }
           
            if(num==nome_ou_codigo.length()){
              sqlCode="select * from cliente where id_cliente = "+nome_ou_codigo;   
            }else{
              sqlCode="select * from cliente where nome like '%"+nome_ou_codigo+"%' order by nome";   
            }
            
           
        }
        
       Connection con = Conex.getConnection();       
       PreparedStatement stmt = null;
       ResultSet rs = null;
       ArrayList<AtributoCadastrarCliente> clientes = new ArrayList();
       try {
           stmt = con.prepareStatement(sqlCode);
           rs = stmt.executeQuery();
           while(rs.next()){
             AtributoCadastrarCliente acc = new AtributoCadastrarCliente();  
             acc.setCodigo(String.valueOf(rs.getInt("id_cliente")));
             acc.setNome(rs.getString("nome"));
             acc.setDataNasc(String.valueOf(rs.getDate("data_nascimento")));
             acc.setCpf(rs.getString("cpf"));
             acc.setRg(rs.getString("rg"));
             acc.setSexo(rs.getString("sexo"));
             acc.setFonePrincipal(rs.getString("fone_principal"));
             acc.setCelular(rs.getString("celular"));
             acc.setFoneRecado(rs.getString("fone_recado"));
             acc.setEmail(rs.getString("email"));
             acc.setOrigem(rs.getString("origem"));
             acc.setCep(rs.getString("cep"));
             acc.setEndereco(rs.getString("endereco"));
             acc.setNumero(rs.getString("numero"));
             acc.setBairro(rs.getString("bairro"));
             acc.setComplemento(rs.getString("complemento"));
             acc.setCidade(rs.getString("cidade"));
             acc.setUf(rs.getString("uf"));
             acc.setReferencia(rs.getString("referencia"));
             
             clientes.add(acc);
           }
       } catch (SQLException ex) {
           Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
       }
     return clientes;  
    }
    
    
    
    
    
    public void excluirCliente(AtributoCadastrarCliente acc){
       Connection con = Conex.getConnection();
       PreparedStatement stmt = null;
       try {
           stmt = con.prepareStatement("DELETE FROM cliente WHERE id_cliente = ? ");
           stmt.setInt(1, Integer.parseInt(acc.getCodigo()));
           stmt.executeUpdate();
           con.close();
           stmt.close();
           JOptionPane.showMessageDialog(null, "Cliente Excluido com Sucesso.");
       } catch (SQLException ex) {
           Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
        
        
        
    
    
    
    public void editarCliente(AtributoCadastrarCliente acc){
        
  }
    
    
}