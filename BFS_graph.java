import java.util.*;
class BFS_graph{
	
	static class Vertex{
		String team="";
		String colot="White";
		int num;
		int dist=Integer.MAX_VALUE;
		int parent=-1;
		Vertex(int n)
		{
			num=n;
		}
	}
	
	String best(int a[][],Vertex[] v){
		
		String ans="True";
		LinkedList<Vertex> Q=new LinkedList<Vertex>();
		for(int k=0;k<v.length;k++){
		if(v[k].colot.equals("White"))
		{
		int s=k;
		Q.add(v[s]);
		v[s].colot="Grey";
		v[s].team="Good";
		v[s].dist=0;
		while(!Q.isEmpty()){
			int x=Q.remove(0).num;
			for(int i=0;i<v.length;i++){
				if(a[x][i]!=0 && v[i].colot.equals("White")){
					v[i].colot="Grey";
					v[i].parent=x;
					v[i].dist=v[x].dist+1;
					Q.add(v[i]);
					if(v[i].dist%2==0)
						v[i].team="Good";
					else
						v[i].team="Bad";
				}
			}
			v[x].colot="Black";
		}
		
		for(int i=0;i<v.length;i++){
			for(int j=0;j<v.length;j++){
				if(a[i][j]!=0 && v[i].dist%2==v[j].dist%2 && v[i].team.equals(v[j].team))
				{
					ans= "No";
					break;
				}
			}
		}
		}
		}
				
		return ans;
	}
	void print(Vertex[] z,int s,int v){
		if(v==s)
			System.out.print(v);
		else if(z[v].dist==Integer.MAX_VALUE)
			System.out.print("No");
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
		BFS_graph rcp = new BFS_graph();
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
		System.out.println(rcp.best(a,v)+" "+v[2].parent+" "+v[2].colot+" "+v[2].dist+" "+v[2].team);
		rcp.print(v,0,4);
		
	}
}