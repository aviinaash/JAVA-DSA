package practice;
import java.util.Scanner;
public class BinaryToDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int no=s.nextInt();
		 //count the no of digits
		int a=0;
		int b=0;
		while(no>0){
		              int c= no%10;
		              a=a+(c*(int)Math.pow(2, b++));
                              no=no/10;
		            
		            }
                  System.out.println(a);
		}

}
