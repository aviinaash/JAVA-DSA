//https://www.geeksforgeeks.org/next-greater-element/
package Stack;
import java.util.*;

public class NearestGreaterToRight {
	
	static void NGE(int arr[], int n)
    {
        int max;
        for (int i = 0; i < n; i++) {
            max = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    max = arr[j];
                    break;
                }
            }
            System.out.print(max+" ");
        }
    }
	
	static void NGE2(int arr[], int n) {
		Stack <Integer> st = new Stack<>();  
		ArrayList<Integer> li = new ArrayList<>();
		for(int i=n-1;i>=0;i--) {
			if(st.isEmpty()) {
				li.add(-1);
			}
			else if(st.size()>0 && st.peek() > arr[i]) {
				li.add(st.peek());
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
		for(int i=li.size()-1;i>=0;i--) {
			System.out.print(li.get(i)+" ");
		}
	}
	
	static long[] NGE3(long arr[], int n) {
		Stack <Long> st = new Stack<>();  
		long ans[] = new long[n];
		for(int i=n-1;i>=0;i--) {
			if(st.isEmpty()) {
				ans[i] = -1;
			}
			else if(st.size()>0 && st.peek() > arr[i]) {
				ans[i] = st.peek();
			}
			else if(st.size()>0 && st.peek() <= arr[i]) {
				while(st.size()>0 && st.peek() <= arr[i]) {
					st.pop();
				}
				if(st.isEmpty()) {
					ans[i] = -1;
				}
				else {
					ans[i] = st.peek();
				}
			}
			st.push(arr[i]);
		}
        //reverse(arr,n);
		return ans;
	}
	static void reverse(int a[], int n)
    {
        int t;
        for (int i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }

	public static void main(String[] args) {
		long arr[] = { 11, 13, 21, 3 };
		int  arr2[] = { 11, 13, 21, 3 };
        int n = arr.length;
        
        System.out.println("Brute Force output");
        NGE(arr2, n);
        System.out.println();
        
        System.out.println("Optimize using stack output");
        NGE2(arr2, n);
        
        System.out.println("using array");
        long ans[] = NGE3(arr,n);
        for(int i=0;i<n;i++) {
        	System.out.print(ans[i]+" ");
        }

	}

}
