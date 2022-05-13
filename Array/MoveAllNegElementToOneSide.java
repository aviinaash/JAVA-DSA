
//Move all negative numbers to beginning and positive to end with constant extra space
package Array;

import java.util.Arrays;

public class MoveAllNegElementToOneSide {
	
	static void moveNegative0(int []arr) {     ////Brute force  TC[O(nlogn)] & SC[O(1)]
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
        	System.out.print(arr[i]+" ");
        }
	}
	
	static void moveNegative1(int []arr) {      //partition process of quick sort 
		int j = 0, temp;                        //TC[O(n)]  & SC[O(1)]
        for (int i = 0; i <arr.length; i++) {
            if (arr[i] < 0) {
                if (i != j) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
        for(int i=0;i<arr.length;i++) {
        	System.out.print(arr[i]+" ");
        }
	}
	
	static void moveNegative2(int []arr) {     //two pointer approach
		int l=0;int r=arr.length-1;     //TC: O(N) SC: O(1)
		while(l<=r) {
			if (arr[l] > 0 && arr[r] < 0) {
				int temp = arr[l];
	            arr[l] = arr[r];
	            arr[r] = temp;
	            l++;
	            r--;
			}
			else if(arr[l] < 0 && arr[r] < 0) {
				l++;
			}
			else if(arr[l] > 0 && arr[r] > 0) {
				r--;
			}
			else {
				l++;
	            r--;
			}
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) {
		int arr[]= {-12, 11, -13, -5, 6, -7, 5, -3, -6};  //-12 -13 -5 -7 -3 -6 5 6 11
		moveNegative0(arr);
		System.out.println();
		moveNegative1(arr);
		System.out.println();
		moveNegative2(arr);
		

	}

}
