package Graph;

public class FloydWarshell {
	
	static int inf=99999;
	static int v=4;

	static void Floyd_Warshell(int graph[][]) {
		int dist[][]=new int[v][v];
		for (int i=0;i<v;i++) {
			for (int j=0;j<v;j++) {
				dist[i][j]=graph[i][j];
			}
		}
		for(int k=0;k<v;k++) {
			for(int i=0;i<v;i++) {
				for(int j=0;j<v;j++) {
					if(dist[i][k]+dist[k][j]<dist[i][j]) {
						dist[i][j]=dist[i][k]+dist[k][j];
					}
				}
			}
		}
		System.out.println("shortest distance between every pair");
		for (int i=0; i<v; ++i){
            for (int j=0; j<v; ++j){
                if (dist[i][j]==inf) {
                    System.out.print("inf ");
                }
                else {
                    System.out.print(dist[i][j]+"   ");
                }
            }
            System.out.println();
        }
	}
	
	public static void main(String[] args) {
		int graph[][] = { {0,   5,  inf, 10},
                {inf, 0,   3, inf},
                {inf, inf, 0,   1},
                {inf, inf, inf, 0}
              };
		
		Floyd_Warshell(graph);
	}

}
