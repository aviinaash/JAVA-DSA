package DyanamicProgramming;

public class KnapSock {
	
	//knap sack problem (bounded problem)
	static int knapsack(int []wt,int pr[],int capacity) 
	{
		int arr[][]=new int[wt.length][capacity+1];
		for(int i=0;i<wt.length;i++) {
			arr[i][0]=0;
		}
		for(int j=0;j<=capacity;j++) {
			if(wt[0]<=j) {
				arr[0][j]=pr[0];
			}
		}
		for(int i=1;i<wt.length;i++) {
			for(int j=1;j<=capacity;j++) {
				int includingpr=0;
				if(wt[i]<=j) {
					includingpr=pr[i]+arr[i-1][j-wt[i]];
				}
				int notIncludingpr=arr[i-1][j];
				arr[i][j]=Math.max(includingpr, notIncludingpr);
			}
		}
		return arr[wt.length-1][capacity];
		
	}
	

	public static void main(String[] args) {
		int weight[]= {1,2,3,5};
		int profit[]= {1,4,7,10};
		int capacity=8;
		
		System.out.println(knapsack(weight,profit,capacity));

	}

}




        //knap sack algo

//pr     wt    0    1    2    3    4    5    6    7    8   <-----capacity
//       |
//1 <--  1     0    1    1    1    1    1    1    1    1
//
//4 <--  2     0    1    4    5    5    5    5    5    5
//
//7 <--  3     0    1    4    7    8    11   12   12   12
//
//10 <-- 5     0    1    4    7    8    11   12   14   17 -->final ans












