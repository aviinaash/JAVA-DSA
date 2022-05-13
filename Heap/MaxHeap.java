package Heap;

public class MaxHeap {
	static void insert(int arr[],int n,int i) {  //n=arr.length
		int max = i; 
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[max]) {
            max = left;
        }
        if (right < n && arr[right] > arr[max]) {
            left = right;
        }
        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
              insert(arr, n, max);
        }
	}
    static void maxheapusingArray(int arr[], int n) {
    	for (int i = (n/2)-1; i >= 0; i--) {
            insert(arr, n, i);
        }
    }
    static void printheap(int arr[],int n) {
    	for(int i=0;i<n;++i) {
    		System.out.print(arr[i]+" ");
    	}
    	System.out.println();
    }

	public static void main(String[] args) {
		int arr[]={ 1, 3, 5, 4, 6, 13, 10,9, 8, 15, 17 };
		int n=arr.length;
		maxheapusingArray(arr,n);
		printheap(arr,n);

	}

}
