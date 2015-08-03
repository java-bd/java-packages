import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ClientGUI extends JFrame {
	private static final int PORT = 12345;
	
	private JTextArea jTextArea;
	private JTextField jTestField;
	private JLabel jLabel;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;

	public ClientGUI() {
		super("ClientGUI v2.12");
		setLayout(new BorderLayout());
		
		// jTextArea
		jTextArea = new JTextArea(4, 40);
		jTextArea.setEditable(false);
		add(new JScrollPane(jTextArea), BorderLayout.CENTER);
		
		// southPanel
		JPanel southPanel = new JPanel(new GridLayout(2,1));
		add(southPanel, BorderLayout.SOUTH);
		
		// jLabel occupies the top part of southPanel
		jLabel = new JLabel(" Enter a message: ");
		southPanel.add(jLabel);
		
		// jTestField occupies the bottom part of southPanel
		jTestField = new JTextField(40);
		jTestField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				sendMessage(jTestField.getText());
				jTestField.setText("");
				jTestField.setEditable(true);
			}
		});
		southPanel.add(jTestField);
	
		// more formatting
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		while(true){
			try {
			InetAddress address = InetAddress.getLocalHost();
			Socket socket = new Socket(address, PORT);
			
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.flush();
			
			inputStream = new ObjectInputStream(socket.getInputStream());
			
			String msgFromServer = inputStream.readUTF();
			jTextArea.append(msgFromServer);
		
			inputStream.close();
			outputStream.close();
			socket.close();	
			
			} catch (IOException ex) {
				ex.printStackTrace();
			}	
		}
			
	}
	
	private void sendMessage(String msgToServer) {
		if (outputStream == null) {
			return;
		}

		try {
			outputStream.writeUTF(msgToServer);
			outputStream.flush();
		} catch (IOException ex) {
			System.err.println("Unable to send message" + ex);
		}
	}
	
	public static void main(String[] args) {
		new ClientGUI();
	}
}
