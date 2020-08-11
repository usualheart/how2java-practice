package collection;

import java.util.ArrayList;
import shuzu.ShuzuYiwei;
import java.util.List;

public class Node {
    // 左子节点
    public Node leftNode;
    // 右子节点
    public Node rightNode;
    // 值
    public Object value;
    // 插入 数据
    public void add(Object v) {
        // 如果当前节点没有值，就把数据放在当前节点上
        if (null == value)
            value = v;
        // 如果当前节点有值，就进行判断，新增的值与当前值的大小关系
        else {
            // 新增的值，比当前值小或者相同
            if ((Integer) v -((Integer)value) <= 0) {
                if (null == leftNode)
                    leftNode = new Node();
                leftNode.add(v);
            }
            // 新增的值，比当前值大
            else {
                if (null == rightNode)
                    rightNode = new Node();
                rightNode.add(v);
            }
        }
    }
    
    
 // 中序遍历所有的节点
    public List<Object> values() {
        List<Object> values = new ArrayList<>();
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
  
        int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };
        Node roots = new Node();
        for (int number : randoms) {
            roots.add(number);
        }
        //输出中序遍历结果
        System.out.println(roots.values());
        
        
        //比较冒泡、选择、二叉树排序的性能
        ShuzuYiwei mao=new ShuzuYiwei(10000);
        ShuzuYiwei xuan=new ShuzuYiwei(10000);
        Node ercha=new Node();
        //生成40000个随机数
        mao.suiji();
        for(int i=0;i<mao.length;i++) {
        	xuan.a[i]=mao.a[i];
        }
        xuan.length=mao.length;
        //二叉树排序时间
        long time0=System.currentTimeMillis();
        for(int i=0;i<mao.length;i++) {
        	ercha.add(mao.a[i]);
        }
        //冒泡排序
        long time1=System.currentTimeMillis();
        xuan.maopao();
        long time2=System.currentTimeMillis();
        //选择排序
        mao.xuanze();
        long time3=System.currentTimeMillis();

        System.out.printf("二叉树排序时间是%dms%n",time1-time0);
        System.out.printf("冒泡排序时间是%dms%n",time2-time1);
        System.out.printf("选择排序时间是%dms%n",time3-time2);
        
/*
        System.out.println(ercha.values());
        mao.shuchu();
        xuan.shuchu();*/
        


    }
}