package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class NearestGreaterToLeft {
	
	static void NGL1(int arr[],int n) {
		int max;
		for(int i=0;i<n;i++) {
			max = -1;
			for(int j=i-1;j>=0;j--) {
				if(arr[j]>arr[i]) {
					max = arr[j];
					break;
				}
			}
			System.out.print(max+" ");
		}
	}
	static void NGL2(int arr[],int n) {
		Stack <Integer> st = new Stack<>();
		ArrayList<Integer> li = new ArrayList<>();
		for(int i=0;i<n;i++) {
			if(st.isEmpty()) {
				li.add(-1);
			}
			else if(st.size()>0 && st.peek()  > arr[i]) {
				li.add(st.peek());
				//System.out.println(st.peek());
			}
			else if(st.size()>0 && st.peek() <= arr[i]) {
				while(st.size()>0 && st.peek() <= arr[i]) {
					st.pop();
				}
				if(st.isEmpty()) {
					li.add(-1);
				}
				else {
					li.add(st.peek());
				}
			}
			st.push(arr[i]);
		}
		for(int i=0;i<li.size();i++) {
			System.out.print(li.get(i)+" ");
		}
	}

	public static void main(String[] args) {
		int arr[] = {1,3,2,4};
		int n = arr.length;
		System.out.println("Brute force");
		NGL1(arr,n);
		System.out.println();
		System.out.println("Optimized output");
		NGL2(arr,n);
	}

}
