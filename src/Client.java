import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Trivial client for the date server.
 */
public class Client extends JFrame {

    
    
	public Client() throws IOException
	{
		JButton btn = new JButton("run");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Socket s =null;
				String answer = null;
				
				try {
					s = new Socket("localhost", 9090);
					
					DataOutputStream dos = new DataOutputStream(s.getOutputStream());
					dos.writeUTF("Hej server.");
					dos.flush();
					
					BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
					answer = input.readLine();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		        System.out.println(answer);		
			}
		});
		add(btn);
		setVisible(true);
        pack();
		
	}
	
    public static void main(String[] args) throws IOException {
    	new Client();
    }
}