//Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s.
package Stack;

import java.util.Stack;

import Stack.StockSpanProblem.pair;

public class MaxAreaRectangleBinaryMatrix {
	
	static int MAH(int arr[],int n) {
		int right[] = new int[n];
		Stack <pair> st = new Stack<>();
		for(int i=n-1;i>=0;i--) {
			if(st.isEmpty()) {
				right[i] = -1;
			}
			else if(st.size()>0 && st.peek().ele < arr[i]) {
				right[i] = st.peek().ind;
			}
			else if(st.size()>0 && st.peek().ele >= arr[i]) {
				while(st.size()>0 && st.peek().ele >= arr[i]) {
					st.pop();
				}
				if(st.isEmpty()) {
					right[i] = -1;
				}
				else {
					right[i] = st.peek().ind;
				}
			}
			st.push(new pair(arr[i],i));
		}
		for(int i=0;i<n;i++) {
		}
		int left[] = new int[n];
		Stack <pair> st2 = new Stack<>();
		for(int i=0;i<n;i++) {
			if(st2.isEmpty()) {
				left[i] = -1;
			}
			else if(st2.size()>0 && st2.peek().ele < arr[i]) {
				left[i] = st2.peek().ind;
			}
			else if(st2.size()>0 && st2.peek().ele >= arr[i]) {
				while(st2.size()>0 && st2.peek().ele >= arr[i]) {
					st2.pop();
				}
				if(st2.isEmpty()) {
					left[i] = -1;
				}
				else {
					left[i] = st2.peek().ind;
				}
			}
			st2.push(new pair(arr[i],i));
		}
		int width[] = new int[n];
		for(int i=0;i<n;i++) {
			width[i] = right[i] - left[i] -1;
		}
		int area[] = new int[n];
		for(int i=0;i<n;i++) {
			area[i] = (arr[i])*(width[i]);
		}
		int max=area[0];
		for(int i=0;i<n;i++) {
			if(area[i]>max) {
				max = area[i];
			}
		}
		return max;
	}
	
	static int MARBM(int mat[][],int m,int n) {
		int arr[] = new int[n];
		for(int j=0;j<n;j++) {
			arr[j] = mat[0][j];
		}
		int max = MAH(arr,n);
		//System.out.println(max1);
		for(int i=1;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(mat[i][j] == 0) {
					arr[j] = 0;
				}
				else {
					arr[j] = arr[j] + mat[i][j];
				}
			}
			max = Math.max(max, MAH(arr,n));
		}
		return max;
	}

	public static void main(String[] args) {
		int mat[][] = {
				{0,1,1,0},
				{1,1,1,1},
				{1,1,1,1},
				{1,1,0,0}
		};
		int n = mat.length;
		int m = mat.length;
		System.out.println(MARBM(mat,m,n));
	}

}
