import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server{
	private ArrayList<Thread> incomingClientThreads = new ArrayList<Thread>();
	private int i=0;
	
	public Server() throws IOException
	{
		ServerSocket serverSocket = serverSocket = new ServerSocket(9090); // en ny server instantieres p� port 9090
        
        try {
        	while(true) {
        		i = incomingClientThreads.size();
        		Thread t = new Thread(new ServerThread(serverSocket.accept(), i));
        		incomingClientThreads.add(t);
        		t.start();        		
        	}
        }
        finally {
        	serverSocket.close();           	
        }

	
	}
	
    public static void main(String[] args) throws IOException {
    	new Server();
    }
}