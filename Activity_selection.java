import java.util.*;
class Activity_selection{
	static int[] calculatebest(int[][] a){
		int max=a[a.length-1][1];
		int[] b=new int[max+1];
		for(int i=0;i<a.length;i++){
			if(a[i][1]-a[i][0]+1+b[a[i][0]]>=b[a[i][1]-1])
				b[a[i][1]]=a[i][1]-a[i][0]+1+b[a[i][0]];
			else
				b[a[i][1]]=b[a[i][1]-1];
		}
		for(int i=1;i<b.length;i++)
		{
			if(b[i]<b[i-1])
				b[i]=b[i-1];
		}
		System.out.println(Arrays.toString(b));
		return b;
	}
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Pleasse enter the number of activities in array");
		int n=scan.nextInt();
		int[][] a=new int[n][2];
		for(int i=0;i<n;i++){
			a[i][0]=scan.nextInt();
			a[i][1]=scan.nextInt();
		}
		int[] b=calculatebest(a);
		System.out.println(b[16]);
	}
}
		
