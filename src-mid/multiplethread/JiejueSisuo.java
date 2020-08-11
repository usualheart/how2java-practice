package multiplethread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//ͨ��ʹ��tryLock,���������ĳ���
public class JiejueSisuo {
	public static void main(String[]args) {
		//Hero a=new Hero("a");
		//Hero b=new Hero("b");
		//Hero c=new Hero("c");
		Lock lb=new ReentrantLock();
		Lock lc=new ReentrantLock();
		Lock la=new ReentrantLock();
		Thread t1=new Thread() {
			public void run() {
				boolean flag=false;//�Ƿ�ɹ��ı�־
				while(!flag){
					boolean fa=false;
					try{//lock�Ľ�������finally��� ����ȷ���쳣����ʱ��Ҳ���Խ���
						fa=la.tryLock(1,TimeUnit.SECONDS);//����ռ��1����
						if(fa) {
							boolean fb=false;
							System.out.println("t1�Ѿ�ռ��a!");
							System.out.println("t1����ռ��b...");
							try{
								fb=lb.tryLock(1,TimeUnit.SECONDS);//����ռ��1����
								if(fb) {
									boolean fc=false;
									System.out.println("t1�Ѿ�ռ��b!");
									System.out.println("t1����ռ��c...");
									try {
										fc=lc.tryLock(1,TimeUnit.SECONDS);//����ռ��1����
										if(fc) {
											System.out.println("t1�Ѿ�ռ��c!");
											System.out.println("t1�ɹ��ˣ�");
											flag=true;
										}
										else System.out.println("t1����cʧ�ܣ�����������Դ...");
									}
									catch(Exception e) {
										e.printStackTrace();
									}
									finally {
										if(fc) {
										lc.unlock();
										System.out.println("t1�ͷ�c");
										}
										//���û�еõ��� �Ͳ���Ҫ����
									}
								}
								else System.out.println("t1����bʧ�ܣ�����������Դ...");
								
							}
							catch(Exception e) {
								e.printStackTrace();
							}
							finally {
								if(fb) {
									lb.unlock();
									System.out.println("t1�ͷ�b");
								}
								//���û�еõ��� �Ͳ���Ҫ����
							}
						}
						else System.out.println("t1����aʧ�ܣ�����������Դ...");
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					finally {
						if(fa) {
						la.unlock();
						System.out.println("t1�ͷ�a");
						}
					}
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}//ʧ�ܺ���Ϣ1500ms����
				
				}
			}
		};
		t1.start();
		
		Thread t2=new Thread() {
			public void run() {
				boolean flag=false;//�Ƿ�ɹ��ı�־
				while(!flag){
					boolean fb=false;
					try{//lock�Ľ�������finally��� ����ȷ���쳣����ʱ��Ҳ���Խ���
						fb=lb.tryLock(1,TimeUnit.SECONDS);//����ռ��1����
						if(fb) {
							boolean fc=false;
							System.out.println("t2�Ѿ�ռ��b!");
							System.out.println("t2����ռ��c...");
							try{
								fc=lc.tryLock(1,TimeUnit.SECONDS);//����ռ��1����
								if(fc) {
									boolean fa=false;
									System.out.println("t2�Ѿ�ռ��c!");
									System.out.println("t2����ռ��a...");
									try {
										fa=la.tryLock(1,TimeUnit.SECONDS);//����ռ��1����
										if(fa) {
											System.out.println("t2�Ѿ�ռ��a!");
											System.out.println("t2�ɹ��ˣ�");
											flag=true;
										}
										else System.out.println("t2����aʧ�ܣ�����������Դ...");
									}
									catch(Exception e) {
										e.printStackTrace();
									}
									finally {
										if(fa) {
										la.unlock();
										System.out.println("t2�ͷ�a");
										}
										//���û�еõ��� �Ͳ���Ҫ����
									}
								}
								else System.out.println("t2����cʧ�ܣ�����������Դ...");
								
							}
							catch(Exception e) {
								e.printStackTrace();
							}
							finally {
								if(fc) {
									lc.unlock();
									System.out.println("t2�ͷ�c");
								}
								//���û�еõ��� �Ͳ���Ҫ����
							}
						}
						else System.out.println("t2����bʧ�ܣ�����������Դ...");
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					finally {
						if(fb) {
						lb.unlock();
						System.out.println("t2�ͷ�b");
						}
					}
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}//ʧ�ܺ���Ϣ1500ms����
				}
			}
		};
		t2.start();
		
		Thread t3=new Thread() {
			public void run() {
				boolean flag=false;//�Ƿ�ɹ��ı�־
				while(!flag){
					boolean fc=false;
					try{//lock�Ľ�������finally��� ����ȷ���쳣����ʱ��Ҳ���Խ���
						fc=lc.tryLock(1,TimeUnit.SECONDS);//����ռ��1����
						if(fc) {
							boolean fa=false;
							System.out.println("t3�Ѿ�ռ��c!");
							System.out.println("t3����ռ��a...");
							try{
								fa=la.tryLock(1,TimeUnit.SECONDS);//����ռ��1����
								if(fa) {
									boolean fb=false;
									System.out.println("t3�Ѿ�ռ��a!");
									System.out.println("t3����ռ��b...");
									try {
										fb=lb.tryLock(1,TimeUnit.SECONDS);//����ռ��1����
										if(fb) {
											System.out.println("t3�Ѿ�ռ��b!");
											System.out.println("t3�ɹ��ˣ�");
											flag=true;
										}
										else System.out.println("t3����bʧ�ܣ�����������Դ...");
									}
									catch(Exception e) {
										e.printStackTrace();
									}
									finally {
										if(fb) {
										lb.unlock();
										System.out.println("t3�ͷ�b");
										}
										//���û�еõ��� �Ͳ���Ҫ����
									}
								}
								else System.out.println("t3����aʧ�ܣ�����������Դ...");
								
							}
							catch(Exception e) {
								e.printStackTrace();
							}
							finally {
								if(fa) {
									la.unlock();
									System.out.println("t3�ͷ�a");
								}
								//���û�еõ��� �Ͳ���Ҫ����
							}
						}
						else System.out.println("t3����cʧ�ܣ�����������Դ...");
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					finally {
						if(fc) {
						lc.unlock();
						System.out.println("t3�ͷ�c");
					}
					}
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}//ʧ�ܺ���Ϣ1500ms
				}
			}
		};
		t3.start();
	}
}
