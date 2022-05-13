//dutch national flag algorithm
//Given an array which consist of 0,1&2 only
//sort the array without using any sorting algorithm
package Array;
import java.util.Arrays;
public class SortingWithotAnyAlgo {
	
	static void sortArray0(int []arr) {      //Brute force  TC[O(nlogn)] & SC[O(1)]
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	static void sortArray1(int []arr) {         //Better    TC[O(n)] & SC[O(1)]
		int count0=0;int count1=0;int count2=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				count0++;
			}
			if(arr[i]==1) {
				count1++;
			}
			if(arr[i]==2) {
				count2++;
			}
		}
		//System.out.println(count0+" "+count1+" "+count2);
		int j=0;
		for(int i=0;i<count0;i++) {
			arr[j++]=0;
		}
		for(int i=0;i<count1;i++) {
			arr[j++]=1;
		}
		for(int i=0;i<count2;i++) {
			arr[j++]=2;
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	static void sortArray2(int[] arr) {   //Optimal
        int low = 0; 
        int high = arr.length - 1; 
        int mid = 0; 
        int temp; 
        while (mid <= high) { 
            switch (arr[mid]) { 
                case 0: { 
                    temp = arr[low]; 
                    arr[low] = arr[mid]; 
                    arr[mid] = temp; 
                    low++; 
                    mid++; 
                    break; 
                } 
                case 1: 
                    mid++; 
                    break; 
                case 2: { 
                    temp = arr[mid]; 
                    arr[mid] = arr[high]; 
                    arr[high] = temp; 
                    high--; 
                    break; 
                } 
            } 
        }
        for(int i=0;i<arr.length;i++) {
        	System.out.print(arr[i]+" ");
        }
    }

	public static void main(String[] args) {
		int arr[]= {1,0,2,1,1,0,2,1,0,1,0,2,0};
		
		//sortArray0(arr);
		sortArray1(arr);
		//sortArray2(arr);
	}

}











