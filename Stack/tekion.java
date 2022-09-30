package Stack;
import java.util.*;

public class tekion {
	static int[] solve(int N,int X,int arr[]) {
		for(int i=0;i<N;i++) {
			arr[i] = arr[i] +X;
		}
		Stack <Integer> st = new Stack<>();  
		int ans[] = new int[N];
		for(int i=N-1;i>=0;i--) {
			if(st.isEmpty()) {
				ans[i] = (-1);
			}
			else if(st.size()>0 && st.peek() > arr[i]) {
				if(st.peek()>arr[i]) {
					continue;
				}
			}
			Iterator itr = st.iterator();
	        while (itr.hasNext()) {
	            if(st.get(i)>arr[i]) {
	            	ans[i] = st.peek();
	            }
	        }
			if(st.size()>0 && st.peek() <= arr[i]) {
				while(st.size()>0 && st.peek() <= arr[i]) {
					st.pop();
				}
				if(st.isEmpty()) {
					ans[i] = (-1);
				}
				else {
			        while (itr.hasNext()) {
			            if(st.get(i)>arr[i]) {
			            	ans[i] = st.peek();
			            }
			        }
				}
			}
			st.push(arr[i]);
		}
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,7,6,7};
        int n = arr.length;
        int x = 2;
        int ans[] = solve(n,x,arr);
        for(int i=0;i<n;i++) {
        	System.out.print(ans[i]+" ");
        }

	}

}
