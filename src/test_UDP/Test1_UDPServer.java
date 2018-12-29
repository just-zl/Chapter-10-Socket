package test_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Test1_UDPServer {

	public static void main(String[] args) {

		//�ֽ�����������
		byte buf[] = new byte[1024];  //1024���ֽڣ�1KB
		
		//���տͻ�������
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		
		try {
			DatagramSocket ds = new DatagramSocket(6666);  //UDP��Ķ˿ںź�TCP��Ķ˿ںŻ���Ӱ��
			
			while(true) {
				ds.receive(dp);
				System.out.println(new String(buf,0,dp.getLength()));  //dp.getLength()��ʵ��ռ���˶��Ŀռ�
				//ds.close();  //Ϊʲô�ر��ڴ�ᱣ��
			}
			
		} catch (SocketException e) {  //��DatagramSocket()�׳�
			e.printStackTrace();
		} catch (IOException e) {  //��receive()�׳�
			e.printStackTrace();
		}
	}

}
