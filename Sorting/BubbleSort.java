package Sorting;

public class BubbleSort {
	
	static int[] bubbleSort(int arr[]) 
	{
		int n=arr.length;
		for(int i=0;i<n-1;i++) 
		{
			for(int j=0;j<n-i-1;j++) 
			{
				if(arr[j]>arr[j+1]) 
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for(int i=0;i<arr.length;i++) 
		{
			System.out.print(arr[i]+" ");
		}
		return arr;
	}

	public static void main(String[] args) {
		int arr[]= {10,2,7,-2,0,9,11,15};
		arr=bubbleSort(arr);

	}

}
