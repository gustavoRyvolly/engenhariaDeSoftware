
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
import model.bean.AtributoCadastrarProduto;


public class CadProduto {
    
    
    
    public void cadProduto(AtributoCadastrarProduto acp) {
       Connection con = Conex.getConnection();
       PreparedStatement stmt = null;
          
     String sqlCode = "INSERT INTO produto(nome, codigo, codigo_personalizado, categoria, preco_custo, \n" +
"                    preco_venda, medida, detalhes, controla_estoque, estoque_min, estoque_atual)\n" +
"    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
       try {
           stmt = con.prepareStatement(sqlCode);
           stmt.setString(1, acp.getNome());
           stmt.setString(2, acp.getCodigo());
           stmt.setString(3, acp.getCodigoPersonalizado());
           stmt.setString(4, acp.getCategoria());
           stmt.setDouble(5, Double.parseDouble(acp.getPrecoCusto()));
           stmt.setDouble(6, Double.parseDouble(acp.getPrecoVenda()));
           stmt.setInt(7, acp.getMedida());
           stmt.setString(8, acp.getDetalhes());
           stmt.setBoolean(9, acp.isControlaEstoque());
           stmt.setDouble(10, Double.parseDouble(acp.getEstoqueMin()));
           stmt.setDouble(11, Double.parseDouble(acp.getEstoqueAtual()));
          
           stmt.executeUpdate();
           JOptionPane.showMessageDialog(null, "Produto Salvo com Sucesso.");
       } catch (SQLException ex) {
           Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    
    
    public ArrayList<AtributoCadastrarProduto> buscarProduto(String nome_ou_codigo){
        String sqlCode="";
        int num=0;                                 //janaina3
        if(nome_ou_codigo.length()==0){             //45675
         sqlCode="select * from produto order by nome";
        }else{
            for(int i=0;i<nome_ou_codigo.length();i++){
               if("0123456789".indexOf(nome_ou_codigo.charAt(i))!=-1) {
                num++;  
               }else{
                   break;
               }    
            }
           
            if(num==nome_ou_codigo.length()){
              sqlCode="select * from produto where id_produto = "+nome_ou_codigo;   
            }else{
              sqlCode="select * from produto where nome like '%"+nome_ou_codigo+"%' order by nome";   
            }
            
           
        }
        
       Connection con = Conex.getConnection();       
       PreparedStatement stmt = null;
       ResultSet rs = null;
       ArrayList<AtributoCadastrarProduto> produtos = new ArrayList();
       try {
           stmt = con.prepareStatement(sqlCode);
           rs = stmt.executeQuery();
           while(rs.next()){
             AtributoCadastrarProduto acp = new AtributoCadastrarProduto();  
             acp.setNome(rs.getString("nome"));
             acp.setCodigo(rs.getString("id_produto"));
             acp.setCodigoPersonalizado(rs.getString("codigo_personalizado"));
             acp.setCategoria(rs.getString("categoria"));
             acp.setMedida(rs.getInt("medida"));
             acp.setPrecoCusto(rs.getString("preco_custo"));
             acp.setPrecoVenda(rs.getString("preco_venda"));
             acp.setDetalhes(rs.getString("detalhes"));
             acp.setEstoqueAtual(rs.getString("estoque_atual"));
             acp.setEstoqueMin(rs.getString("estoque_min"));
             
             
             produtos.add(acp);
           }
       } catch (SQLException ex) {
           Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
       }
     return produtos;  
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
        
        
        
    
    
    
  

    public void excluirProduto(AtributoCadastrarProduto acp) {
       Connection con = Conex.getConnection();
       PreparedStatement stmt = null;
       try {
           stmt = con.prepareStatement("DELETE FROM produto WHERE id_produto = ? ");
           stmt.setInt(1, Integer.parseInt(acp.getCodigo()));
           stmt.executeUpdate();
           con.close();
           stmt.close();
           JOptionPane.showMessageDialog(null, "Produto Excluido com Sucesso.");
       } catch (SQLException ex) {
           Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
       }

    }

    
    
    
    
    
    
    
}
