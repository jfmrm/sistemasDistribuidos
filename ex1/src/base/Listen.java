package base;

import java.io.BufferedReader;
import java.io.IOException;

public class Listen implements Runnable {
	BufferedReader in;
	
	public Listen(BufferedReader in) {
		this.in = in;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				System.out.println(in.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
