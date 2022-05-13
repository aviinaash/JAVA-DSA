package String;

public class StrPatKmpAlgo {
	
	static int [] reset=new int[100];
	
	static void resetTable(String pat) {
		int i=0,j=-1;
		reset[0]=-1;
		while(i<pat.length()) {
			while(j>=0 && pat.charAt(i)!=pat.charAt(j)) {
				j=reset[j];
			}
			i++;
			j++;
			reset[i]=j;
		}
	}

	static void KMPsearch(String str,String pat) {    //O(m+n)
		resetTable(pat);
		int i=0,j=0;
		while(i<str.length()) {
			while(j>=0 && str.charAt(i)!=pat.charAt(j)) {
				j=reset[j];
			}
			i++;
			j++;
			if(j==pat.length()) {
				System.out.println("pattern found !!!");
				return;
			}
		}
		System.out.println("pattern not found !!!");
	}
	public static void main(String[] args) {
		String str="abcbfghsnkwef";
		String pat="few";
		
		KMPsearch(str,pat);

	}

}
