package DP;
import java.util.*;
public class MinSubsetSumDiff {
	
	static  int minsubsumdiff(int arr[]) {
		int sum=0;int n=arr.length;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		boolean t[][]=new boolean[n+1][sum+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(i==0)
					t[i][j] = false;
				if(j==0)
					t[i][j] = true;
			}
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(arr[i-1]<=j) {
					t[i][j] =  (t[i-1][j-arr[i-1]]) || (t[i-1][j]);
				}
				else if(arr[i-1]>j) {
					t[i][j] = t[i-1][j];
				}
			}
		}
		ArrayList<Integer> li = new ArrayList<>();
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(t[n][j]==true) {
					li.add(j);
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int k=0;k<li.size();k++) {
			min = Math.min(min, Math.abs(sum-(2*li.get(k))));
		}
		
		return min;
	}

	public static void main(String[] args) {
		int arr[] = {1, 6, 11, 5,10,15};    // (15+10) - (1+6+11+5) = 2
		System.out.println(minsubsumdiff(arr));
	}

}



//https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/


//Sum of subset differences
//Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
//If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
//
//Example:
//Input:  arr[] = {1, 6, 11, 5} 
//Output: 1
//Explanation:
//Subset1 = {1, 5, 6}, sum of Subset1 = 12 
//Subset2 = {11}, sum of Subset2 = 11 