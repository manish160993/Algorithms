import java.util.*;
class Longest_Common_Sequence{
	
	int best(char a[],char b[]){
		int c[][]=new int[b.length][a.length];
		for(int i=0;i<a.length;i++)
		{
			c[0][i]=0;
			
		}
		for(int i=0;i<b.length;i++)
		{
			c[i][0]=0;
			
		}
		for(int i=1;i<b.length;i++){
			for(int j=1;j<a.length;j++){
				if(b[i]==a[j])
					c[i][j]=1+c[i-1][j-1];
				else
					c[i][j]=max(c[i-1][j],c[i][j-1]);
			}
		}
		return c[b.length-1][a.length-1];
		
	}
	int max(int a,int b){
		if(a>b)
			return a;
		else
			return b;
	}
			
	
	
	public static void main (String args[]){
		Scanner scan=new Scanner(System.in);
		Longest_Common_Sequence rcp = new Longest_Common_Sequence();
		System.out.println("Please enter the number of elements in array");
		
		String s=scan.next();
		String y=scan.next();
		char[] a=new char[s.length()+1];
		char[] b=new char[y.length()+1];
		for(int i=1;i<a.length;i++){
			a[i]=s.charAt(i-1);
			
		}
		for(int i=1;i<b.length;i++){
			b[i]=y.charAt(i-1);
			
		}
		
	
		int r=rcp.best(a,b);
		System.out.println(r);
		
	}
}