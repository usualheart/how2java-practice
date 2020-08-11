package collection;

import java.util.ArrayList;
import shuzu.ShuzuYiwei;
import java.util.List;

public class Node {
    // ���ӽڵ�
    public Node leftNode;
    // ���ӽڵ�
    public Node rightNode;
    // ֵ
    public Object value;
    // ���� ����
    public void add(Object v) {
        // �����ǰ�ڵ�û��ֵ���Ͱ����ݷ��ڵ�ǰ�ڵ���
        if (null == value)
            value = v;
        // �����ǰ�ڵ���ֵ���ͽ����жϣ�������ֵ�뵱ǰֵ�Ĵ�С��ϵ
        else {
            // ������ֵ���ȵ�ǰֵС������ͬ
            if ((Integer) v -((Integer)value) <= 0) {
                if (null == leftNode)
                    leftNode = new Node();
                leftNode.add(v);
            }
            // ������ֵ���ȵ�ǰֵ��
            else {
                if (null == rightNode)
                    rightNode = new Node();
                rightNode.add(v);
            }
        }
    }
    
    
 // ����������еĽڵ�
    public List<Object> values() {
        List<Object> values = new ArrayList<>();
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
  
        int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };
        Node roots = new Node();
        for (int number : randoms) {
            roots.add(number);
        }
        //�������������
        System.out.println(roots.values());
        
        
        //�Ƚ�ð�ݡ�ѡ�񡢶��������������
        ShuzuYiwei mao=new ShuzuYiwei(10000);
        ShuzuYiwei xuan=new ShuzuYiwei(10000);
        Node ercha=new Node();
        //����40000�������
        mao.suiji();
        for(int i=0;i<mao.length;i++) {
        	xuan.a[i]=mao.a[i];
        }
        xuan.length=mao.length;
        //����������ʱ��
        long time0=System.currentTimeMillis();
        for(int i=0;i<mao.length;i++) {
        	ercha.add(mao.a[i]);
        }
        //ð������
        long time1=System.currentTimeMillis();
        xuan.maopao();
        long time2=System.currentTimeMillis();
        //ѡ������
        mao.xuanze();
        long time3=System.currentTimeMillis();

        System.out.printf("����������ʱ����%dms%n",time1-time0);
        System.out.printf("ð������ʱ����%dms%n",time2-time1);
        System.out.printf("ѡ������ʱ����%dms%n",time3-time2);
        
/*
        System.out.println(ercha.values());
        mao.shuchu();
        xuan.shuchu();*/
        


    }
}