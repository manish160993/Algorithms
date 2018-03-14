import java.util.*;
class RCP_Most_Cuts{
	
	int[][] best(int a[],int c[]){
		int r[][]=new int[a.length][2];
		for(int i=1;i<a.length;i++){
			int max=a[i];
			int cut=c[i];
			for(int j=0;j<=i;j++){
				if(r[j][0]+r[i-j][0]>=max){
					if(r[j][1]+r[i-j][1]+1>c[i])
						cut=r[j][1]+r[i-j][1]+1;
					max=r[j][0]+r[i-j][0];
					//System.out.println(i+" "+j+" "+max+" "+r[j][1]+" "+r[i-j][1]+" "+cut);
				}
			}
			r[i][0]=max;
			r[i][1]=cut;
			
		}
	return r;
	}
		
	
	public static void main (String args[]){
		Scanner scan=new Scanner(System.in);
		RCP_Most_Cuts rcp = new RCP_Most_Cuts();
		System.out.println("Please enter the number of elements in array");
		int n=scan.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=scan.nextInt();
		System.out.println("Please enter the cost in array");
		int[] c=new int[n];
		for(int i=0;i<n;i++)
			c[i]=0;
		int r[][]=rcp.best(a,c);
		for(int i=0;i<a.length;i++){
			System.out.println(r[i][0]+" "+r[i][1]);
		}
	}
}