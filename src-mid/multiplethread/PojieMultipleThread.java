package multiplethread;
import java.util.ArrayList;
import java.util.Vector;

import shuzizifuchuan.PojieMima;
public class PojieMultipleThread {
	
	public static void main(String[]args) {
	
		String code=PojieMima.suistr(3);//������λ��������
		//String code="AAC";
		System.out.println("׼���õ������ǣ�"+code);
		Vector<String>vcode=new Vector<String>();
		//boolean flag=false;
		//ArrayList<String> wrongcode=new ArrayList<String>();//��ͬ�� �޷�ʹ��
		Thread qiongju=new Thread() {
			public void run() {
				char[]tmp=new char[3];
				for1://����forѭ����־������ ��breakֱ���������ѭ��
				for(int i=0;i<62;i++) {
					tmp[0]=PojieMima.yingshe(i);
					for(int j=0;j<62;j++) {
						tmp[1]=PojieMima.yingshe(j);
						for(int k=0;k<62;k++) {
							tmp[2]=PojieMima.yingshe(k);
							String str=new String(tmp);
							
							//System.out.printf("���ɣ�%s\t",str);
							//if(k%3==0)System.out.println();
							if(str.equals(code)) {System.out.println("�����ƽ�ɹ�������ֹͣ�ƽ⣬�����ǣ�"+str);break for1;}
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
							
							System.out.println("�ȴ��µ�����...");
						} catch (InterruptedException e) {
							// TODO �Զ����ɵ� catch ��
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
		rizhi.setDaemon(true);//����Ϊ�ػ����̣���ֻ����һ����������Զ��ر�
		rizhi.start();
	}
}
