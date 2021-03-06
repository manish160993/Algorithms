import java.util.*;
class DFS_graph_Connected_Components{
	int connected=0;
	int time=0;
	static class Vertex{
		String color="White";
		int num;
		int startTime=Integer.MAX_VALUE;
		int endTime=Integer.MAX_VALUE;
		int parent=-1;
		int connected_Comps=0;
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
			for(int i=0;i<v.length;i++){
			if(v[i].color.equals("Black")&&v[i].connected_Comps==0)
				connected++;
		}
		for(int i=0;i<v.length;i++){
			if(v[i].color.equals("Black")&&v[i].connected_Comps==0)
				v[i].connected_Comps=connected;
		}
		connected=0;
		}
		
		}
	}
	void DFS_M(int a[][],Vertex[] v,int k){
		
		time+=1;
		v[k].startTime=time;
		v[k].color="Grey";
		for(int j=0;j<v.length;j++){
		if(a[k][j]!=0)
		{
			if(v[j].color.equals("Black")&&v[k].startTime<v[j].endTime){
				System.out.println(k+" --> "+j+" Forward Edge"+" "+v[k].color+" "+v[j].color);
			}
			if(v[j].color.equals("Black")&&v[k].startTime>v[j].endTime){
				System.out.println(k+" --> "+j+" Cross Edge"+" "+v[k].color+" "+v[j].color);
			}	
			if(v[j].color.equals("Grey")){
				System.out.println(k+" --> "+j+" Back Edge"+" "+v[k].color+" "+v[j].color);
			}
			if(v[j].color.equals("White")){
			System.out.println(k+" --> "+j+" Tree Edge"+" "+v[k].color+" "+v[j].color);
			v[j].parent=k;
			DFS_M(a,v,j);
			time+=1;
			}
			
		}
		
		}
		v[k].color="Black";
		
		v[k].endTime=time;
	
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
		DFS_graph_Connected_Components rcp = new DFS_graph_Connected_Components();
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
		for(int i=0;i<v.length;i++){
			System.out.println(v[i].num+" "+v[i].connected_Comps);
		}
		
	}
}