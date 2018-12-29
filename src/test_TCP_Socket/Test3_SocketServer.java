package test_TCP_Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//�Ƚ��տͻ��˵���Ϣ������ͻ��˷�����Ϣ  ��
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
				System.out.println(string);  //��ȡ�ӿͻ��˻�ȡ����Ϣ
			}
			
			dos.writeUTF("�û����ã�����ip��ַΪ��" + s.getInetAddress()+"; �˿�Ϊ��" +s.getPort());  //д�봫���ͻ��˵���Ϣ
			
			dis.close();dos.close();s.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
