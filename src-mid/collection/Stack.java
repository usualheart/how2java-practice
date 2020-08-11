package collection;
 
public interface Stack {
 
    //把英雄推入到最后位置
    public void push(CoHero h);
    //把最后一个英雄取出来
    public CoHero pull();
    //查看最后一个英雄
    public CoHero peek();
}
