import java.util.*;
class Coin_Change_Recursion_Limit_Dyna{
	int best(int a[][],int b){
		int[][] minNumCoins=new int[b+1][a.length];
		int c[][] = new int[a.length][2];
		
		for(int i=0;i<a.length;i++)
			minNumCoins[0][i]=0;
		for(int i=1;i<b+1;i++){
			for(int k=0;k<a.length;k++){
			c[k][0]=a[k][0];
			c[k][1]=a[k][1];
			}
			for(int j=a.length-1;j>=0;j--){
				minNumCoins[i][j]=Integer.MAX_VALUE;
				if(i>=c[j][0]&&c[j][1]>0){
					c[j][1]-=1;
					int sum;
					if(c[j][1]==0)
					{
						int min1=Integer.MAX_VALUE;
						for(int k=j-1;k>=0;k--){
							if(min1>minNumCoins[j][k])
								min1=minNumCoins[j][k];
						}
						sum= min1;
					}
					else
						sum= minNumCoins[i-c[j][0]][j];
					if(sum!=Integer.MAX_VALUE){
					int num=sum+1;
					//System.out.println(num);
					if(num<minNumCoins[i][j])
					{
						minNumCoins[i][j]=num;
					}
					}
				}
				
			}
			
		}
		int min=Integer.MAX_VALUE;
		for(int j=a.length-1;j>=0;j--){
			if(min>minNumCoins[b][j])
				min=minNumCoins[b][j];
		}
		System.out.println(Arrays.toString(minNumCoins[60]));
		return min;
		
	}
	
	
	
	
	public static void main (String args[]){
		Scanner scan=new Scanner(System.in);
		Coin_Change_Recursion_Limit_Dyna rcp = new Coin_Change_Recursion_Limit_Dyna();
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