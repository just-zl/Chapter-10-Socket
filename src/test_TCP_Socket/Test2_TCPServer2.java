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
				dos.writeUTF("�û����ã�����ip��ַΪ"+s.getInetAddress()+";���Ķ˿�Ϊ��"+s.getPort());
				
				dos.close();
				s.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
