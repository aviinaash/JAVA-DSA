package Sorting;

public class QuickSort {
	
	static int divide(int []arr,int left,int right) {
		
		int pivot=arr[(left+right)/2];
		while(left<=right) {
			while(arr[left]<pivot) {
				left++;
			}
			while(arr[right]>pivot) {
				right--;
			}
			if(left<=right) {
				int temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;right--;
			}
		}
		return left;
	}
	
	static void quicksort(int []arr,int low,int high) {
		if (low < high) 
	    {
	        int pi = divide(arr, low, high);
	        quicksort(arr, low, pi - 1);
	        quicksort(arr, pi + 1, high);
	    }
	}
	static void printArray(int[] arr)
	{
	    for(int i = 0; i < arr.length; i++)
	        System.out.print(arr[i] + " ");
	          
	    System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = {12,0,56,32,21,57};
	
		quicksort(arr,0,arr.length-1);
		
		printArray(arr);
		

	}

}
