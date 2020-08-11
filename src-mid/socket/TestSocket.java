package socket;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
 
public class TestSocket {
    public static void main(String[] args) throws IOException {
    	//testIP();
    	//testPing("172.16.100.1");
    	//System.out.println(getLocalIPList());//获取所有本机ipv4地址 并输出
    	testnet();
    }

    public static void testIP() throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        String ip =host.getHostAddress();
        System.out.println("本机ip地址：" + ip);
    }
    public static String testPing(String ip) throws IOException {
    	
    	//借助 Runtime.getRuntime().exec() 可以运行一个windows的exe程序
        Process p = Runtime.getRuntime().exec("ping " + ip);
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (line.length() != 0)
                sb.append(line + "\r\n");
        }
        return sb.toString();
        //System.out.println("本次指令返回的消息是：");
        //System.out.println(sb.toString());
    }
    //获取本机所有ipv4的地址 以list形式返回
    public static List<String> getLocalIPList() {
        List<String> ipList = new ArrayList<String>();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            NetworkInterface networkInterface;
            Enumeration<InetAddress> inetAddresses;
            InetAddress inetAddress;
            String ip;
            while (networkInterfaces.hasMoreElements()) {
                networkInterface = networkInterfaces.nextElement();
                inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    inetAddress = inetAddresses.nextElement();
                    if (inetAddress != null && inetAddress instanceof Inet4Address) { // IPV4
                        ip = inetAddress.getHostAddress();
                        ipList.add(ip);
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return ipList;
    }
    
    //测试某网络中ip地址是否可以连通（ping)
    public static void testnet() throws IOException {
    	ArrayList<String> al=new ArrayList<String>();
    	
    	Thread pings[]=new Thread[255];
    	for(int i=1;i<=255;i++) {
    		final int ii=i;
    		Thread tmp=new Thread(){
	    		public void run() {
		    		String ip="172.16.1."+ii;
			    	String result = null;
					try {
						result = testPing(ip);
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
			    	System.out.print(ip+"测试结束，"+ii);
			    	if(result.contains("无法访问")||result.contains("超时")) {
			    		System.out.println(" WRONG");
			    		
			    	}
			    	else {
			    		System.out.println(" OK");
			    		al.add(ip);
			    	}
	    		}
    		};
    		tmp.start();
    		pings[i-1]=tmp;
        }
    	for(Thread tmp:pings) {
    		try {
				tmp.join();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
    	}
    	System.out.println("共"+al.size()+"个可以连接的ip：");
    	for(String ip:al) {
    		System.out.println(ip);
    	}
    }
}