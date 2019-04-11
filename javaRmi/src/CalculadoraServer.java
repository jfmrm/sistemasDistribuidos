

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculadoraServer {
	
	public static void main(String[] args) {
		try {
				ICalculadora calc = new CalculadoraImpl();
				System.out.println("Criando registro");
//				LocateRegistry.createRegistry(1099);
				System.out.println("Obtendo registro");
//				Registry registry = LocateRegistry.getRegistry(1099);
				System.out.println("Servidor Criado");
				// Bind the remote object's stub in the registry
				Naming.rebind("rmi://localhost/MyCalc", calc);
				System.out.println("calculadora server ready.");
				System.out.println("Digite <ENTER> para encerrar");
				BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
				// O buffered reader serve apenas para "parar" a execução
				b.read();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
