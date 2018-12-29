package test_TCP_Socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test2_TCPServer2 {

	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(8888);
			
			while(true) {
				Socket s = ss.accept();
				OutputStream os = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeUTF("用户您好，您的ip地址为"+s.getInetAddress()+";您的端口为："+s.getPort());
				
				dos.close();
				s.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
