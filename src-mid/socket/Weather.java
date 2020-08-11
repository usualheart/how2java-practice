package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class Weather extends Thread{
	String weather="��ã������ǹ㲥��";
	int port=3348;
	InetAddress iaddress=null;
	MulticastSocket socket=null;
	
	public Weather() {
		try {
			iaddress=InetAddress.getByName("224.255.10.0");
			socket=new MulticastSocket(port);
			socket.setTimeToLive(1);//ָ�����ͷ�Χ�Ǳ�������
			socket.joinGroup(iaddress);//����㲥��
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	public void run() {
		while(true) {
			DatagramPacket packet=null;//����datagramPacket����
			
			byte data[]=weather.getBytes();
			packet=new DatagramPacket(data, data.length, iaddress, port);
			System.out.println(weather);
			try {
				socket.send(packet);
				sleep(3000);
			} catch (IOException | InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Weather w=new Weather();
		w.start();
	}

}
