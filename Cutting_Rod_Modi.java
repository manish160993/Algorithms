import java.util.*;

class Cutting_Rod_Modi{
	static int[] best(int[] a,int[] c){
		int[] r=new int[a.length];
		for(int i=0;i<r.length;i++){
			int max=a[i];
			for(int j=0;j<i;j++){
				if(r[j]+r[i-j-1]-c[i]>max)
					max=r[j]+r[i-j-1]-c[i];
			}
			r[i]=max;
		}
		System.out.println(Arrays.toString(r));
		return r;
	}
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Pleasse enter the number of elements in array");
		int n=scan.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=scan.nextInt();
		System.out.println("Pleasse enter the cost in array");
		int[] c=new int[n];
		for(int i=0;i<n;i++)
			c[i]=scan.nextInt();
		int r[]=best(a,c);
		
		System.out.println("Please enter the length of rod");
		int out =scan.nextInt();
		System.out.println(r[out-1]);
	}
}