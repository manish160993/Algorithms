import java.util.*;
class Rod_Cut_Limit{
	public int[][] a;
	public int n;
	int best1(int profit_limit[][],int size){
		int max=Integer.MIN_VALUE;
		int[][] c=new int[n+1][2];
		for(int i=1;i<a.length;i++){
			if(i>size)
				break;
			for(int j=1;j<=i;j++){
				c[j][0]=a[j][0];
				c[j][1]=a[j][1];
				System.out.println(c[j][0]+"-->"+c[j][1]+" "+a[j][0]+"-->" +a[j][1]);
			}
			int x=best(c,size,i);
			if(x>max)
				max=x;
		}
		return max;
	}
			
	int best(int c[][],int b,int j){
		if(b==0)
			return 0;
		if(b<0)
			return Integer.MIN_VALUE;
		int max=Integer.MIN_VALUE;
		for(int i=j;i>=1;i--){
			if(b>=i&&c[i][1]>0)
			{
				c[i][1]-=1;
				int z=best(c,b-i,j);
				int y=best(c,b,i-1);
				if(z!=Integer.MIN_VALUE||y!=Integer.MIN_VALUE)
				{
					int x;
					if(z>y){
					x=c[i][0]+z;}
					else
						x=c[i][0]+y;
				if(max<x)
					max=x;
				}
				
			}
		}
		return max;
	}
	
	
	
	public static void main (String args[]){
		Scanner scan=new Scanner(System.in);
		Rod_Cut_Limit rcp = new Rod_Cut_Limit();
		System.out.println("Please enter the number of different coins in array");
		rcp.n=scan.nextInt();
		rcp.a=new int[rcp.n+1][2];
		for(int i=1;i<rcp.n+1;i++){
			rcp.a[i][0]=scan.nextInt();
			rcp.a[i][1]=scan.nextInt();
			
		}
		System.out.println("Please enter the size of rod you have");
		int b=scan.nextInt();
		
		int max=rcp.best1(rcp.a,b);
		
		System.out.println(max);
		
	}
}