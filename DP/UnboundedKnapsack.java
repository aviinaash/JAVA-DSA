package DP;
// multiple occurances of element
public class UnboundedKnapsack {
	
	static int Unknapsack(int wt[],int val[],int W,int n) {
		int t[][]=new int [n+1][W+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<W+1;j++) {
				if(i==0 || j==0) {
					t[i][j]=0;
				}
			}
		}
		for(int i=1;i<n+1;i++) {               //n-->i and W-->j
			for(int j=1;j<W+1;j++) {
				if(wt[i-1]<=j) {
					t[i][j]=Math.max((val[i-1] + t[i][j-wt[i-1]]), (t[i-1][j]));
				}
				else if(wt[i-1]<=j){
					t[i][j]=t[i-1][j];
				}
			}
		}
//		for(int i = 0;i<n+1;i++) {
//			for(int j = 0;j<W+1;j++) {
//				System.out.print(t[i][j]+" ");
//			}
//			System.out.println();
//		}
		return t[n][W];
	}
	
	public static void main(String[] args) {
//		int wt[]= {1,50};
//		int val[]= {1,30};
//		int n=wt.length;
//		int capacity=100;
		int wt[]= {1,2,3,5};
		int val[]= {1,4,7,10};
		int n=wt.length;
		int capacity=8;
		
		System.out.println(Unknapsack(wt,val,capacity,n));

	}

}




//Unbounded Knapsack (Repetition of items allowed)
//Given a knapsack weight W and a set of n items with certain value vali and weight wti, we need to calculate minimum amount that could make up this quantity exactly. This is different from classical Knapsack problem, here we are allowed to use unlimited number  of instances of an item.
//Examples:
//
//Input : W = 100
//      val[]  = {1, 30}
//      wt[] = {1, 50}
//Output : 100



//There are many ways to fill knapsack.
//1) 2 instances of 50 unit weight item.
//2) 100 instances of 1 unit weight item.
//3) 1 instance of 50 unit weight item and 50
//   instances of 1 unit weight items.
//We get maximum value with option 2.
