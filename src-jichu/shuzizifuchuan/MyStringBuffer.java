package shuzizifuchuan;
import exception.IndexIsNagetiveException;
import exception.IndexIsOutofRangeException;
public class MyStringBuffer implements IStringBuffer {
	char[] chars=new char[19];
	int length=0;//记录字符数组中字符的长度而不是数组的长度
	//字符数组动态扩容,增加x个容量
	int capacity=19;//记录内部字符数组的容量
	public void Kuorong(int x) {
		char[] str=new char[this.capacity+x];
		System.arraycopy(this.chars, 0, str, 0, this.length);
		this.chars=str;
		this.capacity+=x;
	}
	
	//无参数构造方法
	public MyStringBuffer() {
		// TODO 自动生成的构造函数存根
		
	}
	//有参构造方法
	public MyStringBuffer(String str) {
		if(str.length()>19){Kuorong(str.length()+19-this.capacity);}
		System.arraycopy(str.toCharArray(),0,this.chars,0,str.length());
		this.length=str.length();
	}

	@Override
	public void append(String str) {
		// TODO 自动生成的方法存根
		if(str.length()+this.length>this.capacity)Kuorong(str.length());
		System.arraycopy(str.toCharArray(),0,this.chars,this.length,str.length());
		this.length+=str.length();
	}

	@Override
	public void append(char c) {
		// TODO 自动生成的方法存根
		if(this.length+1>this.capacity)Kuorong(19);
		this.chars[this.length]=c;
		this.length+=1;
	}
	@Override
	public void insert(int pos, char b) throws IndexIsNagetiveException{
		// TODO 自动生成的方法存根
		//异常处理
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
		// TODO 自动生成的方法存根
		//异常处理
		if(pos<0)throw new IndexIsNagetiveException();
		if(b.length()+this.length>this.capacity)Kuorong(b.length());
		char temp[]=this.chars.clone();
		System.arraycopy(b.toCharArray(),0,this.chars,pos,b.length());
		System.arraycopy(temp,pos,this.chars,pos+b.length(),this.length-pos);
		this.length+=b.length();
	}

	@Override
	public void delete(int start) {
		// TODO 自动生成的方法存根
		this.length=start;
	}

	@Override
	public void delete(int start, int end) throws IndexIsNagetiveException,IndexIsOutofRangeException{
		// TODO 自动生成的方法存根
		//异常处理
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
		// TODO 自动生成的方法存根
		int j=this.length/2;
		char tmp;//临时对象
		for(int i=this.length-1;i>=j;i--) {
			tmp=this.chars[i];
			this.chars[i]=this.chars[this.length-1-i];
			this.chars[this.length-1-i]=tmp;
		}
	}

	@Override
	public int length() {
		// TODO 自动生成的方法存根
		return this.length;
	}
	
	public void shuchu() {
		for(int i=0;i<this.length;i++) {
			System.out.print(this.chars[i]+" ");
		}
		System.out.printf("%n");
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String str1 = "let there ";
		 
		MyStringBuffer msb = new MyStringBuffer(); //根据str1创建一个StringBuffer对象
        msb.append("be lightabcdefghijk"); //在最后追加
        msb.shuchu();
        //自定义异常捕获下标为负异常
        try {
        msb.delete(12, 10);//删除4-10之间的字符
        msb.shuchu();
        msb.insert(0, "ffM");//在4这个位置插入 there
        }
        catch(IndexIsNagetiveException |IndexIsOutofRangeException e){
        	System.out.println("异常的具体原因:"+e.getMessage());
            e.printStackTrace();
        }
        msb.shuchu();
        msb.reverse(); //反转
        msb.shuchu();
	}

}
