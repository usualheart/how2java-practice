package multiplethread;
import java.util.ArrayList;
import java.util.Vector;

import shuzizifuchuan.PojieMima;
public class PojieMultipleThread {
	
	public static void main(String[]args) {
	
		String code=PojieMima.suistr(3);//生成三位数的密码
		//String code="AAC";
		System.out.println("准备好的密码是："+code);
		Vector<String>vcode=new Vector<String>();
		//boolean flag=false;
		//ArrayList<String> wrongcode=new ArrayList<String>();//不同步 无法使用
		Thread qiongju=new Thread() {
			public void run() {
				char[]tmp=new char[3];
				for1://设置for循环标志，可以 让break直接跳出外层循环
				for(int i=0;i<62;i++) {
					tmp[0]=PojieMima.yingshe(i);
					for(int j=0;j<62;j++) {
						tmp[1]=PojieMima.yingshe(j);
						for(int k=0;k<62;k++) {
							tmp[2]=PojieMima.yingshe(k);
							String str=new String(tmp);
							
							//System.out.printf("生成：%s\t",str);
							//if(k%3==0)System.out.println();
							if(str.equals(code)) {System.out.println("密码破解成功，即将停止破解，密码是："+str);break for1;}
							else vcode.add(str);
						}
					}
				}
			}
		};
		qiongju.start();
		Thread rizhi=new Thread() {
			public void run() {
				int count=0;
				while(true) {
					if(vcode.isEmpty())
						try {
							Thread.sleep(1000);
							
							System.out.println("等待新的密码...");
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					else {
						count++;
						String tmp=vcode.remove(0);
						System.out.printf("%s\t",tmp);
						if(count%10==0)System.out.println();
					}
				}
			}
		};
		rizhi.setDaemon(true);//设置为守护进程，若只有这一个进程则会自动关闭
		rizhi.start();
	}
}
