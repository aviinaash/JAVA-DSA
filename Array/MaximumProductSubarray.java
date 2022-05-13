package Array;

public class MaximumProductSubarray {
	static int maxProduct(int arr[]) {
		int max=arr[0];int min=arr[0];int ans=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==0) {
				max=1;min=1;
			}
			int temp1=arr[i]*max;
            int temp2=arr[i]*min;
            max=Math.max(Math.max(temp1,temp2), arr[i]);            
            min=Math.min(Math.min(temp1,temp2), arr[i]);            
            ans=Math.max(ans,max);
		}
		return ans;
	}

	public static void main(String[] args) {
		int arr[]= {6,-3,-10,0,2};
		System.out.println(maxProduct(arr));  //180
	} 

}
