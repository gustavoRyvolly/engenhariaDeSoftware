
package Formularios;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.bean.AtributoUsuario;
import model.dao.CadUsuario;
import model.dao.FazerLogin;


public class RedefinirSenha extends javax.swing.JDialog {
    private int idUsuario = -1;

    public RedefinirSenha(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(520, 350);
        
    }
    
    public void setUsuario(String usuario){
     txtUsuario.setText(usuario);
    }
    
     void setId_usuario(int idUsuario) {
         this.idUsuario = idUsuario;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pfNovaSenha = new javax.swing.JPasswordField();
        pfConfirmarNovaSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Redefinir Senha");
        setResizable(false);
        setSize(new java.awt.Dimension(300, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 52, 249, -1));

        jLabel5.setText("Nome de Usuário:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 55, -1, -1));

        jLabel2.setText("Nova Senha :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 117, -1, -1));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        btnSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalvarKeyPressed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 87, -1));

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, -1, -1));

        jLabel3.setText("Confirmar Senha:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 177, -1, -1));
        getContentPane().add(pfNovaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 114, 249, -1));
        getContentPane().add(pfConfirmarNovaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 174, 249, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       String NovaSenha = new String(pfNovaSenha.getPassword());
       String ConfNovaSenha = new String(pfConfirmarNovaSenha.getPassword());
        
     if(   !(txtUsuario.getText().equals("") || NovaSenha.equals("") || ConfNovaSenha.equals(""))   ){
         
      if(NovaSenha.equals(ConfNovaSenha)){ 
        AtributoUsuario acu = new AtributoUsuario();
        CadUsuario cadUsuario = new CadUsuario();
        FazerLogin fazerLogin = new FazerLogin();
        acu.setUsuario(txtUsuario.getText());
        acu.setSenha(NovaSenha);
        acu.setId(idUsuario);
        
       if(!fazerLogin.verificarExistenciaUsuario(acu)){
           cadUsuario.redefinirSenha(acu);
           this.dispose();
       }else{
           JOptionPane.showMessageDialog(null, "Já existe um usuário com esse nome!","Autenticacão",JOptionPane.ERROR_MESSAGE);
       }
        
      }else{
          JOptionPane.showMessageDialog(null, "Senhas não conferem!","Autenticacão",JOptionPane.ERROR_MESSAGE); 
      }       
     }else{
        JOptionPane.showMessageDialog(null, "Existe campos não preenchidos!","Autenticacão",JOptionPane.ERROR_MESSAGE); 
     }
        
        
        
        
        
        
        
        
        

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalvarKeyPressed

    }//GEN-LAST:event_btnSalvarKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();

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
            java.util.logging.Logger.getLogger(RedefinirSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RedefinirSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RedefinirSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RedefinirSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RedefinirSenha dialog = new RedefinirSenha(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    
    
    public static ImageIcon redefinir(int larg, int alt,ImageIcon i){
        return new ImageIcon(i.getImage().getScaledInstance(larg, alt, Image.SCALE_DEFAULT));
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField pfConfirmarNovaSenha;
    private javax.swing.JPasswordField pfNovaSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

   
}
