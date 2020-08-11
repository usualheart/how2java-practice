package jdbc;
  
import java.util.List;

import multiplethread.Hero;
 

  
public interface DAO<T>{
    //����
    public  void  add(T hero);
    //�޸�
    public void update(T hero);
    //ɾ��
    public void delete(int id);
    //��ȡ
    public T get(int id);
    //��ѯ
    public List<T> list();
    //��ҳ��ѯ
    public List<T> list(int start, int count);
}