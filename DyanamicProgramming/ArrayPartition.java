//partitioning of array in to two sets 
//such that they have minimum diff
package DyanamicProgramming;

public class ArrayPartition {
	
	static boolean Arraypartition(int arr[]) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		System.out.println(sum);
		int x=sum/2;
		System.out.println(x);
		if(sum%2!=0) {
			return false;
		}
		
		boolean matrix[][] = new boolean[arr.length][x+1];
        for(int i=0;i<arr.length;i++) {
        	matrix[i][0]=true;
        }
        for(int i=1;i<=x;i++) {
        	matrix[0][i]=false;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= x; j++) {
            	if(i>0) {
            		if(matrix[i-1][j]==true) {
            			matrix[i][j]=true;
                    }
                    else {
                	    if(arr[i]<=j) {
                		    matrix[i][j]=matrix[i-1][j-arr[i]];
                	    }
                	}
            	}
            }
        }
        return matrix[arr.length-1][x];
	}

	public static void main(String[] args) {
		int arr[]= {2,2,3,4,5,6};
		System.out.println(Arraypartition(arr));

	}

}






//1.length of longest pelondromic substring
//2.maximum common substring between two string










