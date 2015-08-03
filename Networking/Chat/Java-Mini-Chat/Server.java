import java.io.BufferedReader;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.IOException;

public class Server{
	
	public static void main(String[] args){
		
		ServerSocket socketServer;
		Socket socket;
		final BufferedReader in;
		final PrintWriter out;
		final Scanner sc = new Scanner(System.in);
		
		try{
			socketServer = new ServerSocket(5000);
			socket = socketServer.accept();
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			Thread sender = new Thread(new Runnable(){
				String msg;
				@Override
				public void run(){
					while(true){
						
						msg = sc.nextLine();
						out.println(msg);
						out.flush();
					}
				}
			});
			
			sender.start();
			
			
			
			Thread receiver = new Thread(new Runnable(){
				String msg;
				@Override
				public void run(){
					while(true){
						
						try{
							msg = in.readLine();
						} catch(IOException e){
							e.printStackTrace();
						}
						System.out.println("Client : " + msg);
						
					}
				}
			});
			receiver.start();
			
			
		
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}
}










