/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;


import Formularios.*;
import regras.*;
import connection.Conex;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.bean.AtributoUsuario;
import model.dao.CadUsuario;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author gustavo rivolli
 */
public class CadastroUsuario extends javax.swing.JInternalFrame {
    JLabel label;
    DefaultTableModel modTabela;
    static BufferedImage buff;
    private byte[] fotoEmByte=null;
    ArrayList<byte[]> Arrayfotos = new ArrayList();
    
   
    public CadastroUsuario() {
        initComponents();
        modTabela = (DefaultTableModel)tabelaUsuario.getModel();
        carregarTabela();
        btnAtivar.setEnabled(false);
        btnBloquear.setEnabled(false);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
       
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuario = new javax.swing.JTable();
        txtUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblAdicionarFoto = new javax.swing.JLabel();
        cbxNivelAcesso = new javax.swing.JComboBox<>();
        pfSenha = new javax.swing.JPasswordField();
        btnBloquear = new javax.swing.JButton();
        btnAtivar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cadastrar Usuário");

        jLabel1.setText("Nome:");

        jLabel2.setText("Senha:");

        jLabel3.setText("Email:");

        jLabel4.setText("Nivel Acesso:");

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

        tabelaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sel.", "id", "Usuário", "Nome", "Email", "Nivel Acesso", "Situaçao"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaUsuarioMouseClicked(evt);
            }
        });
        tabelaUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaUsuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaUsuarioKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaUsuario);
        if (tabelaUsuario.getColumnModel().getColumnCount() > 0) {
            tabelaUsuario.getColumnModel().getColumn(0).setMinWidth(50);
            tabelaUsuario.getColumnModel().getColumn(0).setPreferredWidth(80);
            tabelaUsuario.getColumnModel().getColumn(0).setMaxWidth(100);
            tabelaUsuario.getColumnModel().getColumn(1).setMinWidth(40);
            tabelaUsuario.getColumnModel().getColumn(1).setPreferredWidth(40);
            tabelaUsuario.getColumnModel().getColumn(1).setMaxWidth(40);
        }

        jLabel5.setText("Usuário:");

        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        lblAdicionarFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdicionarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadPacientes.png"))); // NOI18N
        lblAdicionarFoto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAdicionarFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAdicionarFoto.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblAdicionarFotoMouseMoved(evt);
            }
        });
        lblAdicionarFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAdicionarFotoMouseClicked(evt);
            }
        });

        cbxNivelAcesso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Administrador", "Usuário" }));

        btnAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtivarActionPerformed(evt);
            }
        });

        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxNivelAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAdicionarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnExcluir)
                            .addComponent(btnEditar)
                            .addComponent(btnAtivar)
                            .addComponent(btnBloquear))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbxNivelAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblAdicionarFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btnAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(btnBloquear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        CadUsuario cadUsuario = new CadUsuario();
        AtributoUsuario acu = new AtributoUsuario();
        acu.setNome(txtNome.getText());
        acu.setUsuario(txtUsuario.getText());      
        acu.setSenha(new String(pfSenha.getPassword()));
        acu.setEmail(txtEmail.getText());
        acu.setPrivilegio(cbxNivelAcesso.getSelectedItem().toString());
        acu.setFotoEmByte(fotoEmByte);
        
        cadUsuario.inserirDados(acu);
        JOptionPane.showMessageDialog(null, "Salvo com sucesso");
       
        //"imgsalva/img1.jpg"
        
        txtNome.setText("");
        pfSenha.setText("");
        txtEmail.setText("");
        txtUsuario.setText("");
        cbxNivelAcesso.setSelectedIndex(0);
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/cadPacientes.png"));
        lblAdicionarFoto.setIcon(icon);
        carregarTabela();
        
            /*
            AtributoUsuario acu = new AtributoUsuario(txtNome.getText(), txtSenha.getText(), txtEmail.getText(), txtNivelAcesso.getText());
            CadUsuario cadUsuario = new CadUsuario();
            cadUsuario.inserirDados(acu);
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso:");
            
            txtNome.setText("");
            txtSenha.setText("");
            txtEmail.setText("");
            txtNivelAcesso.setText("");
            */
       
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void lblAdicionarFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdicionarFotoMouseClicked
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Procurar arquivo");
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("imagem", "jpg","png","bmp");
        jfc.setFileFilter(filter);
        int retorno = jfc.showOpenDialog(this);
        
        if(retorno == JFileChooser.APPROVE_OPTION){                     //ImageIcon icon = new ImageIcon(file.getPath());
                File file = jfc.getSelectedFile();                        // Image img = icon.getImage();
                file.getPath();
                //System.out.println("get path : "+file.getPath());
          
              try {  
                    buff = ImageIO.read(new File(file.getPath()));
                    Graphics g = lblAdicionarFoto.getGraphics();
                    g.drawImage(buff, 0, 0, lblAdicionarFoto.getWidth(), lblAdicionarFoto.getHeight(), null);
                    InputStream is = null;
                    is = new FileInputStream(file);
                    fotoEmByte = new byte[is.available()];
                    is.read(fotoEmByte);
                    is.close();
            } catch (FileNotFoundException  ex ) {
                Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
        
       
        
        
        
        
        

     
    }//GEN-LAST:event_lblAdicionarFotoMouseClicked

    private void lblAdicionarFotoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdicionarFotoMouseMoved
    
    }//GEN-LAST:event_lblAdicionarFotoMouseMoved

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
    AtributoUsuario acu = new AtributoUsuario();
    CadUsuario cu = new CadUsuario();
    int linha=0;
    while(linha < modTabela.getRowCount()){
      if(modTabela.getValueAt(linha, 0).equals(true)){
          acu.setId((int)modTabela.getValueAt(linha, 1));
          cu.deletar(acu);
      }
      linha++;
    }
        carregarTabela();
        ativarBotoes();
        
        
   /*     
    int linha=0;
    while(linha < modTabela.getRowCount()){
      if(modTabela.getValueAt(linha, 0).equals(true)){
         modTabela.removeRow(linha);
         
      }else{
         linha++;  
      }
    }
*/
      
       



    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tabelaUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaUsuarioKeyPressed
           




    }//GEN-LAST:event_tabelaUsuarioKeyPressed

    private void btnSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalvarKeyPressed
         
        
        
    }//GEN-LAST:event_btnSalvarKeyPressed

    private void tabelaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaUsuarioMouseClicked
        ativarBotoes();
        carregarImagem();
        System.out.println(tabelaUsuario.getSelectedRow());
        

    }//GEN-LAST:event_tabelaUsuarioMouseClicked

    private void btnAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtivarActionPerformed
        AtributoUsuario acu = new AtributoUsuario();
        CadUsuario cadUsuario = new CadUsuario();
        
        int linhaSelecionada =-1;
        int linha=0;
        while(linha < modTabela.getRowCount()){
            if(modTabela.getValueAt(linha, 0).equals(true)){
              linhaSelecionada = linha;
          }
          linha++; 
        }
        int id = Integer.parseInt(modTabela.getValueAt(linhaSelecionada, 1).toString());
        String situacao = modTabela.getValueAt(linhaSelecionada, 6).toString();
        
        if(situacao.equals(acu.Ativado())){
            acu.setId(id);
            acu.setSituacao(acu.Desativado());
        }
        if(situacao.equals(acu.Desativado())){
            acu.setId(id);
            acu.setSituacao(acu.Ativado());
        }
        
        cadUsuario.AtivarDesativar(acu);
        carregarTabela();
        ativarBotoes();
        
        
        





    }//GEN-LAST:event_btnAtivarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        txtNome.setText(modTabela.getValueAt(tabelaUsuario.getSelectedRow(), 3).toString());
        txtUsuario.setText(modTabela.getValueAt(tabelaUsuario.getSelectedRow(), 2).toString());
        txtEmail.setText(modTabela.getValueAt(tabelaUsuario.getSelectedRow(), 4).toString());
        pfSenha.setText("");
        cbxNivelAcesso.setSelectedIndex(0);
        


    }//GEN-LAST:event_btnEditarActionPerformed

    private void tabelaUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaUsuarioKeyReleased


            carregarImagem(); 
            System.out.println(tabelaUsuario.getSelectedRow());







    }//GEN-LAST:event_tabelaUsuarioKeyReleased

    
    
    public void carregarTabela(){
        DefaultTableModel modelo = (DefaultTableModel) tabelaUsuario.getModel();
        modelo.setNumRows(0);
        Arrayfotos.clear();
        CadUsuario cadUsuario = new CadUsuario();
       
        for(AtributoUsuario atr: cadUsuario.getUsuarios()){
            modelo.addRow(new Object[]{
                false,
                atr.getId(), 
                atr.getUsuario(),
                atr.getNome(),                
                atr.getEmail(),               
                atr.getPrivilegio(),
                atr.getSituacao()
                
        });
            
        Arrayfotos.add(atr.getFotoEmByte());//carrega as fotos de todos usuarios
            
        }
    }
    
    
     public void carregarImagem(){
       if(Arrayfotos.get(tabelaUsuario.getSelectedRow())!=null){
            Image img = new ImageIcon(Arrayfotos.get(tabelaUsuario.getSelectedRow())).getImage();
            Graphics g = lblAdicionarFoto.getGraphics();
            g.drawImage(img, 0, 0, lblAdicionarFoto.getWidth(), lblAdicionarFoto.getHeight(), null);
        }else{
           ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/cadPacientes.png"));
           lblAdicionarFoto.setIcon(icon);
        }  
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtivar;
    private javax.swing.JButton btnBloquear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxNivelAcesso;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdicionarFoto;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JTable tabelaUsuario;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables



public void ativarBotoes(){
    int linhaSelecionada =-1;
    int qtdSelecionada =0;
    int linha=0;
    
    
    while(linha < modTabela.getRowCount()){
      
        if(modTabela.getValueAt(linha, 0).equals(true)){
          linhaSelecionada = linha;
          qtdSelecionada++;
      }
      linha++; 
    }


    if(linhaSelecionada!=-1){
        btnExcluir.setEnabled(true);
        btnExcluir.setText("Excluir");
        
       if(qtdSelecionada==1){
        if(modTabela.getValueAt(linhaSelecionada, 6).toString().equals(new AtributoUsuario().Ativado())){
            btnAtivar.setText("Desativar");
            btnAtivar.setEnabled(true);  
            
            btnBloquear.setText("bloquear");
            btnBloquear.setEnabled(true); 
            btnEditar.setText("Editar"); 
            btnEditar.setEnabled(true);
            
        }
        
         if(modTabela.getValueAt(linhaSelecionada, 6).toString().equals(new AtributoUsuario().Desativado() )){
            btnAtivar.setText("Ativar");
            btnAtivar.setEnabled(true); 
            
            btnBloquear.setText("bloquear");
            btnBloquear.setEnabled(true); 
        }
         
        if(modTabela.getValueAt(linhaSelecionada, 6).toString().equals(new AtributoUsuario().Desativado() )){
            btnBloquear.setText("Desbloquear");
            btnBloquear.setEnabled(true); 
            
            btnAtivar.setText("Ativar");
            btnAtivar.setEnabled(true); 
        }
        
        
        }else{
        btnAtivar.setEnabled(false);
        btnAtivar.setText("");
        btnBloquear.setEnabled(false);
        btnBloquear.setText("");
        btnEditar.setEnabled(false);
        btnEditar.setText("");
       
           
        }
    }else{
        btnAtivar.setEnabled(false);
        btnAtivar.setText("");
        btnBloquear.setEnabled(false);
        btnBloquear.setText("");
        btnEditar.setEnabled(false);
        btnEditar.setText("");
        btnExcluir.setEnabled(false);
        btnExcluir.setText("");
        
    }
    
    
}








}
