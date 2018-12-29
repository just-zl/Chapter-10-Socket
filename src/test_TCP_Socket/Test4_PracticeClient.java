package test_TCP_Socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test4_PracticeClient {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("10.16.183.188", 2580);
			
			//д����
			OutputStream os = socket.getOutputStream();
			//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
			//bw.write("asdhuaih");
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
			
			//������
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			//�ڿ���̨��������
			BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
			String string = bReader.readLine();
			
			while(!string.equalsIgnoreCase("bye")) {
				pw.println(string);
				pw.flush();
				System.out.println("Server:" + br.readLine());
				System.out.println("Client:" + string);
				string = bReader.readLine();
			}
			
			pw.close();os.close();socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
