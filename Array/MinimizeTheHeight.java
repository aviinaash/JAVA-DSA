//Minimize the maximum difference between heights
//that means after adding or subtracting each element by k
//find the each possible maximum diff, and them minimize the diff 
package Array;
import java.util.*;
public class MinimizeTheHeight {
	
	static int getMinDiff(int arr[],int k,int n) {  //height can be -ve
		Arrays.sort(arr);
		int ans=arr[n-1]-arr[0];
		int smallest=arr[0]+k;
		int largest=arr[n-1]-k;
		int minHeight=0;int maxHeight=0;
		for(int i=0;i<n-1;i++) {
			minHeight=Math.min(smallest, arr[i+1]-k);
			maxHeight=Math.max(largest, arr[i]+k);
			if(minHeight<0) {
				continue;
			}
			ans=Math.min(ans, maxHeight-minHeight);
		}
		return ans;
	}
	
	static int getMinDiff1(int arr[],int k,int n) {
		Arrays.sort(arr);
		int ans=arr[n-1]-arr[0];
		int smallest=arr[0]+k;
		int largest=arr[n-1]-k;
		int min=0;int max=0;
		for(int i=0;i<n-1;i++) {
			min=Math.min(smallest, arr[i+1]-k);
			max=Math.max(largest, arr[i]+k);
//			if(min<0) {
//				continue;
//			}
			ans=Math.min(ans, max-min);
		}
		return ans;
	}

	public static void main(String[] args) {
		int arr[]={2 ,6,3,4,7, 2, 1,0, 3, 2, 1};
		int k=5;int n=arr.length;
		
		System.out.println(getMinDiff(arr,k,n));
		System.out.println(getMinDiff1(arr,k,n));

	}

}
