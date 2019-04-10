package calculatorSocketUDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class CalculatorClientUDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

			DatagramSocket clientSocket = new DatagramSocket();

			String servidor = "localhost";
			int porta = 1313;

			InetAddress IPAddress = InetAddress.getByName(servidor);

			byte[] sendData = new byte[1024];
			byte[] receiveData = new byte[1024];

			System.out.println("Digitea operação: ");
			String sentence = inFromUser.readLine();
			sendData = sentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData,
					sendData.length, IPAddress, porta);

			clientSocket.send(sendPacket);

			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

			clientSocket.receive(receivePacket);

			String resp = new String(receivePacket.getData());

			System.out.println(">> " + resp);
			clientSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
