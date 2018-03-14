import java.util.*;
class Activity_selection_Dynamic{
	
	int best(int s[],int f[],int z,int n){
		int max=0;
		for(int i=0;i<s.length;i++)
		{
			if(max<f[i])
				max=f[i];
		}
		int total[]=new int[max+1];
		int k=1;
		for(int i=1;i<s.length;i++){
			while(k<=f[i]){
				total[k]=total[k-1];
				k++;
			}
			if(total[k-1]<f[i]-s[i]+total[s[i]])
				total[k-1]=f[i]-s[i]+total[s[i]];
		}
		max=0;
		for(int i=0;i<total.length;i++)
		{
			if(max<total[i])
				max=total[i];
		}
		System.out.println(Arrays.toString(total));
		return max;
	}
			
	
	public static void main (String args[]){
		Scanner scan=new Scanner(System.in);
		Activity_selection_Dynamic rcp = new Activity_selection_Dynamic();
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