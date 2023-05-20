package DP;

public class LongestCommonSubstr {
	
	static int longestComStr(String x,String y,int n,int m) {
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
				if(x.charAt(i-1) == y.charAt(j-1)) {
					t[i][j]=1+t[i-1][j-1];
				}
				else {
					t[i][j]=0;
				}
			}
		}
		int ans = 0;
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                ans = Math.max(ans,t[i][j]);
            }
        }
        return ans;
	}
	
	static String printlcstr(String x, String y,int n,int m) {
		int[][] t = new int[n+1][m+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<m+1;j++) {
				if(i==0 || j==0) {
					t[i][j] = 0;
				}
			}
		}
		int maxLength = 0;  
		int endIndex = 0;	
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(x.charAt(i-1) == y.charAt(j-1)) {
					t[i][j] = t[i-1][j-1] + 1;
					if(t[i][j] > maxLength) {
						maxLength = t[i][j];
						endIndex = i-1;
					}
				 }else {
						t[i][j] = 0;
				  }
			}
		}
		return x.substring(endIndex-maxLength+1, endIndex+1); 
	}

	public static void main(String[] args) {
		String x = "GeeksforGeeks";
		String y = "GeeksQuiz";
		int n = x.length();
		int m = y.length();
		System.out.println(longestComStr(x,y,n,m));     //5
		System.out.println(printlcstr(x,y,n,m));
	}

}



//Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
//Examples:
//
//Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
//Output : 5
//The longest common substring is “Geeks” and is of length 5.
