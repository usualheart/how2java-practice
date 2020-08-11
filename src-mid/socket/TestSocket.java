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
    	//System.out.println(getLocalIPList());//��ȡ���б���ipv4��ַ �����
    	testnet();
    }

    public static void testIP() throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        String ip =host.getHostAddress();
        System.out.println("����ip��ַ��" + ip);
    }
    public static String testPing(String ip) throws IOException {
    	
    	//���� Runtime.getRuntime().exec() ��������һ��windows��exe����
        Process p = Runtime.getRuntime().exec("ping " + ip);
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (line.length() != 0)
                sb.append(line + "\r\n");
        }
        return sb.toString();
        //System.out.println("����ָ��ص���Ϣ�ǣ�");
        //System.out.println(sb.toString());
    }
    //��ȡ��������ipv4�ĵ�ַ ��list��ʽ����
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
    
    //����ĳ������ip��ַ�Ƿ������ͨ��ping)
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
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
			    	System.out.print(ip+"���Խ�����"+ii);
			    	if(result.contains("�޷�����")||result.contains("��ʱ")) {
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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
    	}
    	System.out.println("��"+al.size()+"���������ӵ�ip��");
    	for(String ip:al) {
    		System.out.println(ip);
    	}
    }
}