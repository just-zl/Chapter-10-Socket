package test_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Test1_UDPServer {

	public static void main(String[] args) {

		//字节数组存放数据
		byte buf[] = new byte[1024];  //1024个字节，1KB
		
		//接收客户端数据
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		
		try {
			DatagramSocket ds = new DatagramSocket(6666);  //UDP里的端口号和TCP里的端口号互不影响
			
			while(true) {
				ds.receive(dp);
				System.out.println(new String(buf,0,dp.getLength()));  //dp.getLength()是实际占用了多大的空间
				//ds.close();  //为什么关闭内存会保错
			}
			
		} catch (SocketException e) {  //由DatagramSocket()抛出
			e.printStackTrace();
		} catch (IOException e) {  //由receive()抛出
			e.printStackTrace();
		}
	}

}
