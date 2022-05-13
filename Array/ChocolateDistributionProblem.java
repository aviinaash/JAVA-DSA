//find minimum difference between 
//maximum chocolates and minimum chocolates 
package Array;
import java.util.Arrays;
public class ChocolateDistributionProblem {

	static int findMinDiff(int arr[],int m,int n) {
		Arrays.sort(arr);
		int ans=Integer.MAX_VALUE;int i=0;int j=i+m-1;
		while(j<n) {
			if(arr[j]-arr[i]<ans){
				ans=arr[j]-arr[i];
			}
			i++;j++;
		}
		return ans;
	}
	public static void main(String[] args) {
		int []A = {3, 4, 1, 9, 56, 7, 9, 12};
		int m=5;int n=A.length;
		System.out.println(findMinDiff(A,m,n)); //6
	}

}

//       m=5
//        .
//1 3 4 7 9 9 12 56 



