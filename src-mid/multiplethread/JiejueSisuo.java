package multiplethread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//通过使用tryLock,避免死锁的出现
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
				boolean flag=false;//是否成功的标志
				while(!flag){
					boolean fa=false;
					try{//lock的解锁放在finally里边 可以确保异常出现时候也可以解锁
						fa=la.tryLock(1,TimeUnit.SECONDS);//尝试占有1秒钟
						if(fa) {
							boolean fb=false;
							System.out.println("t1已经占有a!");
							System.out.println("t1请求占有b...");
							try{
								fb=lb.tryLock(1,TimeUnit.SECONDS);//尝试占有1秒钟
								if(fb) {
									boolean fc=false;
									System.out.println("t1已经占有b!");
									System.out.println("t1请求占有c...");
									try {
										fc=lc.tryLock(1,TimeUnit.SECONDS);//尝试占有1秒钟
										if(fc) {
											System.out.println("t1已经占有c!");
											System.out.println("t1成功了！");
											flag=true;
										}
										else System.out.println("t1请求c失败，放弃所有资源...");
									}
									catch(Exception e) {
										e.printStackTrace();
									}
									finally {
										if(fc) {
										lc.unlock();
										System.out.println("t1释放c");
										}
										//如果没有得到锁 就不需要解锁
									}
								}
								else System.out.println("t1请求b失败，放弃所有资源...");
								
							}
							catch(Exception e) {
								e.printStackTrace();
							}
							finally {
								if(fb) {
									lb.unlock();
									System.out.println("t1释放b");
								}
								//如果没有得到锁 就不需要解锁
							}
						}
						else System.out.println("t1请求a失败，放弃所有资源...");
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					finally {
						if(fa) {
						la.unlock();
						System.out.println("t1释放a");
						}
					}
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}//失败后休息1500ms继续
				
				}
			}
		};
		t1.start();
		
		Thread t2=new Thread() {
			public void run() {
				boolean flag=false;//是否成功的标志
				while(!flag){
					boolean fb=false;
					try{//lock的解锁放在finally里边 可以确保异常出现时候也可以解锁
						fb=lb.tryLock(1,TimeUnit.SECONDS);//尝试占有1秒钟
						if(fb) {
							boolean fc=false;
							System.out.println("t2已经占有b!");
							System.out.println("t2请求占有c...");
							try{
								fc=lc.tryLock(1,TimeUnit.SECONDS);//尝试占有1秒钟
								if(fc) {
									boolean fa=false;
									System.out.println("t2已经占有c!");
									System.out.println("t2请求占有a...");
									try {
										fa=la.tryLock(1,TimeUnit.SECONDS);//尝试占有1秒钟
										if(fa) {
											System.out.println("t2已经占有a!");
											System.out.println("t2成功了！");
											flag=true;
										}
										else System.out.println("t2请求a失败，放弃所有资源...");
									}
									catch(Exception e) {
										e.printStackTrace();
									}
									finally {
										if(fa) {
										la.unlock();
										System.out.println("t2释放a");
										}
										//如果没有得到锁 就不需要解锁
									}
								}
								else System.out.println("t2请求c失败，放弃所有资源...");
								
							}
							catch(Exception e) {
								e.printStackTrace();
							}
							finally {
								if(fc) {
									lc.unlock();
									System.out.println("t2释放c");
								}
								//如果没有得到锁 就不需要解锁
							}
						}
						else System.out.println("t2请求b失败，放弃所有资源...");
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					finally {
						if(fb) {
						lb.unlock();
						System.out.println("t2释放b");
						}
					}
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}//失败后休息1500ms继续
				}
			}
		};
		t2.start();
		
		Thread t3=new Thread() {
			public void run() {
				boolean flag=false;//是否成功的标志
				while(!flag){
					boolean fc=false;
					try{//lock的解锁放在finally里边 可以确保异常出现时候也可以解锁
						fc=lc.tryLock(1,TimeUnit.SECONDS);//尝试占有1秒钟
						if(fc) {
							boolean fa=false;
							System.out.println("t3已经占有c!");
							System.out.println("t3请求占有a...");
							try{
								fa=la.tryLock(1,TimeUnit.SECONDS);//尝试占有1秒钟
								if(fa) {
									boolean fb=false;
									System.out.println("t3已经占有a!");
									System.out.println("t3请求占有b...");
									try {
										fb=lb.tryLock(1,TimeUnit.SECONDS);//尝试占有1秒钟
										if(fb) {
											System.out.println("t3已经占有b!");
											System.out.println("t3成功了！");
											flag=true;
										}
										else System.out.println("t3请求b失败，放弃所有资源...");
									}
									catch(Exception e) {
										e.printStackTrace();
									}
									finally {
										if(fb) {
										lb.unlock();
										System.out.println("t3释放b");
										}
										//如果没有得到锁 就不需要解锁
									}
								}
								else System.out.println("t3请求a失败，放弃所有资源...");
								
							}
							catch(Exception e) {
								e.printStackTrace();
							}
							finally {
								if(fa) {
									la.unlock();
									System.out.println("t3释放a");
								}
								//如果没有得到锁 就不需要解锁
							}
						}
						else System.out.println("t3请求c失败，放弃所有资源...");
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					finally {
						if(fc) {
						lc.unlock();
						System.out.println("t3释放c");
					}
					}
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}//失败后休息1500ms
				}
			}
		};
		t3.start();
	}
}
