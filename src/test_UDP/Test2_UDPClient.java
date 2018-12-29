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
		
		//将一个long类型的数转化为字节数组
		long n = 245467876543345L;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();  //在内存中创建一个字节数组。见IO章，TestDataStream
		DataOutputStream dos = new DataOutputStream(baos);
		try {
			dos.writeLong(n);  //将n写入内存中的字节数组
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		byte buf[] = baos.toByteArray();
		//System.out.println(buf.length);  //打印出来是8。表明生成的在内存里的字节数组是有多少数据，就分配多大空间
		//打包
		DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress("10.16.183.188", 7777));
		
		try {
			DatagramSocket ds = new DatagramSocket(8888);  //端口号
			ds.send(dp);
			ds.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
