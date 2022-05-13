package Array;

public class RearrangearrayinalternatingpositivenegativeitemswithOoneextraspace {
	
	static void rotate(int []arr,int start,int end) {
		int temp=arr[end];
		for(int i=end-1;i>=start;i--) {
			arr[i+1]=arr[i];
		}
		arr[start]=temp;
	}
	static int[] rearrange(int []arr) {
		int i=0,k=0,j=0;int n=arr.length;
		//i for neg and j for pos
		while((i<n) && (j<n) && (k<n)) {
			//checking at even index 
			//which should be -ve
			if(k%2==0) {
				if(arr[k]>=0) {              //check if +ve is present
					i=k;j=k;
					while(i<n && arr[i]>=0) {  //finding the first -ve number
						i++;
					}
					if(i>=n) {
						break;
					}
					rotate(arr,j,i);
				}
			}
			//checking at even index 
			//which should be +ve
			else {
				if(arr[k]<0) {             //check if -ve is present
					i=k;j=k;
					while(j<n && arr[j]<0) { //finding the first +ve number
						j++;
					}
					if(j>=n) {
						break;
					}
					rotate(arr,i,j);
				}
			}
			k++;
		}
		return arr;
	}

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, -4, -1, 4}; //{-4, 1, -1, 2, 3, 4}
		int result[]=rearrange(arr);
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
	}

}
