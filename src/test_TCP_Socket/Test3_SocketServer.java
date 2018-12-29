package test_TCP_Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//既接收客户端的信息，又向客户端发送信息  。
public class Test3_SocketServer {

	public static void main(String[] args) {
		
		InputStream in = null;
		OutputStream out = null;
		
		try {
			ServerSocket ss = new ServerSocket(7777);
			Socket s = ss.accept();
			
			in = s.getInputStream();
			out = s.getOutputStream();
			
			DataInputStream dis = new DataInputStream(in);
			DataOutputStream dos = new DataOutputStream(out);
			
			String string = null;
			if((string = dis.readUTF())!=null) {
				System.out.println(string);  //读取从客户端获取的信息
			}
			
			dos.writeUTF("用户您好，您的ip地址为：" + s.getInetAddress()+"; 端口为：" +s.getPort());  //写入传给客户端的信息
			
			dis.close();dos.close();s.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
