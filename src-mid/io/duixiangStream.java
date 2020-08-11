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
    //序列化对象数组，并读取
	public static void xuliehuaArray() {
		HeroIO [] heroArray=new HeroIO[10];
		System.out.println("初始化英雄");
		for(int i=0;i<10;i++) {
			heroArray[i]=new HeroIO();
			heroArray[i].name="garen"+i;
			heroArray[i].hp=100+i;
			System.out.printf("name:%s hp:%.2f%n",heroArray[i].name,heroArray[i].hp);
		}
		
		//准备一个文件用于保存该对象
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
			//从文件读取对象
			HeroIO [] heroRecoverArray=new HeroIO[10];
			System.out.println("从文件读取的英雄：");
			for(int i=0;i<10;i++) {
				heroRecoverArray[i]=(HeroIO) ois.readObject();
				//输出每个对象的属性
				System.out.printf("name:%s hp:%.2f%n",heroRecoverArray[i].name,heroRecoverArray[i].hp);
			}
			
		}
		catch(IOException | ClassNotFoundException e) {
			
		}
	}
    
    
    //对象流测试
    public static void test() {
        //创建一个Hero garen
        //要把Hero对象直接保存在文件上，务必让Hero类实现Serializable接口
        HeroIO h = new HeroIO();
        h.name = "garen";
        h.hp = 616;
          
        //准备一个文件用于保存该对象
        File f =new File("d:/java-test/garen.lol");
 
        try(
            //创建对象输出流
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos =new ObjectOutputStream(fos);
            //创建对象输入流              
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