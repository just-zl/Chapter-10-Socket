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
			
			dos.writeUTF("Hello,Server,this is a client!");  //先写入传给服务器端的信息
			
			String string = null;
			if((string = dis.readUTF())!=null) {
				
				System.out.println(string);  //后读取从服务器端获取到的信息
			}
			
			dos.close();dis.close();s.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
