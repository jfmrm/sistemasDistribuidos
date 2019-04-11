

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraImpl extends UnicastRemoteObject implements ICalculadora{

	protected CalculadoraImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(int v1, int v2) throws RemoteException {
		// TODO Auto-generated method stub
		return v1 + v2;
	}

	@Override
	public int sub(int v1, int v2) throws RemoteException {
		// TODO Auto-generated method stub
		return v1 - v2;
	}

	@Override
	public int mul(int v1, int v2) throws RemoteException {
		// TODO Auto-generated method stub
		return v1 * v2;
	}

	@Override
	public int div(int v1, int v2) throws RemoteException {
		// TODO Auto-generated method stub
		return v1/v2;
	}

}
