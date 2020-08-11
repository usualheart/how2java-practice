package collection;
import java.util.ArrayList;
import exception.IndexIsNagetiveException;
import exception.IndexIsOutofRangeException;
import shuzizifuchuan.IStringBuffer;
public class MyStringBufferCollection implements IStringBuffer {
	
	ArrayList<Character> msbc=new ArrayList<Character>();
	
	//�޲������췽��
	public MyStringBufferCollection() {
		// TODO �Զ����ɵĹ��캯�����
		
	}
	//�вι��췽��
	public MyStringBufferCollection(String str) {
		append(str);
	}
	@Override
	public void append(String str) {
		// TODO �Զ����ɵķ������
		char strChar[]=str.toCharArray();
		for(char tmp:strChar) {
			msbc.add(tmp);
		}
	}

	@Override
	public void append(char c) {
		// TODO �Զ����ɵķ������
		msbc.add(c);
	}

	@Override
	public void insert(int pos, char b) throws IndexIsNagetiveException {
		// TODO �Զ����ɵķ������
		if(pos<0)throw new IndexIsNagetiveException();
		msbc.add(pos,b);
	}

	@Override
	public void insert(int pos, String b) throws IndexIsNagetiveException {
		// TODO �Զ����ɵķ������
		if(pos<0)throw new IndexIsNagetiveException();
		char strChar[]=b.toCharArray();
		for(int i=0;i<strChar.length;i++) {
			msbc.add(pos+i,strChar[i]);
		}
	}

	@Override
	public void delete(int start) {
		// TODO �Զ����ɵķ������
		for(int i=start;i<msbc.size();i++) {
			msbc.remove(i);
		}
	}

	@Override
	public void delete(int start, int end) throws IndexIsNagetiveException, IndexIsOutofRangeException {
		// TODO �Զ����ɵķ������

		if(start<0)throw new IndexIsNagetiveException();
		if(end>=msbc.size())throw new IndexIsOutofRangeException();
		for(int i=start;i<end;i++) {
			msbc.remove(start);
		}
	}

	@Override
	public void reverse() {
		// TODO �Զ����ɵķ������
		int j=msbc.size()/2;
		char tmp;//��ʱ����
		for(int i=msbc.size()-1;i>=j;i--) {
			tmp=msbc.get(i);
			msbc.set(i,msbc.get(msbc.size()-1-i));
			msbc.set(msbc.size()-1-i,tmp);
		}
	}

	@Override
	public int length() {
		// TODO �Զ����ɵķ������
		return msbc.size();
	}
	public void shuchu() {
		System.out.println(msbc);
	}

	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String str1 = "let there ";
		 
		MyStringBufferCollection msb = new MyStringBufferCollection(); //����str1����һ��StringBuffer����
        msb.append("be lightabcdefghijk"); //�����׷��
        msb.shuchu();
        //�Զ����쳣�����±�Ϊ���쳣
        try {
        msb.delete(4, 10);//ɾ��4-10֮����ַ�
        msb.shuchu();
        msb.insert(0, "ffM");//��4���λ�ò��� there
        }
        catch(IndexIsNagetiveException |IndexIsOutofRangeException e){
        	System.out.println("�쳣�ľ���ԭ��:"+e.getMessage());
            e.printStackTrace();
        }
        msb.shuchu();
        msb.reverse(); //��ת
        msb.shuchu();
	}

}
