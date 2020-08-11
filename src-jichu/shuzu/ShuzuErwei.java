package shuzu;
import java.util.Arrays;
public class ShuzuErwei {
	int x,y;//两个维度
	int A[][];
	int maxx,maxy;
	//初始化一定长度二维数组
	void init(int i,int j) {
		x=i;
		y=j;
		A=new int[x][y];
	
	}
	//输出二维数组
	void shuchu() {
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
	//随机生成二维数组,
	void suiji() {
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				A[i][j]=(int)(Math.random()*100);
			}
		}
	}
	//常规for找二维数组最大值,返回数组下标
	int maxxy() {
		int maxi=0,maxj=0;
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				if(A[i][j]>A[maxi][maxj]) {
					maxi=i;
					maxj=j;
				}
			}
		}
		maxx=maxi;
		maxy=maxj;
		return A[maxi][maxj];
	}
	
	int[] sortArrays() {
		int ans[]=new int[x*y];
		int pos=0;
		for(int i=0;i<x;i++) {
			System.arraycopy(A[i], 0, ans, pos, y);
			pos+=y;
		}
		System.out.println(Arrays.toString(ans));
		Arrays.sort(ans);
		return ans;
	}
	public static void main(String[] args) {
		// 随机二维数组并找最大值
		ShuzuErwei er=new ShuzuErwei();
		er.init(5, 3);
		er.suiji();
		er.shuchu();
		er.maxxy();
		System.out.println(er.maxx+" "+er.maxy);
		//使用数组java.util.Arrays类的方法
		int[] B=Arrays.copyOfRange(er.A[0], 0, er.A[0].length-1);
		String Bans=Arrays.toString(B);
		System.out.println(Bans);
		Arrays.sort(B);
		System.out.println(Arrays.toString(B));
		//使用binarySearch之前，必须先使用sort进行排序
		System.out.println(Arrays.binarySearch(B,62));
		
		//判断是否相同
		int a[] = new int[] { 18, 62, 68, 82, 65, 8 };
        int b[] = new int[] { 18, 62, 68, 82, 65, 8 };
        System.out.println(Arrays.equals(a, b));
        //填充
        Arrays.fill(a, 100);
        System.out.println(Arrays.toString(a));
        
        //使用Arrays类对二维数组进行排序
        int ans[]=er.sortArrays();
        System.out.println(Arrays.toString(ans));
        
		
	}

}
