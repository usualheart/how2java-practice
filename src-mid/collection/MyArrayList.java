package collection;

import java.util.ArrayList;
import java.util.Objects;

import character.Hero;
import property.Item;

public class MyArrayList extends ArrayList{
	//ArrayList my=new ArrayList();
	//overide
	public boolean add1(Object x) {
		boolean flag=false; 
		if(x instanceof Hero||x instanceof Item) {
			modCount++;
	        add(x);
			flag=true;
		}
		else {
			System.out.println("���ʧ��!");
		}
		return flag;
	}
	public static void main(String []args) {
		MyArrayList mal=new MyArrayList();
		mal.add1(new Item("���"));
		mal.add1(new Hero("ɵ��"));
		System.out.println(mal);
		int i=102;
		mal.add1(i);
		System.out.println(mal);
		
	}
}
