package Stack;
import java.util.*;

public class MinStack2 {
	
	static Stack<Integer> st = new Stack<>();
	static int minEle;
	
	static void push(int val) {
		if(st.isEmpty()) {
			st.push(val);
			minEle = val;
		}
		else {
			if(val >= minEle) {
				st.push(val);
			}
			else if(val < minEle) {
				st.push(2*val-minEle);
				minEle = val;
			}
		}
	}
	
	static void pop() {
		if(st.isEmpty()) {
			return;
		}
		else {
			if(st.peek() >= minEle) {
				st.pop();
			}
			else if(st.peek() < minEle) {
				minEle = 2*minEle - st.peek();
				st.pop();
			}
		}
	}
	
	static int top() {
		if(st.isEmpty()) {
			return -1;
		}
		else {
			if(st.peek() >= minEle) {
				return st.peek();
			}
			else if(st.peek() < minEle) {
				return minEle;
			}
		}
        return st.peek();
    }
	static int getMin() {
		if(st.isEmpty()) {
			return -1;
		}
		return minEle;
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