package Array;
import java.util.*;
import java.math.BigInteger;
public class FindFactorial {

	static int factorial1(int n) {
		if (n == 0 || n == 1)
			return 1;
		return n * factorial1(n - 1);
	}
	static int factorial2(int n) {
		if (n == 0 || n == 1)
			return 1;
		int ans=Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			ans=ans*i;
		}
		return ans;
	}
	static ArrayList<Integer> factorial3(int n)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		int size=0,carry=0;
		list.add(0,1);                              // Adding 1 at 0th index
		size=1;                                      // Updating size
		int val=2;
		while(val<=n)
		{
			for(int i=size-1;i>=0;i--)            //traversing ryt to left of arraylist
			{
				int temp=list.get(i)*val + carry;    // Update value in arrayList
				list.set(i,temp%10);                // Store the last digit at index and add remaining to carry
				carry=temp/10;                    // update carry
			}
			while(carry!=0)                      // insert carry digit by digit to the begining of the ArrayList
			{
				list.add(0,carry%10);
				carry=carry/10;
				size++;
			}
			val++;
		}
		return list;
	}
	
	static BigInteger factorial(int n){
        BigInteger fac= new BigInteger("1");
         for (int i = 2; i <= n; i++) {
            fac = fac.multiply(BigInteger.valueOf(i));
         }
        return fac;
    }
	public static void main(String[] args) {
		int n=897;
		System.out.println(factorial1(n));
	}

}
