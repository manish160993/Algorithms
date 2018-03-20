import java.util.*;

class Coin_Change{
	
	int best(int a[],int b){
		
		int[] minNumCoins=new int[b+1];
		minNumCoins[0]=0;
		for(int i=1;i<b+1;i++){
			minNumCoins[i]=Integer.MAX_VALUE;
			for(int j=0;j<a.length;j++){
				if(i>=a[j]){
					int num=minNumCoins[i-a[j]]+1;
					//System.out.println(num);
					if(num<minNumCoins[i])
						minNumCoins[i]=num;
				}
			}
		}
		return minNumCoins[b];
		
	}
	

	

	
	public static void main (String args[]){
		Scanner scan=new Scanner(System.in);
		Coin_Change rcp = new Coin_Change();
		System.out.println("Please enter the number of different coins in array");
		int n=scan.nextInt();
		int[] a=new int[n];
		for(int i=0;i<a.length;i++){
			a[i]=scan.nextInt();
			
		}
		System.out.println("Please enter the change you want");
		int b=scan.nextInt();
		
		int r=rcp.best(a,b);
		System.out.println(r);
		
	}
}