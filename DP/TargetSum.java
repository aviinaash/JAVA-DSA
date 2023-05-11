package DP;
// same as CountTheNoOfSubsetWithGivenDiff
public class TargetSum {
	
	static int targetSum(int arr[],int S) {
		int s1=0,sum=0;int n=arr.length;
		for(int i=0;i<n;i++) {
			sum += arr[i];
		}
		s1 = (S+sum)/2;  
		
		
		
		//System.out.println(s1);
		int t[][] = new int[n+1][s1+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<s1+1;j++) {
				if(i==0)
					t[i][j] = 0;
				if(j==0)
					t[i][j] = 1;
			}
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<s1+1;j++) {
				if(arr[i-1]<=j) {
					t[i][j] =  (t[i-1][j-arr[i-1]]) + (t[i-1][j]);
				}
				else if(arr[i-1]>j) {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][s1];
	}

	public static void main(String[] args) {
		int arr[] = {1,1,1,1,1};
		int S = 3;
		System.out.println(targetSum(arr,S));  //5
	}
}



// https://leetcode.com/problems/target-sum/

//Given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 
//symbols + and . For each integer, you should choose one from + and - as its new symbol.
//
//Find out how many ways to assign symbols to make sum of integers equal to target S.
//
//Example 1:
//Input: nums is [1, 1, 1, 1, 1], S is 3. 
//Output: 5
//Explanation: 
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//There are 5 ways to assign symbols to make the sum of nums be target 3.