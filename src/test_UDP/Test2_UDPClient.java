package test_UDP;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Test2_UDPClient {

	public static void main(String[] args) {
		
		//��һ��long���͵���ת��Ϊ�ֽ�����
		long n = 245467876543345L;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();  //���ڴ��д���һ���ֽ����顣��IO�£�TestDataStream
		DataOutputStream dos = new DataOutputStream(baos);
		try {
			dos.writeLong(n);  //��nд���ڴ��е��ֽ�����
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		byte buf[] = baos.toByteArray();
		//System.out.println(buf.length);  //��ӡ������8���������ɵ����ڴ�����ֽ��������ж������ݣ��ͷ�����ռ�
		//���
		DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress("10.16.183.188", 7777));
		
		try {
			DatagramSocket ds = new DatagramSocket(8888);  //�˿ں�
			ds.send(dp);
			ds.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
