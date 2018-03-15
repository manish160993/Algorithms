import java.util.*;
class Longest_Alternating_Increase_Sequence{
	
	int best(int a[],int b[]){
		int c[][]=new int[b.length][a.length];
		int max=0;
		for(int i=0;i<a.length;i++)
		{
			c[0][i]=0;
			
		}
		for(int i=0;i<b.length;i++)
		{
			c[i][0]=0;
			
		}
		int s=0;
		for(int i=1;i<b.length;i++){
			for(int j=1;j<a.length;j++){
				if(b[i]==a[j])
				{
					if((a[j]%2==0&&s%2!=0)||(a[j]%2!=0&&s%2==0))
					{
						c[i][j]=1+c[i][j-1];
						s=a[j];
					}
					else
						c[i][j]=c[i][j-1];
				}
				else
				{
					if(b[i]>a[j]){
						int d[]=new int[i];
						for(int k=0;k<i;k++){
							d[k]=c[k][j];
						}
						c[i][j]=max(d);
					}
					else
						c[i][j]=c[i][j-1];
				}
				if(c[i][j]>max)
					max=c[i][j];
			}
		}
		for(int i=0;i<b.length;i++){
			for(int j=0;j<a.length;j++){
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
		return max;
		
	}
	int max(int[] b){
		int maxv=0;
		for(int i=0;i<b.length;i++)
		{
			if(b[i]>maxv)
				maxv=b[i];
		}
		return maxv;
	}
			
	
	
	public static void main (String args[]){
		Scanner scan=new Scanner(System.in);
		Longest_Alternating_Increase_Sequence rcp = new Longest_Alternating_Increase_Sequence();
		System.out.println("Please enter the number of elements in array");
		int n=scan.nextInt();
		int n2=scan.nextInt();
		int[] a=new int[n+1];
		int[] b=new int[n2+1];
		for(int i=1;i<a.length;i++){
			a[i]=scan.nextInt();
			
		}
		for(int i=1;i<b.length;i++){
			b[i]=scan.nextInt();
			
		}
		
	
		int r=rcp.best(a,b);
		System.out.println(r);
		
	}
}