package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Write implements Runnable{
	PrintWriter p;
	String nickName;
	ArrayList<Socket> clientsSockets; 
	
	public Write(PrintWriter p, String nickName) {
		this.p = p;
		this.nickName = nickName;
		this.clientsSockets = new ArrayList<Socket>();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader stdIn = 
				new BufferedReader(
						new InputStreamReader(System.in));
		while (true) {
			try {
				p.println(nickName + ": " + stdIn.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
