package test_TCP_Socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Test2_TCPClient2 {

	public static void main(String[] args) {
		
		try {
			Socket s = new Socket("10.16.183.188", 8888);
			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			System.out.println(dis.readUTF());
			dis.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
