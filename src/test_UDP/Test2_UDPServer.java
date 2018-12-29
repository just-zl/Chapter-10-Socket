package test_UDP;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//�ӿͻ��˴���һ��long���͵�����Ȼ�����long���͵���ת����long���Ͳ���ӡ����
public class Test2_UDPServer {

	public static void main(String[] args) {
		
		//�����ȡ��������
		byte buf[] = new byte[1024];
		
		//�������ݣ������ֽ�����
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		try {
			DatagramSocket ds = new DatagramSocket(7777);
			while(true) {
				ds.receive(dp);
				//System.out.println(new String(buf,0,dp.getLength()));  //��ӡ�����������ַ�����Ӧת����long����
				
				//ByteArrayInputStream bais = new ByteArrayInputStream(dp.getData());  //dp.getData()��һ��byte���͵�����
				ByteArrayInputStream bais = new ByteArrayInputStream(buf);
				DataInputStream dis = new DataInputStream(bais);
				System.out.println(dis.readLong());
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
