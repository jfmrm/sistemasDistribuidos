import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.Vector;

public class CalculadoraClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ICalculadora calc = (ICalculadora) Naming.lookup("rmi://localhost/MyCalc") ;
			int resp = calc.add(1, 2);
			System.out.println(resp);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
