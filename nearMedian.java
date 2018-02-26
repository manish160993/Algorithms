import java.util.Random;


class nearMedian{
	
	int select(int[] A,int p,int r,int i){
		if(p==r){
			
			return A[p];
		}
		int q=partition(A,p,r);
		//System.out.println("q: "+q);
		int k=q-p+1;
		while(i!=k){
		if(i<k)
			return select(A,p,q-1,i);
		else
			return select(A,q+1,r,i-k);
		}
		return A[q];
	}
	int partition(int[] a,int p,int r){
			Random rand = new Random();
			int  n = rand.nextInt((r-p)) + p;
			//System.out.println("n: "+n+"r: "+r+"p: "+p);
			int y=a[n];
			a[n]=a[r];
			a[r]=y;
			int i=p-1;
			int j=p;
			//int[] b=new int[7];
			//int q=0;
			for(int k=p;k<r;k++){
				if(a[k]<=a[r]){
					//b[q++]=k;
					int z=a[k];
					a[k]=a[++i];
					a[i]=z;
				}
			}
		int s=a[r];
		a[r]=a[i+1];
		a[i+1]=s;
		
		return i+1;
	}
				
	

	public static void main(String args[]) {
		int a[]={5,7,9,8,2,6,0};
		int b[]=new int[a.length];
		int c[]=new int[a.length];
		int k=4;
		nearMedian s=new nearMedian();
		int m=s.select(a,0,a.length-1,(a.length)/2);
		for(int i=0;i<b.length;i++)
		{
			if(a[i]<=m)
			{b[i]=m-a[i];
			c[i]=m-a[i];}
			else
			{b[i]=a[i]-m;
			c[i]=a[i]-m;}
		}
		int d[]=new int[k];
		int e=0;
		System.out.println();
		for(int i=0;i<c.length;i++)
			System.out.print(c[i] +" ");
		System.out.println();
		int z=s.select(c,0,c.length-1,k);
		System.out.println("z: "+z+" m: "+m);
		int count=0;
		int flag=0;
		for(int i=0;i<a.length;i++){
			
			if(b[i]<=z && count<k && flag==0){
				d[e]=m-b[i];
				e++;
				count++;
				if(b[i]==0)
					flag=1;
			}
			if(b[i]<=z && b[i]!=0 && count<k && flag==1){
				d[e]=b[i]+m;
				e++;
				count++;
			}
		}
		for(int i=0;i<d.length;i++)
			System.out.print(d[i] +" ");
		System.out.println();
		
	}
}