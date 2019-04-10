package calculatorSocketUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import calculatorSocket.CalculatorImpl;

public class CalculatorServerUDP {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket sSocket = new DatagramSocket(1313);
			
			byte[] recieveData = new byte[1024];
			byte[] sendData = new byte[1024];
			
			DatagramPacket recievePacket = new DatagramPacket(recieveData, recieveData.length);
			System.out.println("Esperando por operação na porta 1313");
			
			sSocket.receive(recievePacket);
			
			String rcvMsg = (String) new String(recievePacket.getData());			
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
					
			InetAddress ipAddress = recievePacket.getAddress();
			int port = recievePacket.getPort();
			
			sendData = respMsg.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, port);
			
			sSocket.send(sendPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
