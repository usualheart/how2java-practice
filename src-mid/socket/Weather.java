package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class Weather extends Thread{
	String weather="你好，这里是广播！";
	int port=3348;
	InetAddress iaddress=null;
	MulticastSocket socket=null;
	
	public Weather() {
		try {
			iaddress=InetAddress.getByName("224.255.10.0");
			socket=new MulticastSocket(port);
			socket.setTimeToLive(1);//指定发送范围是本地网络
			socket.joinGroup(iaddress);//加入广播组
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	public void run() {
		while(true) {
			DatagramPacket packet=null;//生命datagramPacket方法
			
			byte data[]=weather.getBytes();
			packet=new DatagramPacket(data, data.length, iaddress, port);
			System.out.println(weather);
			try {
				socket.send(packet);
				sleep(3000);
			} catch (IOException | InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Weather w=new Weather();
		w.start();
	}

}
