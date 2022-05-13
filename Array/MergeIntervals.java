package Array;

import java.util.*;

public class MergeIntervals {
	
	static int[][] merge(int[][] mat){
		List<int[]> res = new ArrayList<>();
		if(mat.length==0||mat==null)
            return res.toArray(new int[0][]);
		Arrays.sort(mat,(a, b) -> a[0] - b[0]);
		int start = mat[0][0];
        int end = mat[0][1];
		
        for(int i = 1; i < mat.length; i++) {
            if(mat[i][1] >= end) {
                end = mat[i][1];
            }
            else {
                res.add(new int[]{start, end});
                start = mat[i][0];
                end = mat[i][1];
            }
        }
        res.add(new int[]{start, end});
       return res.toArray(new int[res.size()][]);
	}

	public static void main(String[] args) {
		int mat[][]= {{1,3},                  //[[1,6],[8,10],[15,18]]
				      {2,6},                 //Since intervals [1,3] and [2,6] overlaps, 
				      {8,10},                //merge them into [1,6].
				      {15,18}};
		System.out.println("Before merging");
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<2;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("After merging");
		int [][]res=merge(mat);
		

	}

}

 
//         0     1    <----j
//
//   0     1     3
//   
//   1     2     6
//   
//   2     8     10
//      
//   3     15    18
//   
//   ^ 
//   |  
//   i
   
   
   