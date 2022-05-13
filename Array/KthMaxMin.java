//Find kth max and kth min element of an array
package Array;
import java.util.*;
import java.util.Arrays;

public class KthMaxMin {
	
	static void kthmaxmin(int []arr,int k) {    // O(N Log N) 
		Arrays.sort(arr);
		System.out.println("kth min "+arr[k-1]);
		System.out.println("kth max "+arr[arr.length-k]);
	}
	
	static void kthsmallest(int []arr,int k) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {   //sorting an array
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
			if(i==k-1) {
				System.out.println(arr[i]+" ");
			}
		}
	}
	static int kthsmallest1(int arr[],int k) {    //Tc O(nlogk)
		//PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //by default
		//Max Heap: Using comparator to make it a max heap.
	    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
	    for (int i = 0; i < arr.length; i++) {
	        maxHeap.add(arr[i]);
	        if (maxHeap.size() > k) {
	          maxHeap.poll();
	        }
	    }
	    return maxHeap.peek();
	}

	public static void main(String[] args) {
		int arr[]= {2,5,6,1,7,9,4,3};       //1,2,3,4,5,6,7,9
		int k=3;
		kthmaxmin(arr,k);          //6
		
		kthsmallest(arr,k);
		System.out.println(kthsmallest1(arr,k));

	}

}
