package kongzhi;
public class xiaoxuesuanshu {
	boolean yanzheng(int i,int j,int k,int l) {
		if((i+j)==8&&(i+k)==14&&(j+l)==10&&(k-l)==6)return true;
		else return false;
	}
	void xunzhao() {
		int i,j,k,l;
		for(i=0;i<=8;i++) {
			for(j=0;j<=8;j++) {
				for(k=0;k<=14;k++) {
					for(l=0;l<=8;l++) {
						if(yanzheng(i,j,k,l)==true)System.out.println(i+" "+j+"\n"+k+" "+l);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		xiaoxuesuanshu ans=new xiaoxuesuanshu();
		ans.xunzhao();
	}
}
