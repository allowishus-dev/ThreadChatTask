import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {
	private Socket socket = new Socket();
	private int i=0;
	private DataInputStream in;
	private DataOutputStream out;
	
	public ServerThread (Socket socket, int i) {
		this.socket = socket;
		this.i = i;
	}

	@Override
	public void run() {
		int messageNumber=1;
	    
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
				out.println("Client thread on server: " + i + " - Message no: " + messageNumber + ". You said: " + message);	        
		    }
		    catch(Exception e) {
		    	e.printStackTrace();
		    }
		    messageNumber++;
		}
	}
}
