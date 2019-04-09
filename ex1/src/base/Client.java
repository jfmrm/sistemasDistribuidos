package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	static String nickName = null;
	public static void main(String[] args) {
		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		int port = 8080;
		try {
			echoSocket = new Socket("localhost", port);
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		try {
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Digite um nickName");
			nickName = stdIn.readLine();
			
			System.out.println(in.readLine());
			
			Listen l = new Listen(in);
			new Thread(l).start();
			Write w = new Write(out, nickName);
			new Thread(w).start();
			
//			while ((userInput = stdIn.readLine()) != null) {
//		
//				out.println(userInput);
//				System.out.println("Server: " + in.readLine());
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
