package test_TCP_Socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//TODO ��д�����У��������˺Ϳͻ���һ��д�����й����У������з�������Ĵ��룬
public class Test1_TCPServer1 {

	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(6666);  //�÷���˼���6666�˿�
			while(true) {
				Socket s = ss.accept();  //�ȴ��ͻ��˵��������󣬲������װ��һ��Socket����ʵ����ͻ��˵�����
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
