package collection;

import java.util.ArrayList;
import java.util.Comparator;

import shuzu.ShuzuYiwei;
import java.util.List;

import property.Item;
//֧�ַ��� �Ķ����������������Ҫ�Ƚϱ���̳�Comparable�ӿ�
//public class Node<T extends Comparable<T>> { ����Ҳ��
public class NodeT<T extends Comparable<?super T>>  {
    // ���ӽڵ�
    public NodeT<T> leftNode;
    // ���ӽڵ�
    public NodeT<T> rightNode;
    // ֵ
    public  T value ;
    // ���� ����
    public void add(T  v) {
    	
    	
    	
    	
        // �����ǰ�ڵ�û��ֵ���Ͱ����ݷ��ڵ�ǰ�ڵ���
        if (null == value)
            value =v;
        // �����ǰ�ڵ���ֵ���ͽ����жϣ�������ֵ�뵱ǰֵ�Ĵ�С��ϵ
        else {
            // ������ֵ���ȵ�ǰֵС������ͬ
            if (v.compareTo(value)<= 0) {
                if (null == leftNode)
                    leftNode = new NodeT<T>();
                leftNode.add(v);
            }
            // ������ֵ���ȵ�ǰֵ��
            else {
                if (null == rightNode)
                    rightNode = new NodeT<T>();
                rightNode.add(v);
            }
        }
    }
    
    
 // ����������еĽڵ�
    public List<T> values() {
        List<T> values = new ArrayList<>();
        // ��ڵ�ı������
        if (null != leftNode)
            values.addAll(leftNode.values());
        // ��ǰ�ڵ�
        values.add(value);
        // �ҽڵ�ı������
        if (null != rightNode)
            values.addAll(rightNode.values());
        return values;
    }
  
    public static void main(String[] args) {
    	
    	Comparator<CoHero>ch=new Comparator<CoHero>() {

			@Override
			public int compare(CoHero o1, CoHero o2) {
				// TODO �Զ����ɵķ������
				if(o1.hp<o2.hp)return -1;
				else return 1;
			}
    		
    	};
       
   
        
        //����Ϊ֧�ַ��͵Ķ������Ĳ���:Item
        NodeT<Item>nt=new NodeT<Item>();
        for(int i=0;i<10;i++) {
        	Item tmp=new Item("CoHero"+i);
        	tmp.price=(int) (100*(float)Math.random());
        	nt.add(tmp);
        }
        List<Item>x=nt.values();
        for(Item tmp:x) {
        	tmp.showItem();
        }
        
    

    }
}