package test_TCP_Socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

//客户端
public class Test1_TCPClient1 {

	public static void main(String[] args) {
		
		try {
			Socket s = new Socket("10.16.183.188", 6666);  //参数依次为：本机ip，请求连接的端口
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF("Hello,Server!");  //使用改良的UTF-8编码将字符串写入底层输出流
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
