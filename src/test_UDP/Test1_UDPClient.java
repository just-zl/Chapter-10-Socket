package test_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

//ͨ��UDPʵ�ַ������˺Ϳͻ��˵�����
public class Test1_UDPClient {

	public static void main(String[] args) {
		
		//�ֽ�����������
		byte buf[] = (new String("Hello,ZL!")).getBytes();  //���ַ���ת��Ϊ�ֽ�����
		
		//���
		DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress("10.16.183.188", 6666));
		
		try {
			DatagramSocket ds = new DatagramSocket(9999);  //�ͻ��˵Ķ˿ں�
			ds.send(dp);
			
			ds.close();  //�ر��ڴ�
		} catch (SocketException e) {  //��DatagramSocket()�׳�
			e.printStackTrace();
		} catch (IOException e) {  //��send()�׳�
			e.printStackTrace();
		}
	}

}
