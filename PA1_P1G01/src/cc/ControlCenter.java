/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc;

import common.SocketServer;

/**
 *
 * @author joaoalegria
 */
public class ControlCenter extends javax.swing.JFrame {

    /**
     * Creates new form ControlCenter
     */
    public ControlCenter() {
        initComponents();
        SocketServer ss = new SocketServer(6666, new CCMessageProcessor());
        ss.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        cobsLabel = new javax.swing.JLabel();
        numCornCobs = new javax.swing.JSpinner();
        farmersLabel = new javax.swing.JLabel();
        numFarmers = new javax.swing.JSpinner();
        timeoutLabel = new javax.swing.JLabel();
        timeout = new javax.swing.JSpinner();
        stepLabel = new javax.swing.JLabel();
        maxStep = new javax.swing.JSpinner();
        prepareBtn = new javax.swing.JButton();
        startBtn = new javax.swing.JButton();
        collectBtn = new javax.swing.JButton();
        returnBtn = new javax.swing.JButton();
        stopBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setText("Control Center");

        cobsLabel.setText("Number of Corn Cobs:");

        numCornCobs.setModel(new javax.swing.SpinnerNumberModel(50, 50, null, 10));

        farmersLabel.setText("Number of Farmers:");

        numFarmers.setModel(new javax.swing.SpinnerNumberModel(5, 2, 5, 1));

        timeoutLabel.setText("Timeout (ms):");

        timeout.setModel(new javax.swing.SpinnerNumberModel(500, 0, 1000, 50));

        stepLabel.setText("Max. Step:");

        maxStep.setModel(new javax.swing.SpinnerNumberModel(1, 1, 2, 1));

        prepareBtn.setText("Prepare");
        prepareBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prepareBtnActionPerformed(evt);
            }
        });

        startBtn.setText("Start");
        startBtn.setEnabled(false);
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });

        collectBtn.setText("Collect");
        collectBtn.setEnabled(false);
        collectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collectBtnActionPerformed(evt);
            }
        });

        returnBtn.setText("Return");
        returnBtn.setEnabled(false);
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });

        stopBtn.setText("Stop");
        stopBtn.setEnabled(false);
        stopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(farmersLabel)
                            .addComponent(timeoutLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(timeout, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numFarmers))
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cobsLabel)
                            .addComponent(stepLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(numCornCobs, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                            .addComponent(maxStep))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(prepareBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startBtn)
                                .addGap(70, 70, 70)
                                .addComponent(collectBtn))
                            .addComponent(titleLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(returnBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stopBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(farmersLabel)
                    .addComponent(cobsLabel)
                    .addComponent(numFarmers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numCornCobs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeoutLabel)
                    .addComponent(stepLabel)
                    .addComponent(timeout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxStep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prepareBtn)
                    .addComponent(startBtn)
                    .addComponent(collectBtn)
                    .addComponent(returnBtn)
                    .addComponent(stopBtn))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prepareBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prepareBtnActionPerformed
        // Update UI
        this.startBtn.setEnabled(true); // only if all farmers are in the standing area!
        this.stopBtn.setEnabled(true);
        this.prepareBtn.setEnabled(false);
        this.numFarmers.setEnabled(false);
        this.numCornCobs.setEnabled(false);
        this.timeout.setEnabled(false);
        this.maxStep.setEnabled(false);
        
        // Validate input
        if((Integer)this.numFarmers.getValue()>5 || (Integer)this.numFarmers.getValue()<2) {
            this.numFarmers.setValue(5);
            System.err.println("[CC]: Invalid input on 'Number of Farmers'! Set to default (5).");
        }
        if((Integer)this.numCornCobs.getValue()<(Integer)this.numFarmers.getValue()*10) {
            this.numCornCobs.setValue((Integer)this.numFarmers.getValue()*10);
            System.err.println("[CC]: Not enough 'Number of Corn Cobs' for every farmer! Set to default (" + ((Integer)this.numCornCobs.getValue()).toString() + "0).");
        }
        if((Integer)this.timeout.getValue()>1000 || (Integer)this.timeout.getValue()<0) {
            this.timeout.setValue(500);
            System.err.println("[CC]: Invalid input on 'Timeout'! Set to default (500ms).");
        }
        if((Integer)this.maxStep.getValue()>2 || (Integer)this.maxStep.getValue()<1) {
            this.maxStep.setValue(1);
            System.err.println("[CC]: Invalid input on 'Max. Step'! Set to default (1).");
        }
        
        // Send message to FI to place farmer IDs in respective Storehouse positions
        
        // Send message to FI to update number of Corn Cobs in Granary
        
        // Send message to FI to update farmer positions (move to Standing Area)
        
    }//GEN-LAST:event_prepareBtnActionPerformed

    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed
        // Update UI
        this.collectBtn.setEnabled(true); // only if all farmers are in the granary!
        this.startBtn.setEnabled(false);
        
        // Send message to FI to update farmer positions (move to Path and then Granary)
        
    }//GEN-LAST:event_startBtnActionPerformed

    private void collectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collectBtnActionPerformed
        // Update UI
        this.returnBtn.setEnabled(true); // only if all farmers have (tried to) grab corn cobs!
        this.collectBtn.setEnabled(false);
        
        // Send message to FI for farmers to grab corn cobs
        
    }//GEN-LAST:event_collectBtnActionPerformed

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        // Update UI
        this.stopBtn.setEnabled(true);
        this.returnBtn.setEnabled(false);
        this.prepareBtn.setEnabled(true); // only if all farmers have returned and delivered the corn cobs!
        
        // Send message to FI to update farmer positions (move to Storehouse and then deliver corn cobs)
        
    }//GEN-LAST:event_returnBtnActionPerformed

    private void stopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopBtnActionPerformed
        // Update UI
        this.startBtn.setEnabled(false);
        this.collectBtn.setEnabled(false);
        this.returnBtn.setEnabled(false);
        this.stopBtn.setEnabled(false);
        this.prepareBtn.setEnabled(true); // only if all farmers are in the storehouse!
        this.numFarmers.setEnabled(true); // same condition for the input fields...
        this.numCornCobs.setEnabled(true);
        this.timeout.setEnabled(true);
        this.maxStep.setEnabled(true);
        
        // Send message to FI for farmers to immediately stop what they are doing and go back to the Storehouse
        
    }//GEN-LAST:event_stopBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ControlCenter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlCenter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlCenter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlCenter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlCenter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cobsLabel;
    private javax.swing.JButton collectBtn;
    private javax.swing.JLabel farmersLabel;
    private javax.swing.JSpinner maxStep;
    private javax.swing.JSpinner numCornCobs;
    private javax.swing.JSpinner numFarmers;
    private javax.swing.JButton prepareBtn;
    private javax.swing.JButton returnBtn;
    private javax.swing.JButton startBtn;
    private javax.swing.JLabel stepLabel;
    private javax.swing.JButton stopBtn;
    private javax.swing.JSpinner timeout;
    private javax.swing.JLabel timeoutLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
