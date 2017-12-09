/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.bean.AtributoPedido;
import model.bean.AtributoCadastrarProduto;

/**
 *
 * @author gustavo rivolli
 */
public class CadPedido {
    
     public void cadproduto(AtributoPedido am) {
       Connection con = Conex.getConnection();
       PreparedStatement stmt = null;
       Date date = new Date();        
       java.sql.Date date1 = new java.sql.Date(date.getTime());
       String sqlCode = "INSERT INTO pedido(n_mesa, qtd_pessoa, observacao, id_cliente, status, data)VALUES (?, ?, ?, ?, ?, ?);";
       try {
           stmt = con.prepareStatement(sqlCode);
           stmt.setInt(1, Integer.parseInt(am.getMesa()));
           stmt.setInt(2, Integer.parseInt(am.getQtdPessoa()));
           stmt.setString(3, am.getObservacao());
           stmt.setInt(4, Integer.parseInt(am.getId_cliente()));
           stmt.setString(5,"aberto");
           stmt.setDate(6, date1);
           stmt.executeUpdate();
           con.close();stmt.close();
           cadListaProduto(am);
           JOptionPane.showMessageDialog(null, "pedido Salvo com Sucesso.");
       } catch (SQLException ex) {
           Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
     
    private void cadListaProduto(AtributoPedido am) {
       Connection con = Conex.getConnection();
       PreparedStatement stmt = null;
       String sqlCode = "INSERT INTO pedido_tem_produto(qtd, id_produto, id_pedido)VALUES (?, ?, ?)";
         try {
             for(int i=0;i<am.produtos.size();i++){
              stmt = con.prepareStatement(sqlCode);
              stmt.setInt(1, Integer.parseInt(am.produtos.get(i).getQtd()));
              stmt.setInt(2, Integer.parseInt(am.produtos.get(i).getCodigo()));
              stmt.setInt(3, Integer.parseInt(am.produtos.get(i).getId_pedido()));
              stmt.executeUpdate();
             }
            con.close();stmt.close();
         } catch (SQLException ex) {
             Logger.getLogger(CadPedido.class.getName()).log(Level.SEVERE, null, ex);
         }
       
        
    }
     
     
     
     
     
     
     
     
     
     
     
     public String getNumeroPedido(){
       Connection con = Conex.getConnection();       
       PreparedStatement stmt = null;
       ResultSet rs = null;
       int numeroPedido=0;     
         try {
             stmt = con.prepareStatement("select max(id_pedido) from pedido");
             rs = stmt.executeQuery();
             rs.next();
             numeroPedido = rs.getInt("max");
            
             
             
         } catch (SQLException ex) {
             Logger.getLogger(CadPedido.class.getName()).log(Level.SEVERE, null, ex);
         }
           
        return String.valueOf(numeroPedido);   
     }

     public ArrayList<AtributoPedido> getDeterminadoPedido(String id_pedido){
       Connection con = Conex.getConnection();       
       PreparedStatement stmt = null;
       ResultSet rs = null;
       String sqlCode="select produto.id_produto, nome, qtd, preco_venda from pedido_tem_produto join produto\n" +
                        "on produto.id_produto = pedido_tem_produto.id_produto\n" +
                        "where id_pedido ="+id_pedido;
         ArrayList<AtributoPedido> produtos = new ArrayList();
         AtributoPedido am = new AtributoPedido();
         try {
             stmt = con.prepareStatement(sqlCode);
             rs = stmt.executeQuery();
             while(rs.next()){
                 am.setId_produto(String.valueOf(rs.getInt("id_produto")));
                 am.setNomeProduto(rs.getString("nome"));
                 am.setQtdProduto(String.valueOf(rs.getInt("qtd")));
                 am.setPrecoVenda(rs.getString("preco_venda"));
                 produtos.add(am);
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(CadPedido.class.getName()).log(Level.SEVERE, null, ex);
         }
           
        return produtos;   
     }
  
     
     
     public ArrayList<AtributoPedido> getPedidoResumo(String nome){
       Connection con = Conex.getConnection();       
       PreparedStatement stmt = null;
       ResultSet rs = null;
      /* String sqlCode="select x.status, x.n_mesa,x.nome,y.sum, x.id_pedido from\n" +
                        "(select p.status, p.n_mesa,c.nome,p.id_pedido from pedido p join cliente c\n" +
                        "on p.id_cliente = c.id_cliente) as x join\n" +
                        "(select  pp.id_pedido,sum(pp.qtd*p.preco_venda) from pedido_tem_produto pp join produto p\n" +
                        "on p.id_produto = pp.id_produto\n" +
                        "group by pp.id_pedido) as y\n" +
                        "on x.id_pedido = y.id_pedido where x.status= 'aberto'";*/
       
       
       String sqlCode2="select x.status, x.n_mesa,x.nome,y.sum, x.id_pedido from(select p.status, p.n_mesa,c.nome,p.id_pedido from pedido p join cliente c \n" +
                        "on p.id_cliente = c.id_cliente) as x join (select  pp.id_pedido,sum(pp.qtd*p.preco_venda) from pedido_tem_produto pp join produto p\n" +
                        "                        on p.id_produto = pp.id_produto group by pp.id_pedido) as y on x.id_pedido = y.id_pedido\n" +
                        "                        where x.nome like '"+nome+"%' and x.status = 'aberto' order by x.n_mesa";
       
         ArrayList<AtributoPedido> produtos = new ArrayList();
         
         try {
             stmt = con.prepareStatement(sqlCode2);
             rs = stmt.executeQuery();
             while(rs.next()){
                 AtributoPedido am = new AtributoPedido();
                 am.setMesa(String.valueOf(rs.getInt("n_mesa")));
                 am.setCliente(rs.getString("nome"));
                 am.setConsumo(String.valueOf(rs.getInt("sum")));
                 am.setId_pedido(String.valueOf(rs.getInt("id_pedido")));
                 produtos.add(am);
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(CadPedido.class.getName()).log(Level.SEVERE, null, ex);
         }
           
        return produtos;   
     }
     
     
     
     
     public AtributoPedido getpedido(String id_pedido){
       AtributoPedido am = new AtributoPedido();//vai ficar todo o conteudo do pedido
       ArrayList<AtributoCadastrarProduto> produtos = new ArrayList(); // vai carregar apenas a lista de produto
       Connection con = Conex.getConnection();
       PreparedStatement stmt = null;
       ResultSet rs = null;
       String sqlCodeInformacaoSobrePedido="select c.nome, p.n_mesa, p.qtd_pessoa,p.observacao from pedido p join cliente c\n" +
                                        "on  c.id_cliente = p.id_cliente where p.id_pedido ="+id_pedido;
       String sqlCodeListaProduto ="select pp.id_produto, p.nome, pp.qtd, p.preco_venda, (pp.qtd*p.preco_venda) as subtotal  from pedido_tem_produto pp join produto p\n" +
                                    "on pp.id_produto = p.id_produto where pp.id_pedido ="+id_pedido;
         try {
             //xxxxxxxxxxxx busca dados do pedido xxxxxxxxxxxxxxxxx
             stmt = con.prepareStatement(sqlCodeInformacaoSobrePedido);
             rs = stmt.executeQuery();
             while(rs.next()){
                 
                 am.setCliente(rs.getString("nome"));
                 am.setMesa(String.valueOf(rs.getInt("n_mesa")));
                 am.setQtdPessoa(rs.getString("qtd_pessoa"));
                 am.setObservacao(rs.getString("observacao"));
             }
             
             //xxxxxxxxxxxxxxx busca oss protudos do pedido xxxxxxxxxxxxxxxxxx
             stmt = con.prepareStatement(sqlCodeListaProduto);
             rs = stmt.executeQuery();
             while(rs.next()){
                 AtributoCadastrarProduto acp = new AtributoCadastrarProduto();
                 acp.setCodigo(rs.getString("id_produto"));
                 acp.setNome(rs.getString("nome"));
                 acp.setQtd(rs.getString("qtd"));
                 acp.setPrecoVenda(rs.getString("preco_venda"));
                 produtos.add(acp);
                 am.produtos.add(acp);
                 
             }
             con.close();stmt.close();rs.close();
         } catch (SQLException ex) {
             Logger.getLogger(CadPedido.class.getName()).log(Level.SEVERE, null, ex);
         }
        return am;   
     }
     
      public void pagarPedido(String id_pedido) {
       Connection con = Conex.getConnection();
       PreparedStatement stmt = null;
       String sqlCode = "update pedido set status = 'pago' where id_pedido="+id_pedido;
       try {
           stmt = con.prepareStatement(sqlCode);
           stmt.executeUpdate();
           con.close();stmt.close();
           JOptionPane.showMessageDialog(null, "Pagamento efetuado com sucesso");
       } catch (SQLException ex) {
           Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
     
     
     
    
    
    
    
    
}
