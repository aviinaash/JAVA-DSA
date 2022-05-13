package practice;
import java.util.Arrays;
import java.util.Scanner;

 class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s =new Scanner(System.in);
		int t =s.nextInt();
		while(t-->0) {  // ye condition combined t-- and t>0
			int n=s.nextInt();
			int [] a=new int [n];
			int [] sq=new int [n];
			for(int i=0;i<n;i++) {
				a[i]=s.nextInt();
				sq[i]=a[i]*a[i];
			}
			Arrays.sort(sq);
			
			for (int element : sq) {  // ye array ka index p value  set krne k liye h sort kr k
				System.out.print(element); // ye array ko set krne k liye h
			}
			
		}

	}

}
