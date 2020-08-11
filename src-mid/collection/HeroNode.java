package collection;

import java.util.ArrayList;
import java.util.List;

public class HeroNode {
	public HeroNode leftNode;
	public HeroNode	rightNode;
	public CoHero value;
	
	//中序插入英雄，倒序排列
	public void add(CoHero v) {
		if(null==value)
			value=v;
		else {
			if(v.hp>=value.hp) {
				if(null==leftNode) 
					leftNode=new HeroNode();
				leftNode.add(v);
			}
			else {
				if(null==rightNode) 
					rightNode=new HeroNode();
				rightNode.add(v);
			}
		}
	}
	//中序遍历
	public List<Object> values(){
		List<Object>values=new ArrayList<Object>();
		if(null!=leftNode)values.addAll(leftNode.values());
		values.add(value);
		if(null!=rightNode)values.addAll(rightNode.values());
		return values;
	}
	//第一种方法，编写新的类
	public static void method1() {
		// TODO 自动生成的方法存根
		//随机生成10个不同血量的英雄
		HeroNode hn=new HeroNode();
		for(int i=0;i<10;i++) {
			hn.add(new CoHero("CoHero"+i,100*(float)Math.random()));
		}
		List<Object> ans=hn.values();
		for(Object h:ans) {
			CoHero hh=(CoHero)h;
			System.out.printf("%s血量：%.2f%n",hh.name,hh.hp);
		}

	}
	
	

	public static void main(String[] args) {
		method1();
		
	}

}
