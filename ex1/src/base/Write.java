package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Write implements Runnable{
	PrintWriter p;
	
	public Write(PrintWriter p) {
		this.p = p;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader stdIn = 
				new BufferedReader(
						new InputStreamReader(System.in));
		while (true) {
			try {
				p.println(stdIn.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
