import java.util.*;
class Coin_Change_Recursion_Limit_Method2{
	int best(int a[][],int b){
		if(b==0)
			return 0;
		if(b<0)
			return Integer.MAX_VALUE;
		int min=Integer.MAX_VALUE;
		for(int i=a.length-1;i>=0;i--){
			if(b>=a[i][0]&&a[i][1]>0)
			{
				a[i][1]-=1;
				int z=best(a,b-a[i][0]);
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
		Coin_Change_Recursion_Limit_Method2 rcp = new Coin_Change_Recursion_Limit_Method2();
		System.out.println("Please enter the number of different coins in array");
		int n=scan.nextInt();
		int[][] a=new int[n][2];
		for(int i=0;i<n;i++){
			a[i][0]=scan.nextInt();
			a[i][1]=scan.nextInt();
			
		}
		System.out.println("Please enter the change you want");
		int b=scan.nextInt();
		
		int min=rcp.best(a,b);
		
		System.out.println(min);
		
	}
}