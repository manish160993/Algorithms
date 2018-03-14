import java.util.*;
class Activity_selection_Dynamic_Special{
	
	int best(int s[],int f[],int z[]){
		int max=0;
		for(int i=0;i<s.length;i++)
		{
			if(max<f[i])
				max=f[i];
		}
		int total[][]=new int[max+1][2];
		int totalZero[]=new int[max+1];
		int k=1;
		
		for(int i=1;i<s.length;i++){
			while(k<=f[i]){
				totalZero[k]=totalZero[k-1];
				total[k][0]=total[k-1][0];
				total[k][1]=total[k-1][1];
				k++;
			}
			if(z[i]==0){
				if(totalZero[k-2]<totalZero[s[i]]+f[i]-s[i])
					totalZero[k-1]=totalZero[s[i]]+f[i]-s[i];
				else
					totalZero[k-1]=totalZero[k-2];
				
				if(total[k-2][0]<=f[i]-s[i]+total[s[i]][0])
				{
					total[k-1][0]=f[i]-s[i]+total[s[i]][0];
					total[k-1][1]=0;
				}
				else{
					total[k-1][0]=total[k-2][0];
					total[k-1][1]=total[k-2][1];
				}
			}
			else{
				totalZero[k-1]=totalZero[k-2];
				if(total[k-2][0]<=f[i]-s[i]+total[s[i]][0] && total[s[i]][1]!=1)
				{
					total[k-1][0]=f[i]-s[i]+total[s[i]][0];
					total[k-1][1]=1;
				}
				else if(total[k-2][0]<=f[i]-s[i]+totalZero[s[i]])
				{
					total[k-1][0]=f[i]-s[i]+totalZero[s[i]];
					total[k-1][1]=1;
				}
				else
				{
					total[k-1][0]=total[k-2][0];
					total[k-1][1]=total[k-2][1];
				}
				}
		}
		
		max=0;
		for(int i=0;i<totalZero.length;i++)
		{
			if(max<total[i][0])
				max=total[i][0];
		}
		for(int i=0;i<totalZero.length;i++)
		{
			System.out.print(total[i][0]+" : "+total[i][1]+"   ");
		}
		System.out.println();
		for(int i=0;i<totalZero.length;i++)
		{
			System.out.print(totalZero[i]+" ");
		}
		//System.out.println(Arrays.toString(total[][0]));
		return max;
	}
			
	
	public static void main (String args[]){
		Scanner scan=new Scanner(System.in);
		Activity_selection_Dynamic_Special rcp = new Activity_selection_Dynamic_Special();
		System.out.println("Please enter the number of elements in array");
		int n=scan.nextInt();
		int[] a=new int[n];
		int[] b=new int[n];
		int[] c=new int[n];
		System.out.println("Please enter the start & end time");
		for(int i=0;i<n;i++)
		{
			a[i]=scan.nextInt();
			b[i]=scan.nextInt();
			c[i]=scan.nextInt();
		}
	
		int r=rcp.best(a,b,c);
		System.out.println(r);
	}
}