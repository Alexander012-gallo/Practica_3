package view;

import controller.Laberinto.Celda;
import controller.Laberinto.Laberinto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class FrmLaberinto extends javax.swing.JDialog {

    /**
     * Creates new form FrmLaberinto
     */
    private Laberinto laberinto;
    private DefaultTableModel modeloTabla;

    public FrmLaberinto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        modeloTabla = (DefaultTableModel) tabla.getModel();
        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTamanio = new javax.swing.JTextField();
        btnGenerar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnRegenerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GENERADOR DE LABERINTO");
        getContentPane().setLayout(null);

        jLabel1.setText("Tamaño del Laberinto (10-100):");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(34, 9, 181, 16);
        getContentPane().add(txtTamanio);
        txtTamanio.setBounds(221, 6, 71, 22);

        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerar);
        btnGenerar.setBounds(381, 6, 72, 23);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "A", "B", "C", "D"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 40, 510, 320);

        btnRegenerar.setText("Regenerar");
        btnRegenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegenerarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegenerar);
        btnRegenerar.setBounds(210, 380, 90, 23);

        setSize(new java.awt.Dimension(570, 477));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        generarLaberinto();
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnRegenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegenerarActionPerformed
        if (laberinto != null) {
            laberinto.generarMapaAleatorio(laberinto.getFilas());
            actualizarTabla();
        }

    }//GEN-LAST:event_btnRegenerarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmLaberinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLaberinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLaberinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLaberinto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmLaberinto dialog = new FrmLaberinto(new javax.swing.JFrame(), true);
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

    private void generarLaberinto() {
        try {
            int size = Integer.parseInt(txtTamanio.getText());
            laberinto = new Laberinto(size);
            if (laberinto.getMapa() != null) {
                actualizarTabla();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
        }
    }

    private void actualizarTabla() {
        if (laberinto == null || laberinto.getMapa() == null) {
            return;
        }

        Celda[][] mapa = laberinto.getMapa();
        int filas = laberinto.getFilas();
        int columnas = laberinto.getColumnas();

        modeloTabla.setRowCount(0);
        modeloTabla.setColumnCount(columnas);

        for (int i = 0; i < filas; i++) {
            Object[] fila = new Object[columnas];
            for (int j = 0; j < columnas; j++) {
                fila[j] = mapa[i][j].toString();
            }
            modeloTabla.addRow(fila);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnRegenerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtTamanio;
    // End of variables declaration//GEN-END:variables
}
