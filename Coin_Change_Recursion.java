import java.util.*;
class Coin_Change_Recursion{
	int best(int a[],int b){
		if(b==0)
			return 0;
		if(b<0)
			return Integer.MAX_VALUE;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<a.length;i++){
			if(b>=a[i])
			{
				int x=1+best(a,b-a[i]);
				if(min>x)
					min=x;
			}
		}
		return min;
	}
	
	
	
	public static void main (String args[]){
		Scanner scan=new Scanner(System.in);
		Coin_Change_Recursion rcp = new Coin_Change_Recursion();
		System.out.println("Please enter the number of different coins in array");
		int n=scan.nextInt();
		int[] a=new int[n];
		for(int i=0;i<a.length;i++){
			a[i]=scan.nextInt();
			
		}
		System.out.println("Please enter the change you want");
		int b=scan.nextInt();
		
		int min=rcp.best(a,b);
		
		System.out.println(min);
		
	}
}