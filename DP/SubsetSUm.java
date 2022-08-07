package DP;

public class SubsetSUm {
	
	// <------------------Recursive------------------->
	static boolean subsetsumrec(int []arr,int sum,int n) {
		if(sum==0) {
			return true;
		}
		if(n==0) {
			return false;
		}
		if(arr[n-1]<=sum) {
			return subsetsumrec(arr,sum-arr[n-1],n-1) || subsetsumrec(arr,sum,n-1);
		}
		else if(arr[n-1]>sum) {
			return subsetsumrec(arr,sum,n-1);
		}
		return false;
	}
	
	// <----------------iterative--------------------->
	static boolean subsetsumitr(int []arr,int sum,int n) {   //n=i,sum=j
		boolean t[][]=new boolean[n+1][sum+1];
		//<--initialization-->
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(i==0)
					t[i][j] = false;
				if(j==0)
					t[i][j] = true;
			}
		}
        //<--Choice diagram-->
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(arr[i-1]<=j) {
					t[i][j] =  (t[i-1][j-arr[i-1]]) || (t[i-1][j]);
				}
				else if(arr[i-1]>j) {
					t[i][j] = t[i-1][j];
				}
			}
			//return false;
		}
		return t[n][sum];
	}

	public static void main(String[] args) {
		int arr[]= {1,2,3,5,6,7,10,11,12,13};
		int arr2[] = {1,2,3,5};int sum2=11;int n2=arr2.length;
		int n=arr.length;
		int sum=101;
		
		System.out.println(subsetsumrec(arr,sum,n));
		System.out.println("-------------------");
		System.out.println(subsetsumitr(arr2,sum2,n2));
	}

}
