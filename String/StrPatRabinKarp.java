//Rabin-karp / Rolling-hash Algorithm
package String;

public class StrPatRabinKarp {      //O(mn)
	static int prime=3;
	
	//calculate hash value
	static int createHashVal(String str,int n) {
		int result=0;
		for(int i=0;i<n;i++) {
			result=result+str.charAt(i)*(int)Math.pow(prime,i);
		}
		return result;
	}
	
	//re-calculate hash value
	static int reCalculateHashvalue(String str,int oldIndex,int newIndex,int oldHashvalue,int patLength) {
		int newHashValue=oldHashvalue-str.charAt(oldIndex);
		newHashValue=newHashValue/prime;
		
		newHashValue=newHashValue+str.charAt(newIndex)*(int)Math.pow(prime, patLength-1);
		return newHashValue;
	}
	
	//check equal
	static boolean checkEqual(String str1,String str2,int start1,int end1,int start2,int end2) {
		while(start1<=end1 && start2<=end2) {
			if(str1.charAt(start1) != str2.charAt(start2)) {
				return false;
			}
			start1++;start2++;
		}
		return true;
	}

	public static void main(String[] args) {
		String str="abcbfghsnkwef";
		String pat="fgh";
		
		int patHashvalue=createHashVal(pat,pat.length());
		int strHashvalue=createHashVal(str,pat.length());
		
		for(int i=0;i<=str.length()-pat.length();i++) {
			if(patHashvalue==strHashvalue && checkEqual(str,pat,i,i+pat.length()-1,0,pat.length()-1)) {
				System.out.println("pattern found!!!");
				return;
			}
			
			strHashvalue=reCalculateHashvalue(str,i,i+pat.length()-1,strHashvalue,pat.length());
			
		}
		System.out.println("pattern not found!!!");

	}

}
