//find union and intersection of two sorted Arrays
package Array;

public class UnionIntersectionSortedArrays {
	
	static void union (int arr1[],int arr2[]) {
		int result[] = new int[arr1.length + arr2.length];
		int i,j,k;
		i = 0; j = 0; k= 0;
		
//		while(i<arr1.length && j<arr2.length){  //if array is not sorted
//			if(arr1[i] < arr2[j]){
//				result[k] = arr1[i];
//				i++; k++;
//			}
//			else{
//				result[k] = arr2[j];
//				j++; k++;
//			}
//		}
		
		while(i<arr1.length){
			result[k] = arr1[i];
			i++; k++;
		}
		
		while(j < arr2.length){
			result[k] = arr2[j];
			j++; k++;
		}
		
		for(i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
	}
	
	static void intersection(int arr1[],int arr2[]) {
		int i,j,k,count;
		i = 0; j = 0; k= 0;count=0;
		int result[] = new int[arr1.length - arr2.length];
		
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i]>arr2[j]) {
				j++;
			}
			else if(arr1[i]<arr2[j]) {
				i++;
			}
			else{
				result[k] = arr1[i];
				i++;k++;j++;count++;
			}
		
		}
		System.out.println(count);
		for(i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
	}

	public static void main(String[] args) {
		int arr1[]={ 1, 3, 2, 3, 4, 5, 5, 6 };
		int arr2[]= { 3, 3, 5 };
		//union(arr1,arr2);
		//System.out.println();
		intersection(arr1,arr2);

	}

}
