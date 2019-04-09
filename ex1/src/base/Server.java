package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
public class Server {
	
	static ArrayList<Write> writers = new ArrayList<Write>();
	
	public static void main(String[] args) {
			Socket echoSocket = null;
			ServerSocket server = null;
			PrintWriter out = null;
			BufferedReader in = null;
			ArrayList<PrintWriter> clientWriters = new ArrayList<PrintWriter>();
			ArrayList<Thread> writers = new ArrayList<Thread>();
			ArrayList<BufferedReader> clientListeners = new ArrayList<BufferedReader>();
			
				try {
					server = new ServerSocket(8080);
					while(true) {
						System.out.println("Aguardando nova conexao");
						echoSocket = server.accept();
						System.out.println("Conexao com cliente iniciada");
						out = new PrintWriter(echoSocket.getOutputStream(), true);
						clientWriters.add(out);
						in = new BufferedReader(new InputStreamReader(
								echoSocket.getInputStream()));
						clientListeners.add(in);
						out.println("Ola, voce se conectou ao servidor");
						
						for (Thread t : writers) {
							t.stop();
						}
						
						writers.clear();
						
						for (int i = 0; i < clientListeners.size(); i++) {
							Thread t = new Thread( new ServerWrite(clientListeners.get(i), clientWriters));
							t.start();
							
							writers.add(t);
						}
						
					}
				} catch (UnknownHostException e) {
					e.printStackTrace();
					System.exit(1);
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(1);
				} 
		}
}
