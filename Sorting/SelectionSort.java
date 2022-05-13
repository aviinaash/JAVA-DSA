package Sorting;

public class SelectionSort {
	
	static void selectionsort (int arr[]) {
		int n=arr.length;
		for(int i=0;i<n-1;i++) 
		{
			int min=i;
			for(int j=i+1;j<n;j++) 
			{
				if(arr[j]<arr[min]) 
				{
					min=j;
				}
			}
			int temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
		}
	}

	public static void main(String[] args) {
		int arr[]= {22,12,64,25,11};
		selectionsort(arr);
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}


	}

}
