//minimum number of jumps to reach the end
package DyanamicProgramming;

public class MinJump {
	
	static int minJump(int []arr) {
		int min[]=new int[arr.length];
		
		for(int j=0;j<arr.length;j++) {
			if(j==0) {
				min[j]=0;
			}
			else {
				min[j]=Integer.MAX_VALUE;
			}
			//System.out.print(min[j]+" ");
		}
		
		int i,j=0;
		for(i=0;i<arr.length;i++) {
			for(j=i+1;j<i+arr[i] && j<arr.length;j++) {
				min[j]=Math.min(1+min[i], min[j]);
			}
		}
		return arr[i];
	}

	public static void main(String[] args) {
		int arr[]= {1,2,3,1,2,4,1,2,1,2};
		System.out.println(minJump(arr));

	}

}
