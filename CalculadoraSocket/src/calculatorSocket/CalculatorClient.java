package calculatorSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CalculatorClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 1313);
			
			ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
			
			outToServer.writeObject("mul(1,3)");
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
