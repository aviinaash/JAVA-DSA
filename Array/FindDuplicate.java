//Find duplicate of Array of n+1 integers
package Array;
import java.util.*;
public class FindDuplicate {
	
	static int findDuplicate1(int[] arr) {    //brute force
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return arr[i];
            }
        }
        return 0;
    }
	
	static int findDuplicate2(int[] arr) {    //using frequency array
        int n = arr.length;
        int freq[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (freq[arr[i]] == 0) {
                freq[arr[i]] += 1;
            } 
            else {
                return arr[i];
            }
        }
        return 0;
    }
	
	static int findDuplicate3(int arr[]) {
		int slow = arr[0];
        int fast = arr[0];
        do {
        	slow=arr[slow];
        	fast=arr[arr[fast]];
        }while(slow!=fast);
        fast=arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
	}
	
//	static int findDuplicate(int arr[]) {           //three pointer
//		int l=0;int n=arr.length-1;int r=n;int m=l+1;
//		if(arr.length==2) {
//			return arr[1];
//		}
//		while((l<r) && (l<m) && (m<r)) {
//			
//			if(arr[l]==arr[r]) {
//				return arr[l];
//			}
//			else if((arr[++m]==arr[l]) || ((arr[++m]==arr[r]))){
//				
//				return arr[m];
//			}
//			else {
//				l++;m++;r--;
//			}
//		}
//		return -1;
//	}

	public static void main(String[] args) {
		int arr[]= {1,3,4,2,2};
		System.out.println(findDuplicate3(arr)); //2

	}

}
