package Array;
public class NextPermutation {
	
	public static void swap( int[] A, int i , int j){
        int temp = A[i];
        A[i] = A[j] ;
        A[j] = temp;        
    }
	public static void reverse( int[] A, int i , int j){
        while( i< j) {
        	swap(A, i++ , j--); 
        }
    }
	static void nextPermutation(int []arr) {
		if(arr == null || arr.length <= 1) {
			return;
		}
        int i = arr.length - 2;
        
        while(i >= 0 && arr[i] >= arr[i + 1]){     //ye loop reverse order me tab tak chalega jab tak ki usko
        	i--;                                   //apne se chhota element na mil jaye like 0-->7 tak chalega
        }                                          //bcoz 7>1, & i hamara as a pivot 1 pe hoga uss time
        
        if(i >= 0) {                           
            int j = arr.length - 1;              
            while(j>i && arr[j] <= arr[i]) {      //ye loop tab tak chalega jab tak j ko i se just bada number
            	j--;                              //na mil jaye & milne ke baad finally loop se nikal ke swap kar dega
            }
            swap(arr, i, j);                     
        }
        reverse(arr, i + 1, arr.length - 1);  
	}

	public static void main(String[] args) {            // 41-75320
		int arr[]= {4,1,7,5,3,2,0};                     //4-2-753-1-0
		nextPermutation(arr);                           //4201357 
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}

	}

}

//Input=[1,2,3]
//		
//Output:[
//        
//       [1,2,3]
//       [1,3,2]
//       [2,1,3] 
//       [2,3,1] 
//       [3,1,2]
//       [3,2,1]
//      
//        ]





















