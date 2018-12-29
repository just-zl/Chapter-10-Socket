package test_UDP;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//从客户端传入一个long类型的数，然后将这个long类型的数转换成long类型并打印出来
public class Test2_UDPServer {

	public static void main(String[] args) {
		
		//保存读取到的数据
		byte buf[] = new byte[1024];
		
		//接收数据，放入字节数组
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		try {
			DatagramSocket ds = new DatagramSocket(7777);
			while(true) {
				ds.receive(dp);
				//System.out.println(new String(buf,0,dp.getLength()));  //打印出来是乱码字符串，应转化成long类型
				
				//ByteArrayInputStream bais = new ByteArrayInputStream(dp.getData());  //dp.getData()是一个byte类型的数组
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
