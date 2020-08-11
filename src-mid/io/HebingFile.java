package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HebingFile {
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String str="D:/xyz/img.jpg";
        //准备一个大于100k的文件，通过流读入文件到byte数组
        File f =new File(str);
        File[] fs=f.getParentFile().listFiles();
        for(File i:fs) {
        	System.out.println(i.getName());
        }

        /*
        //按最后修改日期排序
        Arrays.sort(fs,new Comparator< File>(){
            public int compare(File f1, File f2) {
       	long diff = f1.lastModified() - f2.lastModified();
       	if (diff > 0)
       	  return 1;
       	else if (diff == 0)
       	  return 0;
       	else
       	  return -1;
            }
            public boolean equals(Object obj) {
       	return true;
            }
       		
            });*/
        
        //按名称排序
        List files = Arrays.asList(fs);
        Arrays.sort(fs, new Comparator< File>() {
         @Override
         public int compare(File o1, File o2) {
      	if (o1.isDirectory() && o2.isFile())
                return -1;
      	if (o1.isFile() && o2.isDirectory())
                return 1;
      	//将文件名转化为整型数字，然后及逆行比较并返回比较结果
      	return Integer.valueOf(o1.getName()).compareTo(Integer.valueOf(o2.getName()));
        }
       
        });

        
		
        File fhe=new File(f.getParentFile().getAbsolutePath()+"/he.zip");
      //把流定义在try()里,try,catch或者finally结束的时候，会自动关闭
		try (FileOutputStream fos=new FileOutputStream(fhe)){
            
            for(File i:fs) {
	            //创建基于文件的输入流
            	System.out.println("合并"+i.getName());
	            FileInputStream fis =new FileInputStream(i);
	            //创建字节数组，其长度就是文件的长度
	            byte[] tmp =new byte[(int) i.length()];
	            //以字节流的形式读取文件所有内容
	            fis.read(tmp);
	            //每次使用完流，都应该进行关闭
	            fis.close();
	            fos.write(tmp);
            }
            // 关闭输出流,流定义在try()里，会自动关闭
	       // fos.close();
            System.out.println("文件合成成功！"); 
              
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
