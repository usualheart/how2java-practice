package multiplethread;

public class TestJiaohu {
	
	public static void testJiaohu() {
	    
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
             
        Thread t1 = new Thread(){
            public void run(){
                while(true){
                       
                    //无需循环判断
//                    while(gareen.hp==1){
//                        continue;
//                    }
                       
                    gareen.hurt();
                     
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
   
            }
        };
        t1.start();
   
        Thread t2 = new Thread(){
            public void run(){
                while(true){
                    gareen.recover();
   
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
   
            }
        };
        t2.start();
             
    }
	public static void testJiaohuMore() {
	    
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        
        //增加伤害线程到5条
        for(int i=0;i<2;i++) {
	        Thread t1 = new Thread(){
	            public void run(){
	                while(true){
	                       
	                    gareen.hurt();
	                     
	                    try {
	                        Thread.sleep(10);
	                    } catch (InterruptedException e) {
	                        // TODO Auto-generated catch block
	                        e.printStackTrace();
	                    }
	                }
	   
	            }
	        };
	        t1.start();
        }
        for(int i=0;i<5;i++) {
	        Thread t2 = new Thread(){
	            public void run(){
	                while(true){
	                    gareen.recover();
	   
	                    try {
	                        Thread.sleep(100);
	                    } catch (InterruptedException e) {
	                        // TODO Auto-generated catch block
	                        e.printStackTrace();
	                    }
	                }
	   
	            }
	        };
	        t2.start();
        }
    }
	
	public static void main(String[] args) {
		///testJiaohu();
		testJiaohuMore();
	}
}
