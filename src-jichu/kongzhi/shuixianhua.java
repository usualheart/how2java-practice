package kongzhi;

public class shuixianhua {
	int a,b,c;
	int shu(int i,int j,int k) {
		return i*100+j*10+k;
	}
	int sum(int i,int j,int k) {
		return i*i*i+j*j*j+k*k*k;
	}
	void xunzhao() {
		int i,j,k;
		for(i=1;i<10;i++) {
			for(j=0;j<10;j++) {
				for(k=0;k<10;k++) {
					if(shu(i,j,k)==sum(i,j,k))System.out.println(shu(i,j,k));
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		shuixianhua s=new shuixianhua();
		s.xunzhao();

	}

}
