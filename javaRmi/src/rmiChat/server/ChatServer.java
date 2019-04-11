package rmiChat.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import rmiChat.Chat;

public class ChatServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Chat server = new ChatImpl("server");
			Scanner in = new Scanner(System.in);
			
			LocateRegistry.createRegistry(1099);
			System.out.println("Obtendo registro");
			Registry registry = LocateRegistry.getRegistry();
			System.out.println("Servidor de chat iniciado");
			
			Naming.rebind("chat", server);
			
			while (true) {
				String msg = in.nextLine();
				
				if (!server.getClients().isEmpty()) {
					for (Chat c : server.getClients()) {
						c.send(msg);
					}					
				}
			}
		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
