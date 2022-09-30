package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallestToRight {

	static void NSTR1(int arr[], int n)
    {
        int min;
        for (int i = 0; i < n; i++) {
            min = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    min = arr[j];
                    break;
                }
            }
            System.out.print(min+" ");
        }
    }
	
	static void NSTR2(int arr[], int n) {
		Stack <Integer> st = new Stack<>();  
		ArrayList<Integer> li = new ArrayList<>();
		for(int i=n-1;i>=0;i--) {
			if(st.isEmpty()) {
				li.add(-1);
			}
			else if(st.size()>0 && st.peek() < arr[i]) {
				li.add(st.peek());
			}
			else if(st.size()>0 && st.peek() >= arr[i]) {
				while(st.size()>0 && st.peek() >= arr[i]) {
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
		for(int i=li.size()-1;i>=0;i--) {
			System.out.print(li.get(i)+" ");
		}
	}

	public static void main(String[] args) {
		int arr[] = { 11, 13, 21, 3 };
        int n = arr.length;
        
        System.out.println("Brute Force output");
        NSTR1(arr, n);
        System.out.println();
        
        System.out.println("Optimize using stack output");
        NSTR2(arr, n);
	}


}
