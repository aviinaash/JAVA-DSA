package Array;

import java.util.Arrays;

public class CountInversion {
	
	static boolean isSorted(int[] arr) {
	    for (int i = 0; i < arr.length - 1; i++) {
	        if (arr[i] > arr[i + 1])
	            return false;
	    }
	    return true;
	}
	static boolean isSortedreverse(int[] arr) {
	    for (int i = 0; i < arr.length - 1; i++) {
	        if (arr[i] > arr[i + 1])
	            return true;
	    }
	    return false;
	}
	
	static int inversionCount1(int []arr) {    //simple brute force aproach
		int count=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					count++;
				}
			}
		}
		return count;
	}
	
//	static int inversionCount2(int []arr) {
////		if(isSorted(arr)) {
////			return 0;
////		}
////		else if(isSortedreverse(arr)) {
////			return Integer.MAX_VALUE;
////		}
////		else {
//			return Mergesort(arr,0,arr.length-1);
//		//}
//	}
	
	public static void main(String[] args) {
		int arr[] = {2, 4, 1, 3, 5};              //(2, 1), (4, 1), (4, 3)
		//System.out.println(inversionCount2(arr));  //3
		
		System.out.println(inversionCount1(arr));
	}

}
