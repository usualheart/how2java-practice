package collection;


public class CoHero {
    public String name;
    public float hp;
 
    public int damage;
 
    public CoHero() {
 
    }
 
    // ����һ����ʼ��name�Ĺ��췽��
    public CoHero(String name) {
 
        this.name = name;
    }
    
 // ����һ����ʼ��name��Ѫ���Ĺ��췽��
    public CoHero(String name,float h) {
 
        this.name = name;
        this.hp=h;
    }
 
    // ��дtoString����
    public String toString() {
        return name;
    }
 
}