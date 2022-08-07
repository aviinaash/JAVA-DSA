//Maximum number of ways  //unbounded knapsack
//same as CountOfSubsetSumWithGivenSum 
package DP;
public class CoinChange {
	
	static int coinChange(int coin[],int sum) {
		int n=coin.length;
		int t[][]=new int[n+1][sum+1];
		//<--initialization-->
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(i==0)
					t[i][j] = 0;
				if(j==0)
					t[i][j] = 1;
			}
		}
        //<--Choice diagram-->
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(coin[i-1]<=j) {
					t[i][j] =  (t[i][j-coin[i-1]]) + (t[i-1][j]);
				}
				else if(coin[i-1]>j) {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][sum];
		
	}

	public static void main(String[] args) {
		int coin[]= {1,2,3};
		int sum = 4;
		System.out.println(coinChange(coin,sum));

	}

}


//Coin Change Problem Maximum Number of ways
//Given a value N, if we want to make change for N cents, and we have infinite supply of each of 
//S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
//		
//Example:
//for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.

