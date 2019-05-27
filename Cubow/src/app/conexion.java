package app;

import com.mysql.jdbc.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class conexion extends javax.swing.JFrame {

    static PreparedStatement prepareStatement(String select__from_scores) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
            
    public conexion() {
        
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Conexión a Cubow");
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        btnComprobar = new javax.swing.JButton();
        labelSmile = new javax.swing.JLabel();
        textSmile = new javax.swing.JTextField();
        textMeh = new javax.swing.JTextField();
        textSad = new javax.swing.JTextField();
        labelMeh = new javax.swing.JLabel();
        labelSad = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnComprobar.setText("Comprobar");
        btnComprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprobarActionPerformed(evt);
            }
        });

        labelSmile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/smile.png"))); // NOI18N

        textSad.setRequestFocusEnabled(false);

        labelMeh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/meh.png"))); // NOI18N

        labelSad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sad.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(labelSmile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textSmile, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(labelMeh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textMeh, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(labelSad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textSad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(btnComprobar)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSmile)
                    .addComponent(textSmile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMeh)
                    .addComponent(textMeh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSad)
                    .addComponent(textSad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(btnComprobar)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprobarActionPerformed
       
        try{
            //Se crea una conexión con la base de datos utilizando la función conectar
            Connection conexion = null;
            conexion = conectar();
            //Se prepara la consulta
            PreparedStatement consulta;
            ResultSet resultado;
            consulta = conexion.prepareStatement("SELECT COUNT(id) as suma, score FROM scores GROUP BY score");
            resultado = consulta.executeQuery();
            //Mientras haya algo dentro de resultado
            while (resultado.next()) {
                //Se guarda en una variable el id
                int id = resultado.getInt("score");
                //Se guarda en una variable la suma
                int suma = resultado.getInt("suma");
                //Si el id es 1 (Sad) se muestra la suma en el textField de Sad
                if (id == 1){
                    textSad.setText(String.valueOf(suma));
                }
                //Si el id es 2 (Meh) se muestra la suma en el textField de Meh
                if (id == 2){
                   textMeh.setText(String.valueOf(suma)); 
                }
                //Si el id es 3 (Sad) se muestra la suma en el textField de Smile
                if (id == 3){
                    textSmile.setText(String.valueOf(suma));
                    
                }
            }
                   
        }catch (Exception e){
             System.out.println(e);  
             JOptionPane.showMessageDialog(null,e);
        }
        //Se cierra la conexión
        conexion.close();
    }//GEN-LAST:event_btnComprobarActionPerformed
    
    //Función que establece la conexión con la base de datos
    public Connection conectar(){
    
        Connection conexion = null;
        //Datos de la base de datos
        String url = "jdbc:mysql://cubow.es:3306/c7cubow";
        String user = "c7cubow";
        String pass = "2E!4VdUpv";
        
        try{
            //Establezco la conexión utilizando las variables con los datos
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, user, pass);
            
        //Si no se puede conectar muestro un mensaje por consola y una pantalla de error
        }catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Imposible conectar");
        }
        
        //Devuelvo la conexión
        return conexion;
    }
    
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
            java.util.logging.Logger.getLogger(conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(conexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new conexion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprobar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel labelMeh;
    private javax.swing.JLabel labelSad;
    private javax.swing.JLabel labelSmile;
    private javax.swing.JTextField textMeh;
    private javax.swing.JTextField textSad;
    private javax.swing.JTextField textSmile;
    // End of variables declaration//GEN-END:variables

    private void SetTitle(String conexión_a_Cubow) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
