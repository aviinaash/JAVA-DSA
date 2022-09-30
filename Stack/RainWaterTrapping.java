//https://www.geeksforgeeks.org/trapping-rain-water/
package Stack;

public class RainWaterTrapping {
	
	static int RWT(int arr[],int n) {
		int left[]=new int[n];
		left[0]=arr[0];
		for(int i=1;i<n;i++) {                 //finding left max of every index
			left[i]=Math.max(left[i-1], arr[i]);
		}
		
		int right[]=new int[n];
		right[n-1]=arr[n-1];
		for(int i=n-2;i>=0;i--) {             //finding right max of every index
			right[i]=Math.max(right[i+1], arr[i]);
		}
		
		int ans=0;
		for(int i=0;i<n;i++) {
			ans+=Math.min(left[i], right[i])-arr[i];
		}
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		int n = arr.length;
		System.out.println(RWT(arr,n));
	}

}
