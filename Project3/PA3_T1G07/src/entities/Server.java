package entities;

import common.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fp
 */
public class Server extends javax.swing.JFrame implements MessageProcessor {
    
    private int id;
    private final int port;
    private SocketServer socketServer;
    private Thread serverThread;
    private final String mainServerHost;
    private final Integer mainServerPort;
    private List<String> processingRequests;
    private List<String> processedRequests;
    /**
     * Creates new form Server
     */
    public Server(String args[]) {
        this.port = Integer.valueOf(args[0]);
        this.mainServerHost = args[1];
        this.mainServerPort = Integer.valueOf(args[2]);
        
        this.processingRequests=new ArrayList();
        this.processedRequests=new ArrayList();
        this.socketServer = new SocketServer(this.port, this);
        this.serverThread = new Thread(socketServer);
        this.serverThread.start();
        this.initManagerClient();
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

        stop = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        processing = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        processed = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(420, 180));

        stop.setText("Stop");
        stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopMouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(processing);

        jScrollPane2.setViewportView(processed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stop)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopMouseClicked
        try {
            SocketClient socketManager = new SocketClient(this.mainServerHost, this.mainServerPort);
            socketManager.send("serverDown-" + this.id);
            socketManager.close();
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_stopMouseClicked

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
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server(args).setVisible(true);
            }
        });
    }
    
    public void initManagerClient(){
        try {
            SocketClient socketManager = new SocketClient(this.mainServerHost, this.mainServerPort);
            socketManager.send("newServer-localhost-" + this.port);
            socketManager.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String processMessage(String message) {
        String[] processedMessage = message.split("-");
        switch(processedMessage[0]){
            case "serverId"://serverId-id
                this.id=Integer.valueOf(processedMessage[1]);
                this.setTitle("Server #" + this.id);
                break;
            case "healthcheck":// healthcheck
                break;
            case "request": //request-clientHost-clientPort-request
                SocketClient socketManager = new SocketClient(this.mainServerHost, this.mainServerPort);
                try {
                    socketManager.send("newRequest-"+this.id+"-" + processedMessage[3]);
                    socketManager.close();
                    processingRequests.add(processedMessage[3]);
                    updateProcessing();
                    PiCalculation request = new PiCalculation(processedMessage[1], Integer.valueOf(processedMessage[2]),processedMessage[3]);
                    Thread requestProcessing = new Thread(request);
                    requestProcessing.start();
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;

        }
        return "Message processed with success.";
    }
    
    private class PiCalculation implements Runnable{
        
        private String message;
        private String[] processedMessage;
        private final int clientPort;
        private final String clientHost;
        
        public PiCalculation(String clientHost, int clientPort, String message){
            this.message=message;
            this.processedMessage = message.split("|");
            for(String m: this.processedMessage) {
                m = m.trim();
            }
            this.clientHost=clientHost;
            this.clientPort=clientPort;
        }
        
        @Override
        public void run() {
            try {
                Thread.sleep(Integer.valueOf(this.processedMessage[3])*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }

            String reply = "| " +id + " | " + this.processedMessage[0] + " | " + this.processedMessage[1] + " | 02 | " + this.processedMessage[3] + " | 3.1415 |";
            
            SocketClient targetClient = new SocketClient(clientHost, clientPort);
            try {
                targetClient.send(reply);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            targetClient.close();
            
            SocketClient socketManager = new SocketClient(mainServerHost, mainServerPort);
            try {
                socketManager.send("processedRequest-"+id+"-" + message);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            socketManager.close();
            processingRequests.remove(message);
            processedRequests.add(message);
            updateProcessing();
            updateProcessed();
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> processed;
    private javax.swing.JList<String> processing;
    private javax.swing.JButton stop;
    // End of variables declaration//GEN-END:variables

    private void updateProcessing(){
        String[] tmp=new String[processingRequests.size()];
        processingRequests.toArray(tmp);
        processing.setListData(tmp);
    }
    
    private void updateProcessed(){
        String[] tmp=new String[processedRequests.size()];
        processedRequests.toArray(tmp);
        processed.setListData(tmp);
    }

}
