import java.util.*;
class Coin_Change_Recursion_Limit{
	public int[][] a;
	public int n;
	int best1(int a[][],int b){
		int min=Integer.MAX_VALUE;
		int[][] c=new int[n][2];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<=i;j++){
				c[j][0]=a[j][0];
				c[j][1]=a[j][1];
				System.out.println(c[j][0]+"-->"+c[j][1]+" "+a[j][0]+"-->" +a[j][1]);
			}
			int x=best(c,b,i);
			if(x<min)
				min=x;
		}
		return min;
	}
			
	int best(int c[][],int b,int j){
		if(b==0)
			return 0;
		if(b<0)
			return Integer.MAX_VALUE;
		int min=Integer.MAX_VALUE;
		for(int i=j;i>=0;i--){
			if(b>=c[i][0]&&c[i][1]>0)
			{
				c[i][1]-=1;
				int z=best(c,b-c[i][0],j);
				if(z!=Integer.MAX_VALUE)
				{
					
				int x=1+z;
				if(min>x)
					min=x;
				}
			}
		}
		return min;
	}
	
	
	
	public static void main (String args[]){
		Scanner scan=new Scanner(System.in);
		Coin_Change_Recursion_Limit rcp = new Coin_Change_Recursion_Limit();
		System.out.println("Please enter the number of different coins in array");
		rcp.n=scan.nextInt();
		rcp.a=new int[rcp.n][2];
		for(int i=0;i<rcp.n;i++){
			rcp.a[i][0]=scan.nextInt();
			rcp.a[i][1]=scan.nextInt();
			
		}
		System.out.println("Please enter the change you want");
		int b=scan.nextInt();
		
		int min=rcp.best1(rcp.a,b);
		
		System.out.println(min);
		
	}
}