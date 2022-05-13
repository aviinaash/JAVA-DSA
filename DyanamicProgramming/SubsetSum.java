package DyanamicProgramming;

public class SubsetSum {
	
	static boolean subsetsum(int arr[],int sum) {
        boolean matrix[][] = new boolean[arr.length][sum+1];
        for(int i=0;i<arr.length;i++) {
        	matrix[i][0]=true;
        }
        for(int i=1;i<=sum;i++) {
        	matrix[0][i]=false;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
            	
            	//checking while excluding
            	if(i>0) {
            		if(matrix[i-1][j]==true) {
            			matrix[i][j]=true;
                    }
                //checking while including 
                    else {
                	    if(arr[i]<=j) {
                		    matrix[i][j]=matrix[i-1][j-arr[i]];
                	    }
                	}
            	}
            }
        }
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j <= sum; j++) {
//                System.out.print(matrix[i][j]+"  ");
//            }
//            System.out.println();
//        }
        return matrix[arr.length-1][sum];
	}

	public static void main(String[] args) {
		int arr[]= {1,2,3,5};
		int sum=20;
		
		System.out.println(subsetsum(arr,sum));

	}

}



//  Algorithm
//arr[]= {1,2,3,5};sum=7

//                          0    1   2   3   4   5   6   7
//                    
//                     0    F    F   F   F   F   F   F   F
//   
//  [1]       -->      1    T    T   F   F   F   F   F   F       
//            
//  [1,2]     -->      2    T    T   T   T   F   F   F   F      
//            
//  [1,2,3]   -->      3    T    T   T   T   T   T   T   F                           
//            
//  [1,2,3,5] -->      4    T    T   T   T   T   T   T   T --->Final answer 

//including:-mat[i-1][j-arr[i]]
//excluding:-[i-1][j]