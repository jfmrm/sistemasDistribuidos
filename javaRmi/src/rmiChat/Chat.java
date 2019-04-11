package rmiChat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Chat extends Remote {
	public void send(String msg) throws RemoteException;
	public ArrayList<Chat> getClients() throws RemoteException;
	public void newClient(Chat c) throws RemoteException;
	public String getName() throws RemoteException;
}
