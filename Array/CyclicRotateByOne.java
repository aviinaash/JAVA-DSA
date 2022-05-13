package Array;

public class CyclicRotateByOne {
	static void cyclicrotate(int arr[]) {
		int first = arr[arr.length-1];
        for(int i=arr.length-2; i>=0; i--){
            arr[i+1] = arr[i];
        }
        arr[0] = first;
        for(int i=0;i<arr.length;i++) {
        	System.out.print(arr[i]+" ");
        }
	}

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5};  //5,1,2,3,4
		cyclicrotate(arr);

	}

}
