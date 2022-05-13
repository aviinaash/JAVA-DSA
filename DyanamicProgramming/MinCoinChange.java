package DyanamicProgramming;

public class MinCoinChange {
	
	static int mincoinchange(int coins[],int sum) {
		
		if(coins.length==0 || sum==0) {
			return 0;
		}
		int matrix[][]=new int[coins.length][sum+1];
		
		for(int i=0;i<coins.length;i++) {
			matrix[i][0]=0;
		}
		for(int i=0;i<coins.length;i++) {
			for(int j=1;j<=sum;j++) {
				int include=Integer.MAX_VALUE;
				int exclude=Integer.MAX_VALUE;
				
				if(coins[i]<=j) {
					include=1+matrix[i][j-coins[i]];
				}
				if(i>0) {
					exclude=matrix[i-1][j];
				}
				matrix[i][j]=Math.min(include, exclude);
			}
		}
		return matrix[coins.length-1][sum];
	}

	public static void main(String[] args) {
		int []coinss= {1,2,3,5};
		int sum=5;
		
		System.out.println(mincoinchange(coinss,sum));

	}

}





//                           0    1    2    3    4    5   <--sum
//      
//                     0     0    0    0    0    0    0                 
//
//
//     coins[1]        1     0    1    2    3    4    5
//   
//   
//     coins[1,2]      2     0    1    1    2    2    3
//   
//   
//     coins[1,2,3]    3     0    1    1    1    2    2


//exclude:-matrix[i-1][j]
//include:-1+matrix[i][j-coins[i]]








