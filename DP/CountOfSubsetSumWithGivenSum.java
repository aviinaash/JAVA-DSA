package DP;

public class CountOfSubsetSumWithGivenSum {
	
	static int countsunsetsumrec(int arr[],int x,int n) {
		if(x==0) {
			return 1;
		}
		if(n==0) {
			return 0;
		}
		if(arr[n-1]<=x) {
			return countsunsetsumrec(arr,x-arr[n-1],n-1) + countsunsetsumrec(arr,x,n-1);
		}
		else if(arr[n-1]>x) {
			return countsunsetsumrec(arr,x,n-1);
		}
		return -1;
	}
	
	static int countsunsetsumitr(int arr[],int x,int n) {
		int t[][]=new int[n+1][x+1];
		//<--initialization-->
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<x+1;j++) {
				if(i==0)
					t[i][j] = 0;
				if(j==0)
					t[i][j] = 1;
			}
		}
        //<--Choice diagram-->
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<x+1;j++) {
				if(arr[i-1]<=j) {
					t[i][j] =  (t[i-1][j-arr[i-1]]) + (t[i-1][j]);
				}
				else if(arr[i-1]>j) {
					t[i][j] = t[i-1][j];
				}
			}
		}
		for(int i=0;i<n+1;i++){
	        for(int j=0;j<x+1;j++){
	            System.out.print(t[i][j]+" ");
	        }
	        System.out.println();
	    }
		return t[n][x];
	}
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 3};
		int x=6;
		int n=arr.length;
		System.out.println(countsunsetsumrec(arr,x,n));
		System.out.println(countsunsetsumitr(arr,x,n));
	}

}




//Count of subsets sum with a Given sum
//Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
//Example:
//
//Input: arr[] = {1, 2, 3, 3}, X = 6
//Output: 3
//All the possible subsets are {1, 2, 3},
//{1, 2, 3} and {3, 3}