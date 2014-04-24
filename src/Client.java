import java.awt.FlowLayout;
import java.awt.Panel;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Trivial client for the date server.
 */
public class Client extends JFrame {
	private Socket s = null;
	private String answer = null;
	private DataOutputStream dos;
	private BufferedReader input;
	private JTextField message = new JTextField(10);
        
	public Client() throws IOException {
		
		JButton btn = new JButton("Send message");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (s == null) {
					try {
						s = new Socket("localhost", 9090);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				try {
					dos = new DataOutputStream(s.getOutputStream());
					dos.writeUTF(message.getText());
					dos.flush();
					
					input = new BufferedReader(new InputStreamReader(s.getInputStream()));
					answer = input.readLine();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				// returnerer et svar
				new JOptionPane().showMessageDialog(null, answer);
				System.out.println(answer);
				message.setText("");
			}
		});
		add(new JLabel("Enter a message"));
		add(message);
		add(btn);
		setLayout(new FlowLayout());
		setTitle("Client");
		setSize(250,100);		
		setVisible(true);		
	}
	
    public static void main(String[] args) throws IOException {
    	new Client();
    }
}