package Array;
import java.util.*;
public class KSortedArray {
	
	static void kSortedArray(int arr[],int k,int n) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		int j=0;
		for (int i = 0; i < n; i++) {
	        minHeap.add(arr[i]);
	        if (minHeap.size() > k){
	        	arr[j++]=minHeap.peek();
	        	minHeap.poll();
		    }
	    }
		Iterator<Integer> itr = minHeap.iterator();
		 
        while (itr.hasNext()) {
            arr[j++] = minHeap.peek();
            minHeap.poll();
        }
	}

	public static void main(String[] args) {
		int arr[]= {6, 5, 3, 2, 8, 10, 9};
		int k=3;
		int n=arr.length;
		kSortedArray(arr,k,n);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
//	public static void main (String[] args) {
//		Scanner sc= new Scanner(System.in);
//		int t = sc.nextInt();
//		while(t-->0){
//		    int n= sc.nextInt();
//	        int k= sc.nextInt();
//	        int arr[] = new int[n];
//	        for(int i =0;i<n;i++){
//	            arr[i]=sc.nextInt();
//	        }
//	        kSortedArray(arr,k,n);
//	        for(int i =0;i<n;i++){
//	            System.out.print(arr[i]+" ");
//	        }
//	        System.out.println();
//		}
//	}

}
