package String;

public class StrPatZ_Algo {
	
	static String str="abcbfghsnkwef";
	static String pat="wef";
	
	static void ZArray(String str) {
		int z[]=new int[str.length()];
		z[0]=0;
		int len=str.length();
		int l=0,r=0;
		for(int i=1;i<len;i++) 
		{
			if(i>r) 
			{
				l=r=i;
				while(r<len && str.charAt(r)==str.charAt(r-l)) 
				{
					r++;
				}
				z[i]=r-l;
				r--;
			}
			else 
			{
				int relIndex=i-l;
				if(i+z[relIndex] <= r) 
				{
					z[i]=z[relIndex];
				}
				else
				{
					l=i;
					while(r<len && str.charAt(r)==str.charAt(r-l)) 
					{
						r++;
					}
					z[i]=r-l;
					r--;
				}
			}
		}
		for(int i=0;i<len;i++) {
			System.out.print(z[i]+" ");
		
			if(z[i] == pat.length()) {
				System.out.println("pattern found!!! at "+(i-pat.length()-1)+" index in string");
			}
		}
	}

	public static void main(String[] args) {
//		String str="abcbfghsnkwef";
//		String pat="few";
		
		String newString=pat+"$"+str;
		ZArray(newString);

	}

}
