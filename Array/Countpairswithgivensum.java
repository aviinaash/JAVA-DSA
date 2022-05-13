package Array;
import java.util.*;
public class Countpairswithgivensum {
	
	static int getPairsCount1(int arr[],int k) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]+arr[j]==k) {
					count++;
				}
			}
		}
		return count;
	}
	static int getPairsCount2(int arr[],int k) {
		int count=0;
		HashMap<Integer,Integer>map=new HashMap<>();
		map.put(0,1);
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			if(map.containsKey(sum-k)) {
				count+=map.get(sum-k);
			}
			map.put(sum,map.getOrDefault(sum,0)+1);
		}
		return count;
	}
	
	static int getPairsCount3(int arr[],int k) {
		int i=0;int j=i+1;int count=0;
		while(i<arr.length && j<arr.length) {
			if(arr[i]+arr[j]==k) {
				count++;
				break;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int arr[] = {1, 5, 7, 1};
		int k=6;
		System.out.println(getPairsCount1(arr,k));
		System.out.println(getPairsCount2(arr,k));
		System.out.println(getPairsCount3(arr,k));
	}

}
