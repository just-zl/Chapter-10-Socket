package test_TCP_Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//ʵ�ַ���������ͻ��˵�ʵʱͨ��
public class Test4_PracticeServer {

	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(2580);
			Socket socket = ss.accept();
			
			//��������
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			System.out.println("Client:"+br.readLine());
			
			//��������
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//�ڿ���̨��������
			BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
			String string = bReader.readLine();
			
			while(!string.equalsIgnoreCase("bye")) {
				pw.println(string);
				pw.flush();
				System.out.println("Server:" + string);
				System.out.println("Client:" + br.readLine());
				string = bReader.readLine();
			}
			
			br.close();socket.close();ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
