package test_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//ʵ�ַ���������ͻ��˵�ͨ��
public class TestTCP_Server {

	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(5678);
			Socket socket = ss.accept();
			
			//���տͻ��˵�����
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("Client:" + br.readLine());
			
			//��ͻ��˷�������
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//�ӿ���̨������Ϣ�����ݸ�pw
			BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
			
			String string = bReader.readLine();
			while(!string.equalsIgnoreCase("bye")) {
				pw.println(string);
				pw.flush();
				System.out.println("Client:" + string);
				System.out.println("Server:" + br.readLine());
				string = bReader.readLine();
			}
			
		
			//�ر��ڴ�
			ss.close();br.close();pw.close();bReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
