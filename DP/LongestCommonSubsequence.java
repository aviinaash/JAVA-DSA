package DP;

public class LongestCommonSubsequence {

	//Recursive
	static int lcsrec(String a,String b,int n,int m) {
		if(n==0 || m==0) {
			return 0;
		}
		if(a.charAt(n-1) == b.charAt(m-1)) {
			return 1+lcsrec(a,b,n-1,m-1);
		}
		else {
			return Math.max(lcsrec(a,b,n,m-1), lcsrec(a,b,n-1,m-1));
		}
	}

	//Memoization
	static int lcsmem(String a,String b,int n,int m) {
		int t[][] = new int [n+1][m+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<m+1;j++) {
				t[i][j] = -1;
			}
		}
		if(n==0 || m==0) {
			return 0;
		}
		if(t[n][m] != -1) {
			return t[n][m];
		}
		if(a.charAt(n-1) == b.charAt(m-1)) {
			return t[n][m]=1+lcsrec(a,b,n-1,m-1);
		}
		else {
			return t[n][m]=Math.max(lcsrec(a,b,n,m-1), lcsrec(a,b,n-1,m-1));
		}
	}
	
	//iterative
	static int lcsitr(String a,String b,int n,int m) {
		int t[][] = new int [n+1][m+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<m+1;j++) {
				if(i==0 || j==0) {
					t[i][j] = 0;
				}
			}
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<m+1;j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					t[i][j]=1+t[i-1][j-1];
				}
				else {
					t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
				}
			}
		}
		return t[n][m];
	}
	public static void main(String[] args) {
		String a = "abcdgh";
		String b = "abedfhr";
		int n = a.length();int m = b.length();
		System.out.println(lcsrec(a,b,n,m));  // abdh-->4
		System.out.println(lcsmem(a,b,n,m));
		System.out.println(lcsitr(a,b,n,m));
	}

}


//Longest Common Subsequence Problem solution using recursion
//
//Given two sequences, find the length of longest subsequence present in both of them.
//A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. 