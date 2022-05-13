package practice;
import  java.util.Scanner;
public class FahToCel {

	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter temperature in degree Fahrenheit")  ;
		double fah= s.nextDouble();
		s.close();
		double cel;
		cel=(5*(fah-32))/9;
		System.out.println(cel);
		}

}
