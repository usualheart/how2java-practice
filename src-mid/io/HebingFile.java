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
		// TODO �Զ����ɵķ������
		String str="D:/xyz/img.jpg";
        //׼��һ������100k���ļ���ͨ���������ļ���byte����
        File f =new File(str);
        File[] fs=f.getParentFile().listFiles();
        for(File i:fs) {
        	System.out.println(i.getName());
        }

        /*
        //������޸���������
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
        
        //����������
        List files = Arrays.asList(fs);
        Arrays.sort(fs, new Comparator< File>() {
         @Override
         public int compare(File o1, File o2) {
      	if (o1.isDirectory() && o2.isFile())
                return -1;
      	if (o1.isFile() && o2.isDirectory())
                return 1;
      	//���ļ���ת��Ϊ�������֣�Ȼ�����бȽϲ����رȽϽ��
      	return Integer.valueOf(o1.getName()).compareTo(Integer.valueOf(o2.getName()));
        }
       
        });

        
		
        File fhe=new File(f.getParentFile().getAbsolutePath()+"/he.zip");
      //����������try()��,try,catch����finally������ʱ�򣬻��Զ��ر�
		try (FileOutputStream fos=new FileOutputStream(fhe)){
            
            for(File i:fs) {
	            //���������ļ���������
            	System.out.println("�ϲ�"+i.getName());
	            FileInputStream fis =new FileInputStream(i);
	            //�����ֽ����飬�䳤�Ⱦ����ļ��ĳ���
	            byte[] tmp =new byte[(int) i.length()];
	            //���ֽ�������ʽ��ȡ�ļ���������
	            fis.read(tmp);
	            //ÿ��ʹ����������Ӧ�ý��йر�
	            fis.close();
	            fos.write(tmp);
            }
            // �ر������,��������try()����Զ��ر�
	       // fos.close();
            System.out.println("�ļ��ϳɳɹ���"); 
              
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
