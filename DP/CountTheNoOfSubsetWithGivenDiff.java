package DP;

public class CountTheNoOfSubsetWithGivenDiff {
	
	static int countSubset(int arr[],int diff) {
		int s1=0,sum=0;int n=arr.length;
		for(int i=0;i<n;i++) {
			sum += arr[i];
		}
		s1 = (diff+sum)/2;
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
		int arr[] = {1,1,2,3};
		int diff = 1;
		System.out.println(countSubset(arr,diff));   //3
	}

}





//Given an array Arr[] and a difference diff, find the number of subsets that array 
//can be divided so that each the difference between the two subset is the given diff.

//Example1:
//Input:
//Arr[] : 1,1,2,3
//diff: 1
//Output: 3 . 