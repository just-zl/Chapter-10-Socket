package test_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestTCP_Client {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("10.16.183.188", 5678);
			
			//��������˴�������
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//���շ�����������
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//�Ӽ��̶�ȡ����
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
			socket.close();pw.close();br.close();bReader.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
