class Fibonacci_Recursion{
	int Fibo(int n){
		if(n==0 || n==1)
			return n;
		return Fibo(n-1)+Fibo(n-2);
	}
	
	public static void main(String[] args){
		Fibonacci f=new Fibonacci();
		System.out.println(f.Fibo(5));
	}
}
	