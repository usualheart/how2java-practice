package shuzizifuchuan;

import exception.IndexIsNagetiveException;
import exception.IndexIsOutofRangeException;

public interface IStringBuffer {
	
	    public void append(String str); //׷���ַ��� 
	    public void append(char c);  //׷���ַ�
	    public void insert(int pos,char b) throws IndexIsNagetiveException; //ָ��λ�ò����ַ�
	    public void insert(int pos,String b) throws IndexIsNagetiveException; //ָ��λ�ò����ַ���
	    public void delete(int start); //�ӿ�ʼλ��ɾ��ʣ�µ�
	    public void delete(int start,int end) throws IndexIsNagetiveException, IndexIsOutofRangeException; //�ӿ�ʼλ��ɾ������λ��-1
	    public void reverse(); //��ת
	    public int length(); //���س���

}
