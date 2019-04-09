package calculatorSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket sSocekt = new ServerSocket(1313);
			
			Socket socket = sSocekt.accept();
			
			ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
			
			outToClient.writeObject("Digite a operação que deseja realizar no formato <op>(p1, p2)");
			outToClient.flush();
			
			String rcvMsg = (String) inFromClient.readObject();
			
			CalculatorImpl calc = new CalculatorImpl();
			
			String opName = rcvMsg.substring(0, 3);
			String[] pairs = rcvMsg.substring(rcvMsg.indexOf("(") + 1, rcvMsg.indexOf(")")).split(",");
			float r = 0;
			float p1 = Float.parseFloat(pairs[0]);
			float p2 = Float.parseFloat(pairs[1]);
			
			if(opName.equals("sub")) {
				r = calc.sub(p1, p2);
			} else if (opName.equals("sum")) {
				r = calc.sum(p1, p2);
			} else if (opName.equals("div")) {
				r = calc.div(p1, p2);
			} else if (opName.equals("mul")) {
				r = calc.mul(p1, p2);
			}
			
			String respMsg = Float.toString(r);
			outToClient.writeObject(respMsg);
			outToClient.flush();
			
			sSocekt.close();
			socket.close();
			outToClient.close();
			inFromClient.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
