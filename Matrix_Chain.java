import java.util.*;
class Matrix_Chain{
	
	int[][] best(int z[]){
		int n=z.length;
		int m[][]=new int[n][n];
		int s[][]=new int[n][n];
		for(int i=1;i<n;i++)
			m[i][i]=0;
		for(int l=2;l<n;l++){
			for(int i=1;i<n-l+1;i++){
				int j=i+l-1;
				m[i][j]=Integer.MAX_VALUE;
				//System.out.println("l :>> "+l+"j :>>  "+j+" i :>> "+i);
				for(int k=i;k<=j-1;k++){
					int q=m[i][k]+m[k+1][j]+z[i-1]*z[k]*z[j];
					//System.out.println(q+" "+z[i-1]+" "+z[k]+" "+z[j]+" "+m[i][k]+" "+m[k+1][j]+" "+k+" " +j);
					if(q<m[i][j]){
						m[i][j]=q;
						//System.out.println("q :>> "+q);
						s[i][j]=k;
					}
				}
			}
		}
		return s;// return m for cost operations
	}
			
	void print(int[][] s,int i,int j){
		if(i==j)
			System.out.print(i);
		else{
			System.out.print("(");
			print(s,i,s[i][j]);
			print(s,s[i][j]+1,j);
			System.out.print(")");
		}
	}
	
	public static void main (String args[]){
		Scanner scan=new Scanner(System.in);
		Matrix_Chain rcp = new Matrix_Chain();
		System.out.println("Please enter the number of elements in array");
		int n=scan.nextInt();
		int[] a=new int[n];
		System.out.println("Please enter the start & end time");
		for(int i=0;i<n;i++)
		{
			a[i]=scan.nextInt();
		}
	
		int[][] r=rcp.best(a);
		rcp.print(r,1,n-1);
		for(int i=1;i<n;i++){
			for(int j=i;j<n;j++){
				System.out.print(r[i][j]+" ");
			}
			System.out.println();
		}
	}
}