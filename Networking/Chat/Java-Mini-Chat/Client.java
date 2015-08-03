import java.io.BufferedReader;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.IOException;

public class Client{
	
	public static void main(String[] args){
		
		
		Socket socket;
		final BufferedReader in;
		final PrintWriter out;
		
		final Scanner sc = new Scanner(System.in);
		
		try{
			
			socket = new Socket("127.0.0.1",5000);
			
			
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
						System.out.println("Server : " + msg);
						
					}
				}
			});
			receiver.start();
			
			
		
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}
}










