package Array;
import java.util.*;
public class SubarraywithZeroSum {

	static boolean subArrayExists(int []arr) {
		HashSet<Integer> res=new HashSet<>();
		int sum=0;
        for(int i=0;i<arr.length;i++) {
        	res.add(sum);
        	sum+=arr[i];
        	if(res.contains(sum)) {
        		return true;
        	}
        }
        return false;
	}
	public static void main(String[] args) {
		int arr[]= {4,2,-3,1,6};
		System.out.println(subArrayExists(arr));
	}

}
