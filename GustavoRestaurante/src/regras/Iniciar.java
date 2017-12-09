
package regras;

import Formularios.FormLogin;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.Conex;
import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import model.dao.CadUsuario;



public class Iniciar {

    
    public static void main(String[] args) {
       
//       double capital =200000;
  //     double montante=0;
    //   double taxa=0.07;
      // double montanteDescontadoIR=0;     
       //montante = capital*Math.pow((1+taxa),20 );
       //montanteDescontadoIR = montante*(1-0.275);
       //System.out.println(montanteDescontadoIR);
       
      FormLogin log = new FormLogin();
      log.setLocationRelativeTo(log);
      log.setVisible(true);
      
    /*    
        double qtdComprado=6100;        
        double precoCompra=36700;
        double precoVenda=43000;        
        double transferencia=15;
        double taxaCompra=0.007;
        double taxaSaque=0.0199;
        double taxaCompraWestern=159;
        
        double montanteBruto = ((qtdComprado/precoCompra)-transferencia/precoCompra)*precoVenda ;
        
        montanteBruto=montanteBruto*(1-taxaCompra);//descontando taxa de compra
        
        double valorSacado = montanteBruto*(1-taxaSaque)-9;
        
        double lucro=valorSacado-qtdComprado;     
        
        
        
        
        System.out.println("montante e lucro : "+valorSacado+",   "+lucro);
        
        
      */  
        
        
        
        
    /*   salvar fotos no banco de dados
        
        CadUsuario cu = new CadUsuario();
        byte[] fotoEmByte = null;
        try {
               // fotoEmByte = cu.imageToByte("C:\\imagemTeste.jpg");
                fotoEmByte = cu.imageToByte("C:\\imagemTeste.jpg");
                Connection con = Conex.getConnection();
                PreparedStatement stmt = null;
                try {
                    stmt = con.prepareStatement("INSERT INTO fotos( imagem) VALUES (?)");
                    stmt.setBytes(1, fotoEmByte );
                    stmt.executeUpdate();
        } catch (SQLException  ex) {
            Logger.getLogger(CadUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
             } catch (IOException ex) {
            Logger.getLogger(Iniciar.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      
             Image img = new ImageIcon(fotoEmByte).getImage();
             
            
     */  
    
    
    
    
    
    
      // canvas.showImage(image);
        
            
            
            
            
            //    Date date = new Date();
            //  SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd H:m:s");
            //System.out.println(sdf.format(date));
            
            
            
            
            
            
            
            /*
            
            SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = new GregorianCalendar();
            Date d1 = new Date();
            

            try {
            d1 = fm.parse("2016-12-12");
            } catch (ParseException ex) {
            Logger.getLogger(Iniciar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            cal.setTime(d1);
            cal.add(Calendar.DAY_OF_MONTH, 20);
            System.out.println(fm.format(cal.getTime()));
            
            */
            
            
            
            
            
            
            
            
            //int dias=3;
            // Date data;
            
            //Calendar cal = 2016-12-12;
            // cal.setTime(data);
            // cal.add(Calendar.DAY_OF_MONTH, dias);
            
            // System.out.println(cal.getTime());
            
            
            
            
            
            
            
            //Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
            
            
            
            //FormatarBD fb = new FormatarBD();
            
            //  fb.setVisible(true);
            
            
            
            
            
            
            
            //  Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
            
            //  System.out.println(tela.getHeight()+" x "+tela.getWidth());
            
            
            
            
            
            
            /* CALCULAR DIFERENCA ENTRE QUALQUER DATA RESULTADO SAI EM DIAS
            Date date = new Date();
            SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            try {
            Date d2 = fm.parse(fm.format(date));
            Date d1 = fm.parse("2018-04-14");
            long dt = (d2.getTime() - d1.getTime())+3600000;
            long dias = (dt/86400000l);
            System.out.println(dias);
            } catch (ParseException ex) {
            Logger.getLogger(Iniciar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            */
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            //data atual - data prevista   =  +4 dias
            
            // System.out.println(fm.format(date));
            
            
            
            
            
            
            
            
            //System.out.println(" hoje e  um novo dia ");
            
            
            //       EmprestimoLivro ep = new EmprestimoLivro();
            //     ep.setLocationRelativeTo(ep);
            //   ep.setVisible(true);
            /*
            int contador=0;
            while ( true){
            
            System.out.println(contador);
            
            
            contador++;
            
            if(contador>100)break;
            
            
            
            }
            
            */
            
            
            
            
            /*
            Date date = new Date();
            
            SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy - H:m");
            
            System.out.println(fm.format(date));
            
            SimpleDateFormat fm1 = new SimpleDateFormat("dd");
            SimpleDateFormat fm2 = new SimpleDateFormat("MM");
            SimpleDateFormat fm3 = new SimpleDateFormat("yyyy");
            SimpleDateFormat fm4 = new SimpleDateFormat("H");
            SimpleDateFormat fm5 = new SimpleDateFormat("m");
            
            fm1.format(date);
            fm2.format(date);
            fm3.format(date);
            fm4.format(date);
            fm5.format(date);
            
            String data = "11/04/2017";
            System.out.println(data);
            
            */
            //data = 2016-12-12;
       
     


    }
    
}
