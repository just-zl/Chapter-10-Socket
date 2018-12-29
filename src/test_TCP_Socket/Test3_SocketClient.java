package test_TCP_Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test3_SocketClient {

	public static void main(String[] args) {
		
		try {
			Socket s = new Socket("10.16.183.188", 7777);
			
			OutputStream os = s.getOutputStream();
			InputStream is = s.getInputStream();
			
			DataOutputStream dos = new DataOutputStream(os);
			DataInputStream dis = new DataInputStream(is);
			
			dos.writeUTF("Hello,Server,this is a client!");  //��д�봫���������˵���Ϣ
			
			String string = null;
			if((string = dis.readUTF())!=null) {
				
				System.out.println(string);  //���ȡ�ӷ������˻�ȡ������Ϣ
			}
			
			dos.close();dis.close();s.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
