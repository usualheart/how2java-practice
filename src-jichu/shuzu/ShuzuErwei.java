package shuzu;
import java.util.Arrays;
public class ShuzuErwei {
	int x,y;//����ά��
	int A[][];
	int maxx,maxy;
	//��ʼ��һ�����ȶ�ά����
	void init(int i,int j) {
		x=i;
		y=j;
		A=new int[x][y];
	
	}
	//�����ά����
	void shuchu() {
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
	//������ɶ�ά����,
	void suiji() {
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				A[i][j]=(int)(Math.random()*100);
			}
		}
	}
	//����for�Ҷ�ά�������ֵ,���������±�
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
		// �����ά���鲢�����ֵ
		ShuzuErwei er=new ShuzuErwei();
		er.init(5, 3);
		er.suiji();
		er.shuchu();
		er.maxxy();
		System.out.println(er.maxx+" "+er.maxy);
		//ʹ������java.util.Arrays��ķ���
		int[] B=Arrays.copyOfRange(er.A[0], 0, er.A[0].length-1);
		String Bans=Arrays.toString(B);
		System.out.println(Bans);
		Arrays.sort(B);
		System.out.println(Arrays.toString(B));
		//ʹ��binarySearch֮ǰ��������ʹ��sort��������
		System.out.println(Arrays.binarySearch(B,62));
		
		//�ж��Ƿ���ͬ
		int a[] = new int[] { 18, 62, 68, 82, 65, 8 };
        int b[] = new int[] { 18, 62, 68, 82, 65, 8 };
        System.out.println(Arrays.equals(a, b));
        //���
        Arrays.fill(a, 100);
        System.out.println(Arrays.toString(a));
        
        //ʹ��Arrays��Զ�ά�����������
        int ans[]=er.sortArrays();
        System.out.println(Arrays.toString(ans));
        
		
	}

}
