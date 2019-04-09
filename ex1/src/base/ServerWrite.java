package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ServerWrite implements Runnable {

	ArrayList<PrintWriter> clientWriters;
	BufferedReader clientReader;
	
	public ServerWrite(BufferedReader clientReader, ArrayList<PrintWriter> clientWriters) {
		 this.clientWriters = clientWriters;
		 this.clientReader = clientReader;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				String input = clientReader.readLine();
				for (PrintWriter i : clientWriters) {
						i.println(input);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}

}
