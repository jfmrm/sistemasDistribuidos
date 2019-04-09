package calculatorSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 1313);
			
			ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
			
			System.out.println(">>>> " + (String) inFromServer.readObject());

			Scanner in = new Scanner(System.in);
			outToServer.writeObject(in.nextLine());
			outToServer.flush();
			
			String respMsg = (String) inFromServer.readObject();
			
			System.out.println(">>>> " + respMsg);
			
			socket.close();
			outToServer.close();
			inFromServer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
