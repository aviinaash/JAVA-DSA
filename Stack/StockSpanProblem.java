//https://www.geeksforgeeks.org/the-stock-span-problem/
package Stack;
import java.util.Stack;

public class StockSpanProblem {
	
	static class pair{
	      int ele;
	      int ind;
	      pair(int ele,int ind){
	          this.ele = ele;
	          this.ind = ind;
	      }
	 }
	static int[] SSP(int arr[],int n) {
		Stack <pair> st = new Stack<>();  
		int ans[] = new int[n];
		for(int i=0;i<n;i++) {
			if(st.isEmpty()) {
				ans[i] = -1;
			}
			else if(st.size()>0 && st.peek().ele > arr[i]) {
				ans[i] = st.peek().ind;
			}
			else if(st.size()>0 && st.peek().ele <= arr[i]) {
				while(st.size()>0 && st.peek().ele <= arr[i]) {
					st.pop();
				}
				if(st.isEmpty()) {
					ans[i] = -1;
				}
				else {
					ans[i] = st.peek().ind;
				}
			}
			st.push(new pair(arr[i],i));
		}
		for(int i=0;i<n;i++) {
			System.out.print(ans[i]+" ");  //printing index of next greater
			ans[i] = i-ans[i];
		}
		return ans;
	}
	static int[] SSP2(int arr[],int n) {
		Stack <Integer> st = new Stack<>();  
		int ans[] = new int[n];
		for(int i=0;i<n;i++) {
			if(st.isEmpty()) {
				ans[i] = -1;
			}
			else if(st.size()>0 && arr[st.peek()] > arr[i]) {
				ans[i] = st.peek();
			}
			else if(st.size()>0 && arr[st.peek()] <= arr[i]) {
				while(st.size()>0 && arr[st.peek()] <= arr[i]) {
					st.pop();
				}
				if(st.isEmpty()) {
					ans[i] = -1;
				}
				else {
					ans[i] = st.peek();
				}
			}
			st.push(i);
		}
		for(int i=0;i<n;i++) {
			System.out.print(ans[i]+" ");  //printing index of next greater
			ans[i] = i-ans[i];
		}
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = {100,80,60,70,60,75,85};
		int n = arr.length;
		int ans[] = SSP2(arr,n);
		System.out.println();
		for(int i=0;i<n;i++) {
		   System.out.print(ans[i]+" ");
		}
	}

}



// 10, 4, 5, 90, 120, 80
// -1  10 10 -1  -1  120  <-- next greater elemet to left
// -1  0  0  -1  -1  4    <-- index of next greater to left & -1 if no element present
//  0  1  2   3   4  5    <--index of array>
//  1  1  2   4   5  1   <-- final ans>


