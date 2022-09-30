package Stack;
import java.util.*;
public class MinStack {
	
	// using extra space
	static Stack<Integer> st = new Stack<>();
	static Stack<Integer> sst = new Stack<>();
	static int ans= 0;
	
	static void push(int val) {
        st.push(val);
        if(sst.size() == 0 || sst.peek() >= val){
            sst.push(val);
        }
    }

    static void pop() {
        if(st.size() == 0) return;
        ans = st.peek();
        st.pop();
        if(sst.peek() == ans){
            sst.pop();
        }
    }
    
    static int top() {
        return st.peek();
    }
    static int getMin() {
        if(sst.size() == 0) return -1;
        return sst.peek();
    }
    
	public static void main(String[] args) {
		int arr[] = {18,19,29,15,16};
		int n = arr.length;
		for(int i=0;i<n;i++) {
			push(arr[i]);
		}
		pop();
		System.out.println(top());
		System.out.println(getMin());
	}
}
