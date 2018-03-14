import java.util.*;
class Activity_selection_Dynamic_Recursive{
	
	int best(int s[],int f[],int k,int n){
		int j[]=new int[s.length];
		for(int i=0;i<s.length;i++)
			j[i]=best1(s,f,i);
		System.out.println(Arrays.toString(j));
		int max=0;
		for(int i=0;i<s.length;i++)
		{
			if(max<j[i])
				max=j[i];
		}
		return max;
	}
	int best1(int s[],int f[],int i){
		int max=0;
		for(int j=i-1;j>0;j--)
			{
				if(f[j]<=s[i] && f[j]-s[j]>max)
					max=best1(s,f,j);
			}
		return f[i]-s[i]+max;
	}
			
	
	public static void main (String args[]){
		Scanner scan=new Scanner(System.in);
		Activity_selection_Dynamic_Recursive rcp = new Activity_selection_Dynamic_Recursive();
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