import java.util.*;
class Longest_Pali_Sequence{
	static int q=0;
	
	static int max (int x, int y) { return (x > y)? x : y; }
 
// Returns the length of the longest palindromic subsequence in seq
static int lps(char[] seq, int i, int j)
{
	System.out.println(q++);
   // Base Case 1: If there is only 1 character
   if (i == j)
     return 1;
 
   // Base Case 2: If there are only 2 characters and both are same
   if (seq[i] == seq[j] && i + 1 == j)
     return 2;
 
   // If the first and last characters match
   if (seq[i] == seq[j])
      return lps (seq, i+1, j-1) + 2;
 
   // If the first and last characters do not match
   return max( lps(seq, i, j-1), lps(seq, i+1, j) );
}
 
/* Driver program to test above functions */
public static void main(String[] args)
{
	String s="RAJ";
	char[] seq=new char[s.length()];
    for(int i=0;i<s.length();i++)
		seq[i]=s.charAt(i);
    int n = seq.length;
    System.out.println("The length of the LPS is "+ lps(seq, 0, n-1));
}
}