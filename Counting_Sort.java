import java.util.Scanner;

class Counting_Sort{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		System.out.println("Pleasse enter the number of elements in array");
		int n=scan.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=scan.nextInt();
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++){
			if(min>a[i])
				min=a[i];
			if(max<a[i])
				max=a[i];
		}
		for(int i=0;i<a.length;i++){
			a[i]-=min;
		}
		//max-=min;
		int[] c=new int[max-min+1];
		System.out.println(max-min+1);
		for(int i=0;i<a.length;i++)
			c[a[i]]++;
		for(int i=1;i<c.length;i++)
			c[i]=c[i]+c[i-1];
		
		System.out.println("Please enter the range in which you need to find the integers.");
		int f1=scan.nextInt();
		int f2=scan.nextInt();
		int min_total;
		int max_total;
		if(f1>=min)
			min_total=c[f1-min];
		else
			min_total=0;
		if(f2<=max)
			max_total=c[f2-min];
		else
			max_total=c[c.length-1];
			
		System.out.println(max_total-min_total);
	}
}