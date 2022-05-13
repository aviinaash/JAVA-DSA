package Sorting;

import java.util.Arrays;

public class MergeSort {
	static int[] merge(int left[], int right[]){
		int result[] = new int[left.length + right.length];
		int i,j,k;
		i = 0; j = 0; k= 0;
		while(i<left.length && j<right.length){
			if(left[i] < right[j]){
				result[k] = left[i];
				i++; k++;
			}
			else{
				result[k] = right[j];
				j++; k++;
			}
		}
		while(i<left.length){
			result[k] = left[i];
			i++; k++;
		}
		while(j < right.length){
			result[k] = right[j];
			j++; k++;
		}
		return result;
	}

	static int[] mergeSort(int arr[]){
		if(arr.length <= 1)
			return arr;

		int middle = arr.length/2;
		int left[] = Arrays.copyOfRange(arr,0,middle);     //breaking in to two array 
		int right[] = Arrays.copyOfRange(arr, middle, arr.length);

		int leftS[] = mergeSort(left);
		int rightS[] = mergeSort(right);

		return merge(leftS,rightS);
	}
	
	public static void main(String[] args) {
		int arr[] = {12,0,56,32,21,57};
		int ans [] = mergeSort(arr);           //0 12 21 32 56 57 

		for(int i = 0; i < ans.length; i++)
		{
			System.out.print(ans[i]+" ");
		}
	}

}
