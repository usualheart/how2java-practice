package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class WeatherReceive extends Thread{
	int port=3348;
	InetAddress group=null;
	MulticastSocket socket=null;
	public WeatherReceive() {
		try {
			group=InetAddress.getByName("224.255.10.0");
			socket=new MulticastSocket(port);
			socket.joinGroup(group);//����㲥��
			System.out.print("׼������...");
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	//���չ㲥���߳�
	public void run() {
		while(true) {
			byte[] data=new byte[1024];
			DatagramPacket packet=null;
			packet=new DatagramPacket(data, data.length, group, port);
			try {
				socket.receive(packet);
				//System.out.println("���ܵ���Ϣ��");
				String mes=new String(packet.getData(),0,packet.getLength());//packet.getLength()���ؽ��յ������ݰ�����ʵ����
				System.out.println(mes);
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		WeatherReceive wr=new WeatherReceive();
		wr.start();
				
	}

}
