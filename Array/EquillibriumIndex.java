
package Array;

public class EquillibriumIndex {
	
	static int eqIndex0(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			int leftsum=0;
			for(int j=0;j<i;j++) {
				leftsum+=arr[i];
			}
			int rightsum=0;
			for(int j=i+1;j<arr.length;j++) {
				rightsum+=arr[i];
			}
			if(leftsum==rightsum) {
				return i;
			}
		}
		return -1;
	}
	
	static int eqIndex(int arr[]) {
		int mid = arr.length / 2;
	    int leftSum = 0, rightSum = 0;
	    for (int i = 0; i < mid; i++){
	        leftSum += arr[i];
	    }
	    for (int i = arr.length - 1; i > mid; i--){
	        rightSum += arr[i];
	    }
	    if (rightSum > leftSum){
	        while (rightSum > leftSum && mid < arr.length - 1){
	            rightSum -= arr[mid + 1];
	            leftSum += arr[mid];
	            mid++;
	        }
	    }
	    else{
	        while (leftSum > rightSum && mid > 0){
	            rightSum += arr[mid];
	            leftSum -= arr[mid - 1];
	            mid--;
	        }
	    }
	    if (rightSum == leftSum)
	    {
	        return mid;
	    }
		return -1;
	}

	public static void main(String[] args) {
		int A[] = {-7, 1, 5, 2, -4, 3, 0} ;
//		3 is an equilibrium index, because: 
//		A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
		System.out.println(eqIndex0(A));
		

	}

}
