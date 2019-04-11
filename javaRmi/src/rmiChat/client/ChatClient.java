package rmiChat.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import rmiChat.Chat;

public class ChatClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Digite seu nome:");
			Scanner in = new Scanner(System.in);
			String name = in.nextLine();
		
			Chat client = new ChatImpl(name);
			
			Chat server = (Chat) Naming.lookup("chat");
			
			server.newClient(client);
			
			while (true) {
				String msg = in.nextLine();
				server.send(msg);
				
				for (Chat c : server.getClients()) {
					c.send(client.getName() + ": " + msg);
				}
			}
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
