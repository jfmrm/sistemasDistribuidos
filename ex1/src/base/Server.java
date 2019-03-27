package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
public class Server {
		
	public static void main(String[] args) {
			Socket echoSocket = null;
			ServerSocket server = null;
			PrintWriter out = null;
			BufferedReader in = null;
			
			try {
				server = new ServerSocket(8080);
				System.out.println("Aguardando nova conexao");
				echoSocket = server.accept();
				System.out.println("Conexao com cliente iniciada");
				out = new PrintWriter(echoSocket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(
				echoSocket.getInputStream()));
				out.println("Ola, voce se conectou ao servidor");
			} catch (UnknownHostException e) {
				e.printStackTrace();
				System.exit(1);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
			
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		
			String input;
			Listen l = new Listen(in);
			new Thread(l).start();
			Write w = new Write(out);
			new Thread(w).start();
		}
}
