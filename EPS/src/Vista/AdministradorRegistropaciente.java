package Vista;


import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author juanp
 */
public class AdministradorRegistropaciente extends javax.swing.JInternalFrame {

    public JButton getBotonGuardarpaciente() {
        return botonGuardarpaciente;
    }

    public JTextField getTxt_Nombrepaciente() {
        return txt_Nombrepaciente;
    }

    public JTextField getTxt_direccionpaciente() {
        return txt_direccionpaciente;
    }

    public JTextField getTxt_estratopaciente() {
        return txt_estratopaciente;
    }

    public JTextField getTxt_fechanacimientopaciente() {
        return txt_fechanacimientopaciente;
    }

    public JTextField getTxt_identficacionpaciente() {
        return txt_identficacionpaciente;
    }

    public JTextField getTxt_lugardenacimientopaciente() {
        return txt_lugardenacimientopaciente;
    }

    public JTextField getTxt_sedepaciente() {
        return txt_telefonopaciente;
    }

    public JTextField getTxt_correoelectronico() {
        return txt_correoelectronico;
    }

    public JTextField getTxt_telefonopaciente() {
        return txt_telefonopaciente;
    }


    

    public AdministradorRegistropaciente() {
        initComponents();
        this.setSize(new Dimension(400, 300));
        this.setTitle("Nuevo Medico");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_Nombrepaciente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_direccionpaciente = new javax.swing.JTextField();
        txt_lugardenacimientopaciente = new javax.swing.JTextField();
        txt_fechanacimientopaciente = new javax.swing.JTextField();
        txt_identficacionpaciente = new javax.swing.JTextField();
        txt_estratopaciente = new javax.swing.JTextField();
        txt_telefonopaciente = new javax.swing.JTextField();
        txt_sedepaciente = new javax.swing.JTextField();
        txt_correoelectronico = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        botonGuardarpaciente = new javax.swing.JButton();
        WallPaper = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nuevo Paciente");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 160, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        getContentPane().add(txt_Nombrepaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 130, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Identificacion");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 20));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Lugar de nacimento");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 110, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Direccion");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha de nacimiento");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Telefono");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 110, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Sede");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 70, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Correo Electronico");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 110, -1));
        getContentPane().add(txt_direccionpaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 130, -1));
        getContentPane().add(txt_lugardenacimientopaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 130, -1));
        getContentPane().add(txt_fechanacimientopaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 130, -1));
        getContentPane().add(txt_identficacionpaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 130, -1));
        getContentPane().add(txt_estratopaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 130, -1));
        getContentPane().add(txt_telefonopaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 130, -1));
        getContentPane().add(txt_sedepaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 130, -1));
        getContentPane().add(txt_correoelectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 130, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Estrato");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 70, -1));

        botonGuardarpaciente.setBackground(new java.awt.Color(0, 204, 0));
        botonGuardarpaciente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonGuardarpaciente.setText("Guardar");
        botonGuardarpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarpacienteActionPerformed(evt);
            }
        });
        getContentPane().add(botonGuardarpaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        WallPaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imag/3409297.jpg"))); // NOI18N
        getContentPane().add(WallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 340));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Estrato");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 70, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarpacienteActionPerformed
       
    }//GEN-LAST:event_botonGuardarpacienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel WallPaper;
    private javax.swing.JButton botonGuardarpaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txt_Nombrepaciente;
    private javax.swing.JTextField txt_correoelectronico;
    private javax.swing.JTextField txt_direccionpaciente;
    private javax.swing.JTextField txt_estratopaciente;
    private javax.swing.JTextField txt_fechanacimientopaciente;
    private javax.swing.JTextField txt_identficacionpaciente;
    private javax.swing.JTextField txt_lugardenacimientopaciente;
    private javax.swing.JTextField txt_sedepaciente;
    private javax.swing.JTextField txt_telefonopaciente;
    // End of variables declaration//GEN-END:variables
}
