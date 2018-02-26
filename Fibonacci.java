class Fibonacci{
	int Fibo(int n){
		int A[]=new int[n+1];
		A[0]=0;
		A[1]=1;
		for(int i=2;i<=n;i++){
			A[i]=A[i-1]+A[i-2];
		}
		return A[n];
	}
	
	public static void main(String[] args){
		Fibonacci f=new Fibonacci();
		System.out.println(f.Fibo(10));
	}
}
	