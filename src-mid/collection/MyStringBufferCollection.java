package collection;
import java.util.ArrayList;
import exception.IndexIsNagetiveException;
import exception.IndexIsOutofRangeException;
import shuzizifuchuan.IStringBuffer;
public class MyStringBufferCollection implements IStringBuffer {
	
	ArrayList<Character> msbc=new ArrayList<Character>();
	
	//无参数构造方法
	public MyStringBufferCollection() {
		// TODO 自动生成的构造函数存根
		
	}
	//有参构造方法
	public MyStringBufferCollection(String str) {
		append(str);
	}
	@Override
	public void append(String str) {
		// TODO 自动生成的方法存根
		char strChar[]=str.toCharArray();
		for(char tmp:strChar) {
			msbc.add(tmp);
		}
	}

	@Override
	public void append(char c) {
		// TODO 自动生成的方法存根
		msbc.add(c);
	}

	@Override
	public void insert(int pos, char b) throws IndexIsNagetiveException {
		// TODO 自动生成的方法存根
		if(pos<0)throw new IndexIsNagetiveException();
		msbc.add(pos,b);
	}

	@Override
	public void insert(int pos, String b) throws IndexIsNagetiveException {
		// TODO 自动生成的方法存根
		if(pos<0)throw new IndexIsNagetiveException();
		char strChar[]=b.toCharArray();
		for(int i=0;i<strChar.length;i++) {
			msbc.add(pos+i,strChar[i]);
		}
	}

	@Override
	public void delete(int start) {
		// TODO 自动生成的方法存根
		for(int i=start;i<msbc.size();i++) {
			msbc.remove(i);
		}
	}

	@Override
	public void delete(int start, int end) throws IndexIsNagetiveException, IndexIsOutofRangeException {
		// TODO 自动生成的方法存根

		if(start<0)throw new IndexIsNagetiveException();
		if(end>=msbc.size())throw new IndexIsOutofRangeException();
		for(int i=start;i<end;i++) {
			msbc.remove(start);
		}
	}

	@Override
	public void reverse() {
		// TODO 自动生成的方法存根
		int j=msbc.size()/2;
		char tmp;//临时对象
		for(int i=msbc.size()-1;i>=j;i--) {
			tmp=msbc.get(i);
			msbc.set(i,msbc.get(msbc.size()-1-i));
			msbc.set(msbc.size()-1-i,tmp);
		}
	}

	@Override
	public int length() {
		// TODO 自动生成的方法存根
		return msbc.size();
	}
	public void shuchu() {
		System.out.println(msbc);
	}

	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String str1 = "let there ";
		 
		MyStringBufferCollection msb = new MyStringBufferCollection(); //根据str1创建一个StringBuffer对象
        msb.append("be lightabcdefghijk"); //在最后追加
        msb.shuchu();
        //自定义异常捕获下标为负异常
        try {
        msb.delete(4, 10);//删除4-10之间的字符
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
