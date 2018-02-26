class BitonicArray{
	
	void Xsort(int[] A,int p,int r){
		int n=r-p+1;
		if(n<=1)
			return;
		if(A[p]>A[r])
		{
			int x=A[p];
			A[p]=A[r];
			A[r]=x;
		}
		if(n==2)
			return;
		int nb3=n/3;
		Xsort(A,p,r-nb3);
		Xsort(A,p+nb3,r);
		Xsort(A,p,r-nb3);
	}
		
	
	int findBitonic(int[] A,int p,int r){
		int q=(p+r)/2;
		//System.out.print(q+" ");
		if(A[q-1]>A[q] && A[q]>A[q+1])
			return findBitonic(A,p,q);
		else if(A[q-1]<A[q] && A[q]>A[q+1])
			return A[q];
		else
			return findBitonic(A,q,r);
		
	}
	
	int Search(int[] a,int p,int r, int x){
		int q=(p+r)/2;
		if(x<a[q]){
			return Search(a,p,q,x);
		}
		else if(x>=a[q]&&x<a[q+1])
			return q;
		else
			return Search(a,q+1,r,x);
	}
	
	public static void main(String[] args){
		int a[]={5,4,3,2,6,7};
		BitonicArray b=new BitonicArray();
		//System.out.println(b.findBitonic(a,0,a.length-1));
		//System.out.println(b.Search(a,0,a.length-1,7));
		b.Xsort(a,0,a.length-1);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
}
