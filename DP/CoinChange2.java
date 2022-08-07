package DP;

public class CoinChange2 {
	
	static int coinChange(int coins[],int sum) {
		int n = coins.length;
		int t[][] = new int[n+1][sum+1];
		
		// initialization
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(i==0) {
					t[i][j] = Integer.MAX_VALUE-1;
				}
				if(j==0) {
					t[i][j] = 0;
				}
			}
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(j%coins[0] == 0) {
					t[i][j] = j/coins[0];
				}
				else {
					t[i][j] = Integer.MAX_VALUE-1;
				}
			}
		}
		for(int i=2;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(coins[i-1]<=j) {
					t[i][j] = Math.min( (1+t[i][j-coins[i-1]]) , (t[i-1][j]));
				}
				if(coins[i-1]>j) {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][sum];
	}

	public static void main(String[] args) {
		int coins[] = {25, 10, 5};
		int v = 30;
		System.out.println(coinChange(coins,v));   //2
	}

}






//Coin Change Problem Minimum Numbers of coins
//Given a value V, if we want to make change for V cents, and we have infinite supply of each of 
//C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?
//		
//Example:
//
//Input: coins[] = {25, 10, 5}, V = 30
//Output: Minimum 2 coins required
//We can use one coin of 25 cents and one of 5 cents 
