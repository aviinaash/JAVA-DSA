package Array;

public class SortedSquareArrays {
	static int[] sumSquare (int arr[]) {
		int output[]=new int [arr.length];
		int left=0; int right=arr.length-1;
		int oo =output.length-1;
		while(left<right) {
			int Lvalue= Math.abs(arr[left]);
			int Rvalue= Math.abs(arr[right]);
			int max=Math.max(Lvalue,Rvalue);
			output[oo]=max*max;
			oo--;
			if (Lvalue>Rvalue) {
				left++;
			}
			else {
				right--;	
			}
			
		}
		output[oo]=arr[left]*arr[left];
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {-6,-2,0,2,4};
		int result[] = sumSquare(arr);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}

	}
}
