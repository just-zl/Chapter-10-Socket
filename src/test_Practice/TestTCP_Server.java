package test_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//实现服务器端与客户端的通信
public class TestTCP_Server {

	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(5678);
			Socket socket = ss.accept();
			
			//接收客户端的数据
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("Client:" + br.readLine());
			
			//向客户端发送数据
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//从控制台接受信息，传递给pw
			BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
			
			String string = bReader.readLine();
			while(!string.equalsIgnoreCase("bye")) {
				pw.println(string);
				pw.flush();
				System.out.println("Client:" + string);
				System.out.println("Server:" + br.readLine());
				string = bReader.readLine();
			}
			
		
			//关闭内存
			ss.close();br.close();pw.close();bReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
