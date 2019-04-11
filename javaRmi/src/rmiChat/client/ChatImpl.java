package rmiChat.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import rmiChat.Chat;

public class ChatImpl extends UnicastRemoteObject implements Chat{
	
	String name;
	ArrayList<Chat> clients = new ArrayList<Chat>();
	
	protected ChatImpl(String name) throws RemoteException {
		this.name = name;
	}

	@Override
	public void send(String msg) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(msg);
	}

	@Override
	public ArrayList<Chat> getClients() throws RemoteException {
		// TODO Auto-generated method stub
		return this.clients;
	}

	@Override
	public void newClient(Chat c) throws RemoteException {
		// TODO Auto-generated method stub
		this.clients.add(c);
	}

	@Override
	public String getName() throws RemoteException {
		// TODO Auto-generated method stub
		return this.name;
	}

}
