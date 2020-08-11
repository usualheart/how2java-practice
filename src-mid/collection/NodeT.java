package collection;

import java.util.ArrayList;
import java.util.Comparator;

import shuzu.ShuzuYiwei;
import java.util.List;

import property.Item;
//支持泛型 的二叉树，如果泛型需要比较必须继承Comparable接口
//public class Node<T extends Comparable<T>> { 这样也对
public class NodeT<T extends Comparable<?super T>>  {
    // 左子节点
    public NodeT<T> leftNode;
    // 右子节点
    public NodeT<T> rightNode;
    // 值
    public  T value ;
    // 插入 数据
    public void add(T  v) {
    	
    	
    	
    	
        // 如果当前节点没有值，就把数据放在当前节点上
        if (null == value)
            value =v;
        // 如果当前节点有值，就进行判断，新增的值与当前值的大小关系
        else {
            // 新增的值，比当前值小或者相同
            if (v.compareTo(value)<= 0) {
                if (null == leftNode)
                    leftNode = new NodeT<T>();
                leftNode.add(v);
            }
            // 新增的值，比当前值大
            else {
                if (null == rightNode)
                    rightNode = new NodeT<T>();
                rightNode.add(v);
            }
        }
    }
    
    
 // 中序遍历所有的节点
    public List<T> values() {
        List<T> values = new ArrayList<>();
        // 左节点的遍历结果
        if (null != leftNode)
            values.addAll(leftNode.values());
        // 当前节点
        values.add(value);
        // 右节点的遍历结果
        if (null != rightNode)
            values.addAll(rightNode.values());
        return values;
    }
  
    public static void main(String[] args) {
    	
    	Comparator<CoHero>ch=new Comparator<CoHero>() {

			@Override
			public int compare(CoHero o1, CoHero o2) {
				// TODO 自动生成的方法存根
				if(o1.hp<o2.hp)return -1;
				else return 1;
			}
    		
    	};
       
   
        
        //更改为支持泛型的二叉树的测试:Item
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