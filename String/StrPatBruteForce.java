package String;

public class StrPatBruteForce {
	
	static void bruteForce(String txt,String pat) {    //time comp:-O(n^2)
		int n=txt.length();
		int m=pat.length();
		int count=0;
		if((n==0 && m!=0) || (m==0 && n!=0)) {
			System.out.println("Invalid pattern and string combination");
		}
		for(int i=0;i<=n-m;i++) {
			for(int j=0;j<=m;j++) {
				if(j==m) {
					System.out.println("pattern found!!!");
					count++;
					break;
				}
				if(txt.charAt(i+j)!=pat.charAt(j)) {
					break;
				}
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		String txt="abcdabcdabsfghtwte";
		String pat="abc";
		bruteForce(txt,pat);

	}

}
