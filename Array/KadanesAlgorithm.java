package Array;

public class KadanesAlgorithm {
	
	static void MaxmSubarraySum1(int arr[]) {     //TC :- O(n^3)
		int maxSum=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				int sum=0;
				for(int k=i;k<=j;k++) {
					sum+=arr[k];
					if(sum>maxSum) {
						maxSum=sum;
					}
				}
			}
		}
		System.out.println(maxSum);
	}
	
	static void MaxmSubarraySum2(int arr[]) {    //TC :- O(n^2)
		int maxSum=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			int sum=0;
			for(int j=i;j<arr.length;j++) {
				sum+=arr[j];
				if(sum>maxSum) {
					maxSum=sum;
				}
			}
		}
		System.out.println(maxSum);
	}
	
	static void MaxmSubarraySum3(int arr[]) {  //kadanes algorithm
		int maxSum=Integer.MIN_VALUE;
		int maxEndinghere=0;
		for(int i=0;i<arr.length;i++) {
			maxEndinghere+=arr[i];
			if(maxSum<maxEndinghere) {
				maxSum=maxEndinghere;
			}
			if(maxEndinghere<0) {
				maxEndinghere=0;
			}
		}
		System.out.println(maxSum);
	}

	public static void main(String[] args) {
		int arr[]= {-2, -3, 4, -1, -2, 1, 5, -3};    //4 -1 -2 1 5 ,sum=7
		MaxmSubarraySum1(arr);
		MaxmSubarraySum2(arr);
		MaxmSubarraySum3(arr);

	}

}
