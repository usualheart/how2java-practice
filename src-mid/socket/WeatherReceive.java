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
			socket.joinGroup(group);//加入广播组
			System.out.print("准备就绪...");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	//接收广播的线程
	public void run() {
		while(true) {
			byte[] data=new byte[1024];
			DatagramPacket packet=null;
			packet=new DatagramPacket(data, data.length, group, port);
			try {
				socket.receive(packet);
				//System.out.println("接受到信息：");
				String mes=new String(packet.getData(),0,packet.getLength());//packet.getLength()返回接收到的数据包的真实长度
				System.out.println(mes);
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		WeatherReceive wr=new WeatherReceive();
		wr.start();
				
	}

}
