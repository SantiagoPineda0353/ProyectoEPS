package Vista;


import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author juanp
 */
public class AdministradorRegistroCita extends javax.swing.JInternalFrame {

  /*  public JButton getBotonGuardarpaciente() {
        return botonGuardarpaciente;
    }

    public JComboBox<String> getComboBoxcitamedico() {
        return ComboBoxcitamedico;
    }

    public JComboBox<String> getComboBoxexamencita() {
        return ComboBoxexamencita;
    }

    public JTextField getTxt_citacorreoelectronico() {
        return txt_citacorreoelectronico;
    }

    public JTextField getTxt_citafechayhoracita() {
        return txt_citafechayhoracita;
    }

    public JTextField getTxt_citamodalidad() {
        return txt_citamodalidad;
    }

    public JTextField getTxt_citasede() {
        return txt_citasede;
    }


    public JTextField getTxt_diagnosticocita() {
        return txt_diagnosticocita;
    }

    public JTextField getTxt_idcita() {
        return txt_idcita;
    }

   */

    

    public AdministradorRegistroCita() {
        initComponents();
        this.setSize(new Dimension(400, 300));
        this.setTitle("Nueva Cita");
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_idcita = new javax.swing.JTextField();
        txt_citafechayhoracita = new javax.swing.JTextField();
        txt_diagnosticocita = new javax.swing.JTextField();
        txt_citaMedico = new javax.swing.JTextField();
        ComboBoxcitaSede = new javax.swing.JComboBox<>();
        botonActualizarpaciente = new javax.swing.JButton();
        botonGuardarpaciente1 = new javax.swing.JButton();
        ComboBoxcitaModalidad = new javax.swing.JComboBox<>();
        WallPaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nueva Cita");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 160, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID Paciente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Diagnostico");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 20));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Modalidad");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 110, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha y Hora");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ID Medico");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 70, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Sede");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 70, -1));
        getContentPane().add(txt_idcita, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 130, -1));
        getContentPane().add(txt_citafechayhoracita, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 130, -1));
        getContentPane().add(txt_diagnosticocita, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 130, -1));
        getContentPane().add(txt_citaMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 130, -1));

        ComboBoxcitaSede.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        getContentPane().add(ComboBoxcitaSede, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 130, -1));

        botonActualizarpaciente.setBackground(new java.awt.Color(0, 204, 0));
        botonActualizarpaciente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonActualizarpaciente.setText("Actualizar");
        botonActualizarpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarpacienteActionPerformed(evt);
            }
        });
        getContentPane().add(botonActualizarpaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, -1, -1));

        botonGuardarpaciente1.setBackground(new java.awt.Color(0, 204, 0));
        botonGuardarpaciente1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonGuardarpaciente1.setText("Guardar");
        botonGuardarpaciente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarpaciente1ActionPerformed(evt);
            }
        });
        getContentPane().add(botonGuardarpaciente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        ComboBoxcitaModalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        getContentPane().add(ComboBoxcitaModalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 130, -1));

        WallPaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imag/3409297.jpg"))); // NOI18N
        getContentPane().add(WallPaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 390, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonActualizarpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarpacienteActionPerformed
       
    }//GEN-LAST:event_botonActualizarpacienteActionPerformed

    private void botonGuardarpaciente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarpaciente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonGuardarpaciente1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> ComboBoxcitaModalidad;
    public javax.swing.JComboBox<String> ComboBoxcitaSede;
    private javax.swing.JLabel WallPaper;
    public javax.swing.JButton botonActualizarpaciente;
    public javax.swing.JButton botonGuardarpaciente1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JTextField txt_citaMedico;
    public javax.swing.JTextField txt_citafechayhoracita;
    public javax.swing.JTextField txt_diagnosticocita;
    public javax.swing.JTextField txt_idcita;
    // End of variables declaration//GEN-END:variables
}
