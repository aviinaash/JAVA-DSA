package Graph;
import java.util.*;
public class kruskalAlgo {
	static boolean visited[];
	int source,destination,weight;
	class Edge{
		int src,dest,wet;
		Edge(int src,int dest,int wet){
			this.src=src;this.dest=dest;this.wet=wet;
		}
	}

	void kruskalMst() {
		Scanner sc=new Scanner(System.in);
		//int source,destination,weight;
		int v=0,e=0;
		visited=new boolean[v];
		visited[source]=false;

		while(e>0) {
			System.out.println("Enter source vertex");
			source=sc.nextInt();
			System.out.println("Enter destination vertex");
			destination=sc.nextInt();
			System.out.println("Enter weight");
			weight=sc.nextInt();

			Edge result[] = new Edge[e];
			for(int i=0;i<result.length;i++) {
				result[i]=new Edge(source,destination,weight);
			}
			Arrays.sort(result);
			for(int i=0;i<result.length;i++) {

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

	}

}
