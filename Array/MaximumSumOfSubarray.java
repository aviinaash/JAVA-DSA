//given:- array and size of subArray
//we have to find sum of all subarray of size k
//and return the maximum of sum
package Array;
public class MaximumSumOfSubarray {

	static int maxSum(int arr[],int k) {
		int maxSum=0;
		for(int i=0;i<arr.length-k;i++) {
			int sum =0;
			for(int j=i;j<i+k;j++) {
				sum+=arr[j];
			}
			maxSum=Math.max(maxSum, sum);
		}
		return maxSum;
	}
	static int maxSum2(int arr[],int k) {
		int i=0;int j=0;int sum=0;int maxSum=Integer.MIN_VALUE;
		while(j<arr.length) {
			sum+=arr[j];
			if(j-i+1<k) {
				j++;
			}
			else if(j-i+1==k) {
				maxSum=Math.max(maxSum, sum);
				sum=sum-arr[i];
				i++;j++;
			}
		}
		return maxSum;
	}
	public static void main(String[] args) {
		int arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20};
		int sizeofSubArray=4;
		System.out.println(maxSum(arr,sizeofSubArray));//39
		System.out.println(maxSum2(arr,sizeofSubArray));
	}
}


//All possible subarray of size 4 and its sum

//SubArray    sum
//1 4 2 10    17
//4 2 10 23   39<---answer
//2 10 23 3   38
//10 23 3 1   37
//23 3 1 0    27
//3 1 0 20    24
//          ---------
//        max sum=39






