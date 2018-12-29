package test_TCP_Socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//TODO 编写过程中，服务器端和客户端一起写；运行过程中，先运行服务端器的代码，
public class Test1_TCPServer1 {

	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(6666);  //该服务端监听6666端口
			while(true) {
				Socket s = ss.accept();  //等待客户端的连接请求，并将其封装成一个Socket对象，实现与客户端的连接
				DataInputStream dis = new DataInputStream(s.getInputStream());
				System.out.println(dis.readUTF());
				dis.close();
				s.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
