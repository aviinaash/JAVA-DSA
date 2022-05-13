package Array;
import java.util.*;
public class ClosestNumInUnsortedArray {
	
	class Pair implements Comparable<Pair> {
		int key;
		int data;

		Pair(int key, int data) {
			this.key = key;
			this.data = data;
		}

		@Override
		public int compareTo(Pair o) {
			return this.key - o.key;
		}

	}
	static void kClosest(int arr[],int x,int k) {
		PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Pair());
		
		
		for (int i = 0; i < arr.length; i++) {
		      maxHeap.add(new Pair(Math.abs(x - arr[i]), arr[i]));

		      if (maxHeap.size() > k) {
		        maxHeap.poll();
		      }
		}
		 while (!maxHeap.isEmpty()) {
		      System.out.println(maxHeap.poll().data);
		  }
	}
	

	public static void main(String[] args) {
		int arr[] = {10, 2, 14, 4, 7, 6};
		int x = 5;
		int k = 3;
		

	}

}
