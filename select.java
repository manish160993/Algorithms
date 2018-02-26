import java.util.Random;



class select{
	
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
		int a[]={9,8,7,1,2,3,4,6,5,0,11,10,100,199,99,222,23,22,12,202};
		select s=new select();
		System.out.println(s.select(a,0,a.length-1,a.length/2));
		for(int i=0;i<a.length-1;i++){
			for(int j=i;j<a.length;j++){
				if(a[i]>a[j]){
					int t=a[j];
					a[j]=a[i];
				a[i]=t;}
			}
		}
		System.out.println(a[(a.length-1)/2]);
		
	}
}