import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	private static final int PORT = 12345;
	
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getLocalHost();
			ServerSocket serverSocket = new ServerSocket(PORT);
	
			boolean running = true;
			String prevMsgFromClient = "You're the first one to connect!";
			
			while (running){
				Socket socket = serverSocket.accept();
				
				ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
				outputStream.flush();
				
				ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
				
				String msgFromClient = inputStream.readUTF();
				
				if (!msgFromClient.equals("shutdown")){
					System.out.println("Server received: " + msgFromClient); 
					outputStream.writeUTF("The last user wrote: " + prevMsgFromClient);
					outputStream.flush();
					prevMsgFromClient = msgFromClient;
				}
				
				else {
					running = false;
					outputStream.writeUTF("The last user wrote: " + prevMsgFromClient + "\n*** server shutting down ***");
					outputStream.flush();
					inputStream.close();
					outputStream.close();
					socket.close();	
				}
				
			}
			
			System.out.println("*** shutting down ***");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
}