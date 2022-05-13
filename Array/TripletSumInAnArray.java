package Array;

import java.util.*;

public class TripletSumInAnArray {
	
	static boolean find3Numbers1(int arr[],int x) {  ////O(n^3),O(1)
		for(int i=0;i<arr.length-2;i++) {
			for(int j=i+1;j<arr.length-1;j++) {
				for(int k=j+1;k<arr.length;k++) {
					if(arr[i]+arr[j]+arr[k]==x) {
						System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	static boolean find3Numbers2(int arr[],int x) {    //O(n^2),O(1)
		Arrays.sort(arr);
		for(int i=0;i<arr.length-1;i++) {
			int l=i+1;
            int r=arr.length-1;
            int m = arr[i];
            while(l<r) {
            	if(m+arr[l]+arr[r]==x) {
					System.out.println(m+" "+arr[l]+" "+arr[r]);
					l++;r--;
					return true;
				}
            	else if(m+arr[l]+arr[r]<x) {
            		l++;
            	}
            	else {
            		r--;
            	}
            }
		}
		return false;
	}
	static boolean find3Numbers3(int arr[],int x) {  //O(n^2),O(n)
		for(int i=0;i<arr.length-1;i++){
	         HashSet<Integer> set = new HashSet<>();
	         for(int j=i+1;j<arr.length;j++){
	        	 int y=x-(arr[i]+arr[j]);
	             if(set.contains(y)){
	            	 System.out.println(y+" "+arr[i]+" "+arr[j]);
	                 return true;
	             }
	             set.add(arr[j]);
	         }
	     }
	     return false;
	}

	public static void main(String[] args) {
		int arr[]= {1,4,45,6,10,8};
		int x=13;
		System.out.println(find3Numbers1(arr,x));
		System.out.println(find3Numbers2(arr,x));
		System.out.println(find3Numbers3(arr,x));
	}
}
