package shuzizifuchuan;
import exception.IndexIsNagetiveException;
import exception.IndexIsOutofRangeException;
public class MyStringBuffer implements IStringBuffer {
	char[] chars=new char[19];
	int length=0;//��¼�ַ��������ַ��ĳ��ȶ���������ĳ���
	//�ַ����鶯̬����,����x������
	int capacity=19;//��¼�ڲ��ַ����������
	public void Kuorong(int x) {
		char[] str=new char[this.capacity+x];
		System.arraycopy(this.chars, 0, str, 0, this.length);
		this.chars=str;
		this.capacity+=x;
	}
	
	//�޲������췽��
	public MyStringBuffer() {
		// TODO �Զ����ɵĹ��캯�����
		
	}
	//�вι��췽��
	public MyStringBuffer(String str) {
		if(str.length()>19){Kuorong(str.length()+19-this.capacity);}
		System.arraycopy(str.toCharArray(),0,this.chars,0,str.length());
		this.length=str.length();
	}

	@Override
	public void append(String str) {
		// TODO �Զ����ɵķ������
		if(str.length()+this.length>this.capacity)Kuorong(str.length());
		System.arraycopy(str.toCharArray(),0,this.chars,this.length,str.length());
		this.length+=str.length();
	}

	@Override
	public void append(char c) {
		// TODO �Զ����ɵķ������
		if(this.length+1>this.capacity)Kuorong(19);
		this.chars[this.length]=c;
		this.length+=1;
	}
	@Override
	public void insert(int pos, char b) throws IndexIsNagetiveException{
		// TODO �Զ����ɵķ������
		//�쳣����
		if(pos<0)throw new IndexIsNagetiveException();
		if(this.length+1>this.capacity)Kuorong(19);
		char temp[]=new char[this.length];
		System.arraycopy(this.chars,pos,temp,0,this.length-pos);
		this.chars[pos]=b;
		System.arraycopy(temp,0,this.chars,pos+1,this.length-pos);
		this.length+=1;
	}

	@Override
	public void insert(int pos, String b) throws IndexIsNagetiveException {
		// TODO �Զ����ɵķ������
		//�쳣����
		if(pos<0)throw new IndexIsNagetiveException();
		if(b.length()+this.length>this.capacity)Kuorong(b.length());
		char temp[]=this.chars.clone();
		System.arraycopy(b.toCharArray(),0,this.chars,pos,b.length());
		System.arraycopy(temp,pos,this.chars,pos+b.length(),this.length-pos);
		this.length+=b.length();
	}

	@Override
	public void delete(int start) {
		// TODO �Զ����ɵķ������
		this.length=start;
	}

	@Override
	public void delete(int start, int end) throws IndexIsNagetiveException,IndexIsOutofRangeException{
		// TODO �Զ����ɵķ������
		//�쳣����
		if(start<0||end<0)throw new IndexIsNagetiveException();
		if(end>=this.length||start>=end)throw new IndexIsOutofRangeException();
		
		if(end==this.length-1)this.length=start;
		else {
			System.arraycopy(this.chars,end+1,this.chars,start,this.length-end-1);
			this.length=start+(this.length-end-1);
		}
	}

	@Override
	public void reverse() {
		// TODO �Զ����ɵķ������
		int j=this.length/2;
		char tmp;//��ʱ����
		for(int i=this.length-1;i>=j;i--) {
			tmp=this.chars[i];
			this.chars[i]=this.chars[this.length-1-i];
			this.chars[this.length-1-i]=tmp;
		}
	}

	@Override
	public int length() {
		// TODO �Զ����ɵķ������
		return this.length;
	}
	
	public void shuchu() {
		for(int i=0;i<this.length;i++) {
			System.out.print(this.chars[i]+" ");
		}
		System.out.printf("%n");
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String str1 = "let there ";
		 
		MyStringBuffer msb = new MyStringBuffer(); //����str1����һ��StringBuffer����
        msb.append("be lightabcdefghijk"); //�����׷��
        msb.shuchu();
        //�Զ����쳣�����±�Ϊ���쳣
        try {
        msb.delete(12, 10);//ɾ��4-10֮����ַ�
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
