/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.bean.AtributoUsuario;
import model.bean.AtributoLogin;
import model.dao.FazerLogin;

/**
 *
 * @author gustavo rivolli
 */
public class FormLogin extends javax.swing.JFrame {

    /**
     * Creates new form FormLogin
     */
    public FormLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSenha = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Autenticação");
        getContentPane().setLayout(null);
        getContentPane().add(txtSenha);
        txtSenha.setBounds(160, 150, 220, 26);
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(160, 90, 220, 26);

        jLabel1.setText("Usuário");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 90, 60, 20);

        jLabel2.setText("Senha");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 150, 50, 20);

        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(210, 240, 70, 29);

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(300, 240, 75, 29);

        lblLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundotelaLogin.png"))); // NOI18N
        getContentPane().add(lblLogin);
        lblLogin.setBounds(0, 0, 500, 370);

        setBounds(0, 0, 522, 376);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AtributoUsuario acu = new AtributoUsuario();
        acu.setUsuario(txtUsuario.getText());
        acu.setSenha(new String(txtSenha.getPassword()));
        FazerLogin fl = new FazerLogin(); 
        
        if(fl.getAutenticationUser(acu) == true){
           
            
            if(fl.getusuario().getSituacao().equals(acu.Desativado())){
                RedefinirSenha red = new RedefinirSenha(this, true);
                red.setUsuario(txtUsuario.getText());
               // red.setId_usuario(fl.getId_usuario());
                red.setId_usuario(fl.getusuario().getId());
                red.setLocationRelativeTo(red);
                red.setVisible(true);
                txtSenha.setText("");
                txtUsuario.setText("");
            }else{
                //if(fl.getSituacao().equals(acu.getAtivar())){
                if(fl.getusuario().getSituacao().equals(acu.Ativado())){
                    FormPrincipal ep = new FormPrincipal();
                    ep.setUsuario(fl.getusuario());
                    ep.setVisible(true);
                    this.dispose();
                }
            }
           
        }else{
            JOptionPane.showMessageDialog(null, "Senha ou Usuário inválidos!","Autenticacão",JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        
       // RedefinirSenha red = new RedefinirSenha(this, true);
        //red.setUsuario(txtUsuario.getText());
        //red.setLocationRelativeTo(red);
        //red.setVisible(true);
      
        
/*        
        if(txtUsuario.getText().equals("glr")&& txtSenha.getText().equals("123")){
        FormPrincipal ep = new FormPrincipal();
         //ep.setLocationRelativeTo(ep);
         ep.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Senha ou usuário inválido!");
        }
*/
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);


    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}