package Searching;
import java.util.*;
public class LinearSearch {
	
//	static void Linearsrch (int arr[] ,int target) {
//		int temp=0;
//		for(int i=0; i<arr.length;i++) {
//			if(target==arr[i]) {
//				System.out.println(i);
//				temp=temp+1;
//			}
//		}
//		if(temp==0) {
//		System.out.println("item not found!!");
//		}
//	}
//
//	public static void main(String[] args) {
//		int arr[] = {5,7,8,10,12,13};
//		Linearsrch(arr,7);
//	}

	public static String replaceCharacter(String input, char c1, char c2) {
        if (input.length() == 0) {
            return input;
        }
        String smallOutput=replaceCharacter(input.substring(1), c1, c2);
        if (input.charAt(0) == c1) {
            return c2 + small0utput;
        } 
        else {
            return input.charAt(0) + smal10utput;
        }
    }
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		char c1 = s.next().charAt(0);
		char c2 = s.next().charAt(0);
		System.out.println(LinearSearch.replaceCharacter(input, c1, c2));
	}
}
