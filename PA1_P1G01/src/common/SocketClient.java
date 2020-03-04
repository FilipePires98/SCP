package common;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Filipe Pires (85122) and João Alegria (85048)
 */
public class SocketClient {
    
    private DataOutputStream out;
    private Socket socket;

    public SocketClient(String ip, int port) {
        try {
            this.socket = new Socket(ip, port);
            // Create input and output streams to read from and write to the server
            this.out = new DataOutputStream( socket.getOutputStream() );
            
        } catch (IOException ex) {
            Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void send(String message){
        try {
            this.out.writeUTF(message);
            this.out.flush();
        } catch (IOException ex) {
            Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void close(){
        try {
            this.out.close();
            this.socket.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
