import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Server{
	
	public Server() throws IOException
	{
        ServerSocket listener = new ServerSocket(9090);
        ArrayList<Thread> serverThreads = new ArrayList<Thread>();
        int i = 0;
        
        try {
            while (true) {
                serverThreads.add(new ServerThread(listener.accept(), i));
                // original kode klippet over i serverThread                
    	        
    	        i++;
            }
        }
        finally {
            listener.close();
        }
		
	}
	
    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
    	new Server();
    }
}