package Array;
import java.util.*;
public class MinMax {
	
	static void findminmax_1(int []arr) {
		Arrays.sort(arr);
		System.out.println("minimum "+arr[0]);
		System.out.println("maximum "+arr[arr.length-1]);
	}
	
	//using linear search
	static void findminmax_2(int []arr) {
		int max=arr[0];
		int min=arr[0];
		for(int i=1;i<arr.length-1;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
			if(arr[i]<min) {
				min=arr[i];
			}
		}
		System.out.println("minimum "+min);
		System.out.println("maximum "+max);
	}

	public static void main(String[] args) {
		int arr[]={5,2,1,0,4,101,7,9,6};
		//findminmax_1(arr);
		findminmax_2(arr);
		

	}

}
