import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {
	Socket socket = new Socket();
	int i=0;
	DataInputStream in;
	DataOutputStream out;
	
	public ServerThread (Socket socket, int i) {
		System.out.println("Jeg bliver ikke skrevet ud før en klient forbinder til serveren.");
		this.socket = socket;
		this.i = i;
		
	}

	@Override
	public void run() {
		int messageNumber=0;
	    
	    while(true) {
	    	try {
		 		in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
		    } catch (Exception e) {
				e.printStackTrace();
			}
			
		    try {
		    	String message = in.readUTF(); //læs fra client
				
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				out.println("Client threads on server: " + i + " - Message no: " + messageNumber + ". You said: " + message);	        
		    }
		    catch(Exception e) { //ignores exceptions
		    	e.printStackTrace();
		    }
		    messageNumber++;
		}
	}
}
