package practice;

import java.util.Scanner;
class A
{
	static Scanner ob;
	public static void main(String[] args)
	 {
	    	ob = new Scanner(System.in);
	    	System.out.println(" Matrix 1 Enter the Number of Row");
	    	int row= ob.nextInt();
	    	System.out.println("Ente the number of column");
	    	int col=ob.nextInt();

	    	int arr[][]= new int[row][col];
	    	
	    	System.out.println("Enter the row number");
	    	int row1 =ob.nextInt();
	    	System.out.println("Enter the column  number");
	    	int col2=ob.nextInt();
	    	
	    	int arr2[][]= new int[row1][col2];
	    	
	    	acceptData(arr);
	    	acceptData2(arr);
	    	displayArray(arr);
	    	displayArray2(arr);
	    	addSum(arr,arr2);

	}
	
	static void acceptData2(int arr2[][])
	{
		for(int i=0;i<arr2.length;i++)
		{
			for(int j=0;j<arr2[i].length;j++)
			{
				arr2[i][j]=ob.nextInt();
			}
		}
		
	 }
	static void displayArray2(int arr2[][])
	{
		for(int i=0;i<arr2.length;i++)
		{
			for(int j=0;j<arr2[i].length;j++)
			{
				System.out.print(arr2[i][j]+ " ");
			}
			System.out.println();
			System.out.println();
		}
	}
          
	static void acceptData(int arr[][])
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				arr[i][j]=ob.nextInt();
			}
		}
	}
	static void displayArray(int arr[][])
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
			System.out.println();
		}
	}
	static void addSum(int arr[][],int arr2[][])
	{
		int sum=0;
          for(int i=0;i<arr.length;i++)
          {
        	  for(int j=0;j<arr[i].length;j++)
        	  {
        		  for(int k=0;k<arr2.length;k++)
        		  {
        			  for(int l = 0;l<arr2[k].length;l++)
        			  {
        				  sum = sum+ arr[i][j]+arr2[k][l];
        			  }
        		  }
        	  }
          }
          System.out.println(sum);
	 	}
}
