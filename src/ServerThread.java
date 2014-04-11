import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	DataInputStream in;
	DataOutputStream out;
	
	public ServerThread (Socket socket, int i) {
		System.out.println("Jeg bliver ikke skrevet ud før en klient forbinder til serveren.");
	    
	    try {
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
	    } catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	    try {
	    	String message = in.readUTF(); //læs fra client
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println("Message no: " + i + ". You said: " + message);
	        
	        out.println("Message no: " + i);
	    }
	    catch(Exception e) //ignores exceptions
	    {
	    	e.printStackTrace();
	    }
	}
}
