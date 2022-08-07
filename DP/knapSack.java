package DP;

public class knapSack {
	
	    // <------------------Recursive------------------->
		static int knapsackrec(int wt[],int val[],int W,int n) {
			if(n==0 || W==0) {        
				return 0;
			}
			if(wt[n-1]<=W) {
				return Math.max((val[n-1]+knapsackrec(wt,val,W-wt[n-1],n-1)), knapsackrec(wt,val,W,n-1));
			}
			else if(wt[n-1]>W) {
				return knapsackrec(wt,val,W,n-1);
			}
			return 0;
		}

		// <----------------Memoization--------------------->
		//Memoization
		static int knapsackmem(int wt[],int val[],int W,int n) {
			int t[][]=new int [n+1][W+1];
			for(int i=0;i<n+1;i++) {
				for(int j=0;j<W+1;j++) {
					t[i][j]=-1;
					//System.out.print(t[i][j]);
				}
				//System.out.println();
			}
			if(n==0 || W==0) {
				return 0;
			}
			if(t[n][W]!=-1) {
				return t[n][W];
			}
			if(wt[n-1]<=W) {
				return t[n][W]=Math.max((val[n-1]+knapsackrec(wt,val,W-wt[n-1],n-1)), knapsackrec(wt,val,W,n-1));
			}
			else if(wt[n-1]>W) {
				return t[n][W]=knapsackrec(wt,val,W,n-1);
			}
			return 0;
		}
		
		// <----------------iterative--------------------->
		// Top Down Approach
		static int knapsackTopDown(int wt[],int val[],int W,int n) {
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
						t[i][j]=Math.max((val[i-1] + t[i-1][j-wt[i-1]]), (t[i-1][j]));
					}
					else if(wt[i-1]>j) {
						t[i][j]=t[i-1][j];
					}
				}
			}
//			for(int i=0;i<n+1;i++) {
//				for(int j=0;j<W+1;j++) {
//					System.out.print(t[i][j]+" ");
//				}
//				System.out.println();
//			}
			return t[n][W];
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int wt[]= {1,2,3,5};
		int val[]= {1,4,7,10};
		int n=wt.length;
		int capacity=8;
//		System.out.println(knapsackrec(wt,val,capacity,n));
//		System.out.println("-------------------");
//		System.out.println(knapsackmem(wt,val,capacity,n));
//		System.out.println("-------------------");
		System.out.println(knapsackTopDown(wt,val,capacity,n));
	}

}
