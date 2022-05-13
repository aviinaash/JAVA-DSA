package String;

public class LevenstienDistance {

	static int EditDistance(String str1,String str2) {
		int [][] arr=new int[str1.length()+1][str2.length()+1];
		for(int i=0;i<str1.length()+1;i++) {
			for(int j=0;j<str2.length()+1;j++) {
				if(i==0) {
					arr[i][j]=j;
				}
				else if(j==0) {
					arr[i][j]=i;
				}
				else {
					if(str1.charAt(i-1)==str2.charAt(j-1)) {
						arr[i][j]=arr[i-1][j-1];
					}
					else {
						arr[i][j]=Math.min((Math.min(arr[i-1][j-1], arr[i][j-1])), arr[i-1][j])+1;
					}
				}
			}
		}
		return arr[str1.length()][str2.length()];
	}
	
	public static void main(String[] args) {
		String s1="june";
		String s2="july";
		
		System.out.println(EditDistance(s1,s2));//2

	}

}



//Algorithm

//      j   u    l              y   
//      
//   0  1   2    3              4
//   
//j  1  0   1    2(i-1,j-1)    3(i-1,j)
//
//u  2  1   0    1(i,j-1)      2(i,j)
//
//n  3  2   1    1              2
//
//e  4  3   2    2           |2|-->final answer
//









