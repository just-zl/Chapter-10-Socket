package test_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

//通过UDP实现服务器端和客户端的连接
public class Test1_UDPClient {

	public static void main(String[] args) {
		
		//字节数组存放数据
		byte buf[] = (new String("Hello,ZL!")).getBytes();  //将字符串转换为字节数组
		
		//打包
		DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress("10.16.183.188", 6666));
		
		try {
			DatagramSocket ds = new DatagramSocket(9999);  //客户端的端口号
			ds.send(dp);
			
			ds.close();  //关闭内存
		} catch (SocketException e) {  //由DatagramSocket()抛出
			e.printStackTrace();
		} catch (IOException e) {  //由send()抛出
			e.printStackTrace();
		}
	}

}
