import java.util.*;
class Longest_Pali_Sequence_Dyna{
	static int q=0;
	
	static int max (int x, int y) { return (x > y)? x : y; }
 
// Returns the length of the longest palindromic subsequence in seq
static int lps(char[] seq,char[] seqrev)
{
	int max=0;
	int c[][]=new int[seq.length+1][seq.length+1];
	for(int i=0;i<seq.length+1;i++){
		c[i][0]=0;
		c[0][i]=0;
	}
	for(int i=1;i<seq.length+1;i++){
		for(int j=1;j<seq.length+1;j++){
			if(seq[i-1]==seqrev[j-1]){
				c[i][j]=1+c[i-1][j-1];
			}
			else
			{
				c[i][j]=max(c[i-1][j],c[i][j-1]);
			}
			if(c[i][j]>max)
			max=c[i][j];
		}
		
	}
	return max;
	
	
}
 
/* Driver program to test above functions */
public static void main(String[] args)
{
	String s="RARA";
	char[] seq=new char[s.length()];char[] seqrev=new char[s.length()];
    for(int i=0;i<s.length();i++)
	{seq[i]=s.charAt(i);
    seqrev[s.length()-i-1]=s.charAt(i);
	}
	System.out.println("The length of the LPS is "+ lps(seq,seqrev));
}
}