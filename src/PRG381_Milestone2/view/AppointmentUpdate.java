/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PRG381_Milestone2.view;

import PRG381_Milestone2.controller.AppointmentController;
import PRG381_Milestone2.controller.CounselorController;
import PRG381_Milestone2.model.Appointment;
import PRG381_Milestone2.model.Counselor;
import java.util.Date;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author 601052
 */
public class AppointmentUpdate extends javax.swing.JFrame {

    /**
     * Creates new form AppointmentUpdate
     */
    public AppointmentUpdate() {
        initComponents();
        loadCounselorNames();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        appointCounsName = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        appointDate = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        appointTime = new javax.swing.JComboBox<>();
        appFormUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 190));
        setResizable(false);

        jLabel13.setText("Counselor Name");

        jLabel14.setText("Appointment Date");

        jLabel15.setText("Appointment Time");

        appFormUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        appFormUpdate.setText("Update");
        appFormUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appFormUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(appointCounsName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(appointDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(appointTime, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(appFormUpdate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(appointCounsName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(appointDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(appointTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(appFormUpdate)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void appFormUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appFormUpdateActionPerformed
        // TODO add your handling code here:
        AppointmentController controller = new AppointmentController();

        String updatedName = appointCounsName.getSelectedItem().toString();
        Date updatedDate = appointDate.getDate();
        String updatedTime = appointTime.getSelectedItem().toString();

        selectedAppointment.setCounName(updatedName);
        selectedAppointment.setDate(updatedDate);
        selectedAppointment.setTime(updatedTime);

        controller.updateAppointmentInDB(selectedAppointment);

        JOptionPane.showMessageDialog(this, "Appointment updated successfully.");

        mainFrame.loadAppointmentTable(); 
        dispose(); 
    }//GEN-LAST:event_appFormUpdateActionPerformed
    
    private Appointment selectedAppointment;
    private MainFrame mainFrame; 

    public AppointmentUpdate(MainFrame mainFrame, Appointment selectedAppointment) {
        initComponents();
        this.selectedAppointment = selectedAppointment;
        this.mainFrame = mainFrame;

        loadCounselorNames();
        loadTimes();

        appointCounsName.setSelectedItem(selectedAppointment.getCounName());
        appointDate.setDate(selectedAppointment.getDate());
        appointTime.setSelectedItem(selectedAppointment.getTime());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void loadTimes() {
        String[] timeSlots = {
            "08:00", "08:30",
            "09:00", "09:30",
            "10:00", "10:30",
            "11:00", "11:30",
            "12:00", "12:30",
            "13:00", "13:30",
            "14:00", "14:30",
            "15:00", "15:30",
            "16:00"
        };

        appointTime.removeAllItems();
        for (String time : timeSlots) {
            appointTime.addItem(time);
        }
    }

    
    private void loadCounselorNames(){
        CounselorController controller = new CounselorController();
        List<Counselor> counselorList = controller.getAllCounselors();
        
        appointCounsName.removeAllItems();
        for (Counselor c : counselorList) {
            appointCounsName.addItem(c.getName()); 
        }
    }
    
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
            java.util.logging.Logger.getLogger(AppointmentUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppointmentUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppointmentUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppointmentUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppointmentUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton appFormUpdate;
    private javax.swing.JComboBox<String> appointCounsName;
    private com.toedter.calendar.JDateChooser appointDate;
    private javax.swing.JComboBox<String> appointTime;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    // End of variables declaration//GEN-END:variables
}
