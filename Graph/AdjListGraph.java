//implementation of graph using adjacency List
package Graph;
import java.util.*;

public class AdjListGraph {

	static LinkedList<Integer> graph[];
	static boolean visited[];
	
        static void GraphUsingList(int v,int e) {
		graph =new LinkedList[v];
		visited=new boolean[v];
		
		for(int i=0;i<v;i++) {
			graph[i]=new LinkedList<>();
		}
	    int source,destination;
		while(e>0) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter source vertex");
		    source=sc.nextInt();
			System.out.println("Enter destination vertex");
			destination=sc.nextInt();
			
			graph[source].add(destination);
			graph[destination].add(source);
			
			e--;
		}
		
		for(int i=0;i<v;i++) {
			if(graph[i].size()>0) {
				System.out.println("vertex "+i+" is connected to:-");
				for(int j=0;j<graph[i].size();j++) {
					System.out.print(graph[i].get(j)+" ");
				}
				System.out.println();
			}
		}
	}
	
	static void dfsUsingList(int source) {
		visited[source]=true;
		System.out.print(source+" ");
		
//		Iterator<Integer> itr= graph[source].listIterator();
//		while(itr.hasNext()) {
//			int value=itr.next();
//			if(visited[value]==false) {
//				dfsUsingList(value);
//			}
//		}4
		for(int i=0;i<graph[source].size();i++) {
			if(visited[graph[source].get(i)]==false) {
				dfsUsingList(graph[source].get(i));
			}
		}
		
	}
	

	static void bfsUsingList(int source) {
		visited[source]=true;
		Queue q=new LinkedList();
		q.offer(source);
		while(!q.isEmpty()) {
			int v=(int)q.poll();
			System.out.println(v+" ");
			
			for(int i=0;i<graph[v].size();i++) {
				if(visited[graph[v].get(i)]==false) {
					visited[graph[v].get(i)]=true;
					q.offer(graph[v].get(i));
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
		
		GraphUsingList(v,e);
		
		dfsUsingList(0);
		
		
	}

}


//
//          3
//        / | \
//       0  1  2
//
//  dfs=0 3 1 2
//
//
//
//
//


























