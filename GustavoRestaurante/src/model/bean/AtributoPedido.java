
package model.bean;

import java.util.ArrayList;


public class AtributoPedido {
   private String mesa; 
   private String cliente; 
   private String status; 
   private String consumo; 
   private String id_cliente; 
   private String id_produto; 
   private String id_pedido; 
   private String qtdPessoa; 
   private String qtdProduto; 
   private String nomeProduto;
   private String PrecoVenda;
   private String observacao;
   
   
   
   public ArrayList<AtributoCadastrarProduto> produtos = new ArrayList<>();
    
   
   
   
   

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }
   
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
   

    public String getPrecoVenda() {
        return PrecoVenda;
    }

    public void setPrecoVenda(String PrecoVenda) {
        this.PrecoVenda = PrecoVenda;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getId_produto() {
        return id_produto;
    }

    public void setId_produto(String id_produto) {
        this.id_produto = id_produto;
    }

    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getQtdPessoa() {
        return qtdPessoa;
    }

    public void setQtdPessoa(String qtdPessoa) {
        this.qtdPessoa = qtdPessoa;
    }

    public String getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(String qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

  

    public String getMesa() {
        return mesa;
    }
     

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String clente) {
        this.cliente = clente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }
  
    
}
