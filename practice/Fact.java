package practice;
import java.util.Scanner;
public class Fact {

	public static void main(String[] args) {
//		Scanner s=new Scanner(System.in);
//		int fact = s.nextInt();
//		for(int i=1;i<=fact;i) {
//			fact=fact*i;
//		}
//		System.out.println(fact);
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();	
		s.close();
		while(n%10 >= 1 ) {
			if(n>1) {
				int a = n%10;
			System.out.print(a);
			n = (n-a)/10;
			}
			else {
				System.out.print(n);
			}
		}
		
		
		// TODO Auto-generated method stub

	}

}
