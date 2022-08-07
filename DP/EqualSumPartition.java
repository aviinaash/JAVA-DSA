package DP;

public class EqualSumPartition {
	
	// <------------------Recursive------------------->
	
	static boolean equalsumrec(int []arr,int x,int n) {
		int sum=0;
		for(int i=0;i<n;i++) {
			sum+=arr[i];
		}
		System.out.println(sum);
		if(sum%2!=0) {
			return false;
		}
		x=sum/2;
		if(x==0) {
			return true;
		}
		if(n==0) {
			return false;
		}
		if(arr[n-1]<=x) {
			return equalsumrec(arr,x-arr[n-1],n-1) || equalsumrec(arr,x,n-1);
		}
		else if(arr[n-1]>x) {
			return equalsumrec(arr,x,n-1);
		}
		return false;
	}
	
	// <----------------iterative--------------------->
	static boolean equalsumitr(int []arr,int x,int n) {      //n-->i and x-->j
		int sum=0;
		for(int i=0;i<n;i++) {
			sum+=arr[i];
		}
		System.out.println(sum);
		if(sum%2!=0) {
			return false;
		}
		x=sum/2;
		System.out.println(x);
		boolean t[][]=new boolean[n+1][x+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<x+1;j++) {
				if(i==0)
					t[i][j] = false;
				if(j==0)
					t[i][j] = true;
			}
		}
		for(int i=1;i<n+1;i++) {
			for(int j=0;j<x+1;j++) {
				if(arr[i-1]<=j) {
					t[i][j]=t[i-1][j-arr[i-1]]  || t[i-1][j];
				}
				else if(arr[i-1]>j) {
					t[i][j]=t[i-1][j];
				}
			}
		}
		return t[n][x];
    }

	public static void main(String[] args) {
		int arr[]= {2,2,3,4,5,6};
		int n = arr.length;
		int x = 11;
		System.out.println(equalsumrec(arr,x,n));
		System.out.println("-------------------");
		System.out.println(equalsumitr(arr,x,n));
	}
}
