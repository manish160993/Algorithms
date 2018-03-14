import java.util.*;
class Activity_selection_greedy{
	
	int best(int s[],int f[],int k,int n){
		int m=k+1;
		while(m<=n && s[m]<f[k])
			m=m+1;
		if(m<=n)
		{System.out.println(m);
		return 1+best(s,f,m,n);}
		return 0;
	}
		
	
	public static void main (String args[]){
		Scanner scan=new Scanner(System.in);
		Activity_selection_greedy rcp = new Activity_selection_greedy();
		System.out.println("Please enter the number of elements in array");
		int n=scan.nextInt();
		int[] a=new int[n];
		int[] b=new int[n];
		System.out.println("Please enter the start & end time");
		for(int i=0;i<n;i++)
		{
			a[i]=scan.nextInt();
			b[i]=scan.nextInt();
		}
	
		int r=rcp.best(a,b,0,a.length-1);
		System.out.println(r);
	}
}