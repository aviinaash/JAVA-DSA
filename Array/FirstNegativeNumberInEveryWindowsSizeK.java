//Given an array and a positive integer k, find the first negative integer 
//for each and every window(contiguous subarray) of size k.
package Array;
import java.util.*;

public class FirstNegativeNumberInEveryWindowsSizeK {
	static void findFirstNegative1(int arr[],int k) {
		for(int i=0;i<arr.length-k+1;i++) {
			boolean flag=false;
			for(int j=i;j<i+k;j++) {
				if(arr[j]<0) {
					System.out.print(arr[j]+" ");
					flag=true;
					break;
				}
			}
			if(!flag) {
			System.out.print("0"+" ");
			}
		}
	}
	static void findFirstNegative2(int arr[],int k) {
		LinkedList<Integer> q = new LinkedList<>();
		int i=0;int j=0;
		while(j<arr.length) {
			if(arr[j]<0) {       
				q.add(arr[j]);  //adding -ve ele to list
			}
			if(j-i+1<k) {           //if size<given size
				j++;
			}
			else if(j-i+1==k) {        //if size==given size
				if(q.size()==0) {
					System.out.print("0"+" ");
				}
				else {
					System.out.print(q.peekFirst()+" "); //printing first ele of list
					q.remove();             //removing rest of the ele present in list
				}
//				if(!q.isEmpty() && arr[i]==q.peek()){
//	                 q.remove();
//	             }
				i++;
			}
		}
	}

	public static void main(String[] args) {
		//int arr[]= {12,-1,-7,8,-15,30,16,28};
		int arr[]= {-8,2,3,-6,10};
		int k=3;
		findFirstNegative1(arr,k);
		System.out.println();
		findFirstNegative2(arr,k);
	}

}


//  All possible SubArray    First -ve element of SubArray 
         //{12 -1 -7}            -1
         //{-1 -7 8}             -1
         //{-7 8 -15}            -7
         //{8 -15 30}            -15
         //{-15 30 16}           -15
         //{30 16 28}              0   <--- 0 if no -ve element present 

//            Ans=[-1 -1 -7 -15 -15 0]









