//https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
package Stack;
import java.util.*;
 
public class MaximumAreaHistogram {
	
	static class pair{
	      int ele;
	      int ind;
	      pair(int ele,int ind){
	          this.ele = ele;
	          this.ind = ind;
	      }
	 }

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
			System.out.print(right[i]+" ");
		}
		System.out.println(" <-- index of nearest smallest to right");
		//---------------------------------------------------------------------
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
		for(int i=0;i<n;i++) {
			System.out.print(left[i]+" ");
		}
		System.out.println(" <-- index of nearest smallest to left");
		//---------------------------------------------------------------------
		int width[] = new int[n];
		for(int i=0;i<n;i++) {
			width[i] = right[i] - left[i] -1;
			System.out.print(width[i]+" ");
		}
		System.out.println(" <-- width array");
		//---------------------------------------------------------------------
		int area[] = new int[n];
		for(int i=0;i<n;i++) {
			area[i] = (arr[i])*(width[i]);
			System.out.print(area[i]+" ");
		}
		System.out.println(" <-- area ");
		//---------------------------------------------------------------------
		int max=area[0];
		for(int i=0;i<n;i++) {
			if(area[i]>max) {
				max = area[i];
			}
		}
		return max;
		
	}

	public static void main(String[] args) {
		//int arr[] = {1,2,3,4,5}; //9
		int arr[] = {6,2,5,4,5,1,6};
		int n = arr.length;
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println(" <-- original array");
		System.out.println(MAH(arr,n));
	}

}
