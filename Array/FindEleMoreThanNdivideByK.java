//Given an array of size n and a number k, 
//find all elements that appear more than n/k times
package Array;
import java.util.*;
public class FindEleMoreThanNdivideByK {

	static void moreThanNdK(int arr[], int n, int k) { //O(n^2),O(1)
		ArrayList < Integer > ans = new ArrayList < > ();
		for(int i=0;i<n;i++) {
			int count=1;
			for(int j=i+1;j<n;j++) {
				if(arr[j]==arr[i]) {
					count++;
				}
			}
			if(count>n/k) {
				ans.add(arr[i]);
			}
		}
		// 		for(int i=0;i<ans.size();i++){
		// 		    System.out.println(ans.get(i)+" ");
		// 		}
		System.out.println(Arrays.toString(ans.toArray()));
	}
	static void moreThanNdK1(int arr[], int n, int k) {
		Arrays.sort(arr);int c=0;
		for(int i=0;i<n-1;i++) {
			if(arr[i]==arr[i+1]) {
				c++;
			}
		}
		System.out.println(c);
	}
	static ArrayList < Integer > majorityElement(int arr[], int n,int k) { //O(n),O(n)
		HashMap < Integer, Integer > map = new HashMap < > ();    //(key,value)
		ArrayList < Integer > ans = new ArrayList < > ();
		//		for (int i = 0; i < n; i++) {
		//			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		//		}
		//		for (int val: map.keySet()) {
		//			if (map.get(val) > (n / k))
		//				ans.add(val);
		//		}
		//		return ans;
		
		for(int i=0;i<n;i++) {
			if (map.containsKey(arr[i])) {
				int count = map.get(arr[i])+1;
				if (count>n/k) {
					ans.add(arr[i]);
				} else {
					map.put(arr[i],count);
				}

			}
			else {
				map.put(arr[i],1);
			}
		}
		return ans;
	}
	static ArrayList < Integer > majorityElement2(int arr[], int n,int k) {//O(n),O(1)
		int number1 = -1, number2 = -1, count1 = 0, count2 = 0; n= arr.length;
		for (int i=0;i<n;i++) {                 //Boyer moore's voting Algo
			if (arr[i]==number1)
				count1++;
			else if (arr[i]==number2)
				count2++;
			else if (count1==0) {
				number1 = arr[i];
				count1 = 1;
			} else if (count2==0) {
				number2 = arr[i];
				count2 = 1;
			} 
			else {
				count1--;
				count2--;
			}
		}                                                         
		ArrayList < Integer > ans = new ArrayList < Integer > ();
		count1 = 0;
		count2 = 0;
		for (int i=0;i<n;i++) {
			if (arr[i]==number1)
				count1++;
			else if (arr[i]==number2)
				count2++;
		}
		if (count1>n/3)
			ans.add(number1);
		if (count2>n/3)
			ans.add(number2);
		return ans;
	}

	public static void main(String[] args) {
		int arr1[] = {3,1,2,2,1,2,3,3};
		int size = arr1.length;
		int k = 4;
		moreThanNdK(arr1,size,k);
		//moreThanNdK1(arr1,size,k);
		System.out.println(majorityElement(arr1,size,k));
		System.out.println(majorityElement2(arr1,size,k));
	}

}

//key   value
//1      2
//2      3
//3      3
//n=8,k=4
//n/k=2
//
//element >2= {2,3} bcoz it comes 3 times
















