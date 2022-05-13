package Graph;
import java.util.*;

public class kahnsAlgo {

	static LinkedList<Integer> graph[];
	static boolean visited[];
    static Stack<Integer> st =new Stack<>();

	
        static void GraphUsingList(int v,int e) {
		graph =new LinkedList[v];
		visited=new boolean[v];
		
		for(int i=0;i<v;i++) {
			graph[i]=new LinkedList<>();
		}
	    int source,destination;
		while(e>0) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter source & destination vertex");
		    source=sc.nextInt();
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
		
		for(int i=0;i<graph[source].size();i++) {
			if(visited[graph[source].get(i)]==false) {
				dfsUsingList(graph[source].get(i));
			}
		}
		
	}
	
	static void KahnsAlgo(int s) {
		visited[s]=true;
		s=graph[s].size();
		for(int i=0;i<s;i++) {
			int child=graph[s].get(i);
			if(visited[child]==false) {
				KahnsAlgo(child);
			}
		}
		st.push(s);
		while(st.empty()==false) {
			System.out.println(st.pop()+" ");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v,e;
		System.out.println("Enter no of vertices and edges");
		v=sc.nextInt();
		e=sc.nextInt();
		
		GraphUsingList(v,e);
		
		//dfsUsingList(0);
		
        // Function Call
		KahnsAlgo(0);
		
		
	}

}

	