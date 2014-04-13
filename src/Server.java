import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server{
	ArrayList<Thread> incomingClientThreads = new ArrayList<Thread>();
	int i=0;
	
	public Server() throws IOException
	{
		ServerSocket serverSocket = serverSocket = new ServerSocket(9090); // en ny server instantieres på port 9090
		
        
        try {
        	while(true) {
        		i = incomingClientThreads.size();
        		incomingClientThreads.add(new ServerThread(serverSocket.accept(), i));
        		serverSocket.close();
        	}
        }
        finally {
        	serverSocket.close();           	
        }

	
	}
	
    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
    	new Server();
    }
}