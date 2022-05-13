package Array;

public class TwoNumberSum {
	static void twoNumberSum(int arr[], int sum) 
	{
		int left,right;
		left=0;
		right=arr.length-1;
		while(left<right) 
		{
			int sol=arr[left]+arr[right];
			if (sol==sum)
			{
				System.out.println("YES");
				return;
			}
			else if(sol<sum) {
				left++;
			}
			else if(sol>sum) {
				right--;
			}
		}
		System.out.println("NO");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,5,7,8,2,8,3,4};
		int sum=15;
		twoNumberSum(arr,sum);

	}

}
