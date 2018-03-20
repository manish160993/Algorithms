import java.util.*;
class DFS_graph{
	
	int time=0;
	static class Vertex{
		String color="White";
		int num;
		int startTime=Integer.MAX_VALUE;
		int endTime=Integer.MAX_VALUE;
		int parent=-1;
		Vertex(int n)
		{
			num=n;
		}
	}
	
	void DFS(int a[][],Vertex[] v){
		
		String ans="True";
		LinkedList<Vertex> Q=new LinkedList<Vertex>();
		for(int k=0;k<v.length;k++){
		if(v[k].color.equals("White"))
		{
			DFS_M(a,v,k);
		}
		}
	}
	void DFS_M(int a[][],Vertex[] v,int k){
		
		time+=1;
		v[k].startTime=time;
		v[k].color="Grey";
		for(int j=0;j<v.length;j++){
		if(a[k][j]!=0&&v[j].color.equals("White"))
		{
			v[j].parent=k;
			
			DFS_M(a,v,j);
			time+=1;
			
		}
		v[k].color="Black";
		
		v[k].endTime=time;
		}
	
	}
		
	void print(Vertex[] z,int s,int v){
		if(v==s)
			System.out.print(v);
		
		else
		{
			if(z[v].parent!=-1)
				print(z,s,z[v].parent);
			else
				{System.out.print(v);
				return;
				}
			System.out.print(v);
		}
	}
			
	
	
	
	public static void main (String args[]){
		Scanner scan=new Scanner(System.in);
		DFS_graph rcp = new DFS_graph();
		int n=scan.nextInt();
		Vertex[] v=new Vertex[n];
		for(int i=0;i<n;i++)
			v[i]=new Vertex(scan.nextInt());
		int a[][]=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				a[i][j]=scan.nextInt();
			}
		}
		rcp.DFS(a,v);
		System.out.println(" "+v[2].parent+" "+v[2].color+" "+v[2].startTime+" "+v[2].endTime+" "+v[0].startTime+" "+v[0].endTime);
		//rcp.print(v,0,4);
		
	}
}