package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;   
public class duixiangStream {
	
	public static void main(String[] args) {
		//test();
		xuliehuaArray();
	}
    //���л��������飬����ȡ
	public static void xuliehuaArray() {
		HeroIO [] heroArray=new HeroIO[10];
		System.out.println("��ʼ��Ӣ��");
		for(int i=0;i<10;i++) {
			heroArray[i]=new HeroIO();
			heroArray[i].name="garen"+i;
			heroArray[i].hp=100+i;
			System.out.printf("name:%s hp:%.2f%n",heroArray[i].name,heroArray[i].hp);
		}
		
		//׼��һ���ļ����ڱ���ö���
		File f =new File("d:/java-test/heros.lol");
		try(
			FileOutputStream fos=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			FileInputStream fis=new FileInputStream(f);
			ObjectInputStream ois=new ObjectInputStream(fis);
			){
			for(HeroIO h:heroArray) {
				oos.writeObject(h);
			}
			//���ļ���ȡ����
			HeroIO [] heroRecoverArray=new HeroIO[10];
			System.out.println("���ļ���ȡ��Ӣ�ۣ�");
			for(int i=0;i<10;i++) {
				heroRecoverArray[i]=(HeroIO) ois.readObject();
				//���ÿ�����������
				System.out.printf("name:%s hp:%.2f%n",heroRecoverArray[i].name,heroRecoverArray[i].hp);
			}
			
		}
		catch(IOException | ClassNotFoundException e) {
			
		}
	}
    
    
    //����������
    public static void test() {
        //����һ��Hero garen
        //Ҫ��Hero����ֱ�ӱ������ļ��ϣ������Hero��ʵ��Serializable�ӿ�
        HeroIO h = new HeroIO();
        h.name = "garen";
        h.hp = 616;
          
        //׼��һ���ļ����ڱ���ö���
        File f =new File("d:/java-test/garen.lol");
 
        try(
            //�������������
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos =new ObjectOutputStream(fos);
            //��������������              
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois =new ObjectInputStream(fis);
        ) {
            oos.writeObject(h);
            HeroIO h2 = (HeroIO) ois.readObject();
            System.out.println(h2.name);
            System.out.println(h2.hp);
               
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            
    }
}