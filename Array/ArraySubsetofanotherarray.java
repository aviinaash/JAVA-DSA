package Array;
import java.util.*;
public class ArraySubsetofanotherarray {
	
	static void isSubset(int arr1[],int arr2[]) {
		HashSet<Integer> set=new HashSet<Integer>();
		for(int i=0;i<arr1.length;i++) {
			set.add(arr1[i]);
		}
		for(int j=0;j<arr2.length;j++) {
			if(!set.contains(arr2[j])) {
				System.out.println("NO");
			}
		}
		System.out.println("YES");
	}

	public static void main(String[] args) {
		int a1[] = {11, 1, 13, 21, 3, 7};
		int a2[] = {11, 3, 7, 1};
		isSubset(a1,a2);

	}

}
