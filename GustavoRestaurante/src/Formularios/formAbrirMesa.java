/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.Event;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.AtributoPedido;
import model.bean.AtributoCadastrarProduto;
import model.dao.CadPedido;
import model.dao.CadProduto;

/**
 *
 * @author gustavo rivolli
 */
public class formAbrirMesa extends javax.swing.JFrame {
    private form_Pedido_ou_mesa pedido_ou_mesa;
    private String id_cliente;
    DefaultTableModel modelo;
    /**
     * Creates new form formAbrirMesa
     */
    public formAbrirMesa() {
        initComponents();
        lblNpedido.setText(new CadPedido().getNumeroPedido());
        modelo = (DefaultTableModel)tabela.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMesa = new javax.swing.JTextField();
        txtNumPessoa = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaObservacao = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblNpedido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AbrirMesa");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 133, 59, -1));
        getContentPane().add(txtNumPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 133, 47, -1));
        getContentPane().add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 63, 234, -1));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Qtd", "Preço", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setResizable(false);
            tabela.getColumnModel().getColumn(1).setResizable(false);
            tabela.getColumnModel().getColumn(2).setResizable(false);
            tabela.getColumnModel().getColumn(3).setResizable(false);
            tabela.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 63, 639, 468));

        jButton1.setText("Localizar Produto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(847, 20, -1, -1));

        jLabel1.setText("Mesa/Comanda:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 133, -1, -1));

        jLabel2.setText("Observação:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 206, -1, -1));

        txaObservacao.setColumns(20);
        txaObservacao.setRows(5);
        jScrollPane2.setViewportView(txaObservacao);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 206, 238, -1));

        jLabel3.setText("Nº Pessoas:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 136, -1, -1));

        jButton2.setText("Pagamento");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(895, 564, -1, -1));

        jButton3.setText("Imprimir");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(751, 564, -1, -1));

        jLabel4.setText("Cliente:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 66, -1, -1));

        jButton4.setText("...");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 63, 25, 26));

        jLabel5.setText("Subtotal:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 330, -1, -1));

        jLabel6.setText("Total:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        txtSubtotal.setEditable(false);
        getContentPane().add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 327, 240, -1));

        txtTotal.setEditable(false);
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 410, 240, -1));

        jButton5.setText("Salvar Pedido");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, -1, -1));

        jLabel7.setText("Nº Pedido:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 25, -1, -1));

        lblNpedido.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lblNpedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblNpedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 25, 99, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FormAdicionarProduto pp = new FormAdicionarProduto();
        pp.setObjeto(this);
        pp.setLocationRelativeTo(pp);
        pp.setVisible(true);


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
        
        formPesquisarCliente pc = new formPesquisarCliente();
        pc.setObjeto(this);
        pc.setLocationRelativeTo(pc);
        pc.setVisible(true);




    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel)tabela.getModel();
        CadPedido pedido = new CadPedido();
        AtributoPedido aa = new AtributoPedido();
       
        
      if(modelo.getRowCount()>0&& txtMesa.getText().length()!=0&&txtNumPessoa.getText().length()!=0)  {
        for(int i=0;i<tabela.getRowCount();i++){  // faz uma lista de produtos pertencentes ao pedido
            AtributoCadastrarProduto acp = new AtributoCadastrarProduto();
            acp.setCodigo(tabela.getValueAt(i, 0).toString());
            acp.setQtd(tabela.getValueAt(i, 2).toString());
            acp.setId_pedido(lblNpedido.getText());
            aa.produtos.add(acp);
        }
        aa.setId_pedido(lblNpedido.getText());
        aa.setId_cliente(id_cliente);
        aa.setMesa(txtMesa.getText());
        aa.setQtdPessoa(txtNumPessoa.getText());
        aa.setObservacao(txaObservacao.getText());
        pedido.cadproduto(aa); //  faz o cadastramento de todas informaçoes do pedido 
        pedido_ou_mesa.carregarPedidosAbertos();// carrega o formulario anterior com todos pedidos abertos
        lblNpedido.setText(new CadPedido().getNumeroPedido());// carrega o numero do novo pedido
        
        txtCliente.setText("");
        txtMesa.setText("");
        txaObservacao.setText("");
        txtNumPessoa.setText("");
        txtSubtotal.setText("");
        txtTotal.setText("");
        modelo.setNumRows(0);
      }else{
          JOptionPane.showMessageDialog(null, "Pedido não Completo");
      }
        
        
        

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new CadPedido().pagarPedido(lblNpedido.getText());
        limparTela();
        pedido_ou_mesa.carregarPedidosAbertos();
        


    }//GEN-LAST:event_jButton2ActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formAbrirMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formAbrirMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formAbrirMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formAbrirMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formAbrirMesa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNpedido;
    private javax.swing.JTable tabela;
    private javax.swing.JTextArea txaObservacao;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtMesa;
    private javax.swing.JTextField txtNumPessoa;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

public void setCliente(String id_cliente, String nome){
    txtCliente.setText(nome);
    this.id_cliente=id_cliente;
}

void setProduto(AtributoCadastrarProduto produto) {
    modelo.addRow(new Object[]{
        produto.getCodigo(),
        produto.getNome(),
        produto.getQtd(),
        produto.getPrecoVenda()
    });
    fazerCalculoTabela();
}

    void setPedido_ou_mesa(form_Pedido_ou_mesa aThis) {
        pedido_ou_mesa = aThis;
    }
    
    
    public String getNumPedido(){//informa numero pedido
        return lblNpedido.getText();
    }



    void setId_pedido(String id_pedido) {
        CadPedido cadPedido = new CadPedido();
        AtributoPedido pedidoListaProduto = cadPedido.getpedido(id_pedido);
        lblNpedido.setText(id_pedido);
        txtCliente.setText(pedidoListaProduto.getCliente());
        txtMesa.setText(pedidoListaProduto.getMesa());
        txtNumPessoa.setText(pedidoListaProduto.getQtdPessoa());
        txaObservacao.setText(pedidoListaProduto.getObservacao());
        for(AtributoCadastrarProduto acp: pedidoListaProduto.produtos){
            modelo.addRow(new Object[]{
            acp.getCodigo(),
            acp.getNome(),
            acp.getQtd(),
            acp.getPrecoVenda()
           
             });
        }
        fazerCalculoTabela();
    }
    
    
    
    public void fazerCalculoTabela(){
        double total=0;
        if(tabela.getRowCount()!=-1){
           for(int i=0;i<tabela.getRowCount();i++){
              double qtd = Double.parseDouble(tabela.getValueAt(i, 2).toString());
              double preco = Double.parseDouble(tabela.getValueAt(i, 3).toString());
              double subtotal = qtd*preco;
              total+=subtotal;
              modelo.setValueAt(String.valueOf(subtotal), i, 4);
           } 
           txtTotal.setText(String.valueOf(total));
        }
    }
    
    
    public void limparTela(){
        txtCliente.setText("");
        txtMesa.setText("");
        txaObservacao.setText("");
        txtNumPessoa.setText("");
        txtSubtotal.setText("");
        txtTotal.setText("");
        modelo.setNumRows(0);
    }

    

}