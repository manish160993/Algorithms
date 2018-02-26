import java.util.Random;



class We_me{
	int median(int[] a,int l){
		int n=a.length;
		if(n==1)
			return a[0];
		int m=select(a,0,a.length-1,a.length/2);
		System.out.println(m+":m");
		int[] b=new int[a.length/2];
		int[] c=new int[a.length-a.length/2];
		int sum=0;
		for(int i=0;i<a.length/2;i++){
			b[i]=a[i];
			sum+=a[i];
			System.out.print(b[i]+" ");
		}
		System.out.println(" sum: "+sum);
		for(int i=a.length/2;i<a.length;i++)
		{c[i-a.length/2]=a[i];
		System.out.print(c[i-a.length/2]+" ");
		}
		
		if((sum+l)>=50)
			return median(b,l);
		else
			return median(c,l+sum);

	}
		
	int select(int[] A,int p,int r,int i){
		if(p==r)
			return A[p];
		int q=partition(A,p,r);
		System.out.println("q: "+q);
		int k=q-p+1;
		if(i==k)
			return A[q];
		else if(i<k)
			return select(A,p,q-1,i);
		else
			return select(A,q+1,r,i-k);
	}
	int partition(int[] a,int p,int r){
			Random rand = new Random();
			int  n = rand.nextInt((r-p)) + p;
			System.out.println("n: "+n+"r: "+r+"p: "+p);
			int y=a[n];
			a[n]=a[r];
			a[r]=y;
			int i=p-1;
			int j=p;
			for(int k=p;k<r;k++){
				if(a[k]<a[r]){
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
		int a[]={5,5,5,5,10,10,15,15,20,10};
		We_me s=new We_me();
		System.out.println("medi"+s.median(a,0));
		for(int i=0;i<a.length-1;i++){
			for(int j=i;j<a.length;j++){
				if(a[i]>a[j]){
					int t=a[j];
					a[j]=a[i];
				a[i]=t;}
			}
		}
		//System.out.println(a[(a.length-1)/2]);
		
	}
}