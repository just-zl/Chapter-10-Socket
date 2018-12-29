package test_TCP_Socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

//�ͻ���
public class Test1_TCPClient1 {

	public static void main(String[] args) {
		
		try {
			Socket s = new Socket("10.16.183.188", 6666);  //��������Ϊ������ip���������ӵĶ˿�
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF("Hello,Server!");  //ʹ�ø�����UTF-8���뽫�ַ���д��ײ������
			dos.flush();
			dos.close();
			s.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
