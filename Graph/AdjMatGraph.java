//implementation of graph using adjacency matrix
package Graph;
import java.util.*;
public class AdjMatGraph {
	
    static int graph[][];
    static boolean visited[];
    
	static void GraphUsingMatrix(int v,int e) {
		graph = new int [v][v];
		visited=new boolean[v];
		int source,destination;
		while(e>0) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter source vertex");
			source=sc.nextInt();
			System.out.println("Enter destination vertex");
			destination=sc.nextInt();
			
			graph[source][destination]=1;
			graph[destination][source]=1;
			
			e--;
		}
		System.out.println("printing the graph");
		for(int i=0;i<v;i++) {
			for(int j=0;j<v;j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void dfsUsingMatrix(int source) {
		visited [source]=true;
		System.out.print( source+" ");
		
		for(int i=0;i<graph.length;i++) {
			if(graph[source][i]==1 && visited[i]==false) {
				dfsUsingMatrix(i);
			}
		}
	}
	
	static void bfsUsingMatrix(int source) {
		visited[source]=true;
		Queue q=new LinkedList();
		q.offer(source);
		while(!q.isEmpty()) {
			int v=(int)q.poll();
			System.out.println(v+" ");
			
			for(int i=0;i<graph.length;i++) {
				if(graph[v][i]==1 && visited[i]==false) {
					visited[i]=true;
					q.offer(i);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v,e;
		System.out.println("Enter no of vertices");
		v=sc.nextInt();
		System.out.println("Enter no of Edges");
		e=sc.nextInt();
		
		GraphUsingMatrix(v,e);
	
		dfsUsingMatrix(0);
		
		bfsUsingMatrix(0);
		
	}
}
