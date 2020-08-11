package io;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class WenjianJiamiJiemi {
	//文件加密
	public static void encodeFile(File encodingFile, File encodedFile) {
		try(FileReader fr=new FileReader(encodingFile);FileWriter fw=new FileWriter(encodedFile)){
			char[] before=new char[(int) encodingFile.length()];
			fr.read(before);
			for(int i=0;i<before.length;i++) {
				if((before[i]<='8'&&before[i]>='0')||(before[i]<='y'&&before[i]>='a')||(before[i]<='Y'&&before[i]>='A'))before[i]+=1;
				else if(before[i]=='9')before[i]='0';
				else if(before[i]=='z')before[i]='a';
				else if(before[i]=='Z')before[i]='A';
			}
			fw.write(before);
			System.out.println("加密成功!");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	//对应的文件解密
	public static void decodeFile(File decodingFile, File decodedFile) {
		try(FileReader fr=new FileReader(decodingFile);FileWriter fw=new FileWriter(decodedFile)){
			char[] before=new char[(int) decodingFile.length()];
			fr.read(before);
			for(int i=0;i<before.length;i++) {
				if(before[i]<='9'&&before[i]>='1')before[i]-=1;
				else if(before[i]=='0')before[i]='9';
				else if((before[i]<='z'&&before[i]>='b')||(before[i]<='Z'&&before[i]>='B'))before[i]-=1;
				else if(before[i]=='a')before[i]='z';
				else if(before[i]=='A')before[i]='Z';
			}
			fw.write(before);
			System.out.println("解密成功!");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		File before=new File("D:/Animal.java");
		File after=new File(before.getParent()+"/encoded-"+before.getName());
		encodeFile(before,after);
		File decoded=new File(before.getParent()+"/decoded-"+before.getName());
		decodeFile(after,decoded);
	}

}
