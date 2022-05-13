package Array;
import java.util.*;
public class Longestconsecutivesubsequence {
	static int findLongestConseqSubseq1(int arr[]) {
		Arrays.sort(arr);
		int count=0;int counter=1;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]-arr[i-1]==1) {
				count++;
			}
			else if(arr[i]-arr[i-1]!=0) { 
				count=1;
			}
			counter = Math.max(counter,count);
		}
		return counter+1;
	}
	static int findLongestConseqSubseq2(int arr[]) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<arr.length;i++){
			set.add(arr[i]);
		}
		int c=0;
		for(int i=0;i<arr.length;i++){
			if(!set.contains(arr[i]-1)){
				int val = arr[i]+1;
				while(set.contains(val)) {
					val++;
				}
				c=Math.max(c,val-arr[i]);
			}
		}
		return c;
	}

	public static void main(String[] args) {
		int arr[]={2,6,1,9,4,5,3};
		System.out.println(findLongestConseqSubseq1(arr));
		System.out.println(findLongestConseqSubseq2(arr));
	}

}
